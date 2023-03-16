package projeto.jpa.lcsports.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import projeto.jpa.lcsports.service.ImagemService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("v1/imagens")
public class ImagemController {
    @Autowired
    private ImagemService imagemService;

    public ImagemController(ImagemService imagemService) {
        this.imagemService = imagemService;
    }

    @PostMapping
    public ResponseEntity<String> uploadImagemPublicacao(@RequestParam("teste") MultipartFile file){

        try{
            String imageUrl = imagemService.uploadImage(file);

            return ResponseEntity.created(null).body(imageUrl);

        }catch (IOException e){
            System.out.println(e.getCause());
            return ResponseEntity.internalServerError().build();
        }

    }

}
