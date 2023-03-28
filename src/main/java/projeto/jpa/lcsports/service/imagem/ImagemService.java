package projeto.jpa.lcsports.service.imagem;

import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.models.BlobRequestConditions;
import com.azure.storage.blob.options.BlobParallelUploadOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class ImagemService {
    @Value("${azure.storage.connection-string}")
    private String connectionString;

    private BlobServiceClient blobServiceClient;

    private BlobHttpHeaders blobServiceHeaders;

    @PostConstruct
    public void initialize() {
        blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
    }

    public String uploadImage(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Extrai a extensão do arquivo
        String fileExtension = "";

        if (fileName.contains(".")) {
            fileExtension = fileName.substring(fileName.lastIndexOf("."));
        }

        String fileNameHash = UUID.randomUUID().toString().replaceAll("-", "") + fileExtension;


        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("imagens");
        containerClient.createIfNotExists();


        BlobClient blobClient = containerClient.getBlobClient(fileNameHash);

        BlobHttpHeaders jsonHeaders = new BlobHttpHeaders()
                .setContentType(file.getContentType());

        InputStream imageStream = file.getInputStream();
        BinaryData data = BinaryData.fromStream(imageStream, file.getSize());
        BlobParallelUploadOptions options = new BlobParallelUploadOptions(data)
                .setRequestConditions(new BlobRequestConditions()).setHeaders(jsonHeaders);

        blobClient.uploadWithResponse(options, null, Context.NONE);

        imageStream.close();

        return blobClient.getBlobUrl().toString();
    }


}
