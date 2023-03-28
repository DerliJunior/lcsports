package projeto.jpa.lcsports.service.postagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.jpa.lcsports.domain.Costureira;
import projeto.jpa.lcsports.domain.Imagem;
import projeto.jpa.lcsports.domain.Postagem;
import projeto.jpa.lcsports.repository.ICostureiraRepository;
import projeto.jpa.lcsports.repository.IImagemRepository;
import projeto.jpa.lcsports.repository.IPostagemRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostagemService implements IPostagemService {


    private IPostagemRepository _postagemRepository;
    private ICostureiraRepository _costureiraRepository;
    private IImagemRepository _imagemRepository;


    @Autowired
    public PostagemService(IPostagemRepository _postagemRepository,
                           ICostureiraRepository _costureiraRepository,
                           IImagemRepository imagemRepository) {
        this._postagemRepository = _postagemRepository;
        this._costureiraRepository = _costureiraRepository;
        this._imagemRepository = imagemRepository;
    }

    public Postagem adicionarPostagem(int idCostureira, Postagem novaPostagem) {

        Optional<Costureira> costureira = _costureiraRepository.findById(idCostureira);

        if (costureira.isEmpty()) throw new NoSuchElementException();

        Postagem postagem = new Postagem(novaPostagem.getTitulo(), novaPostagem.getDescricao(), costureira.get());

        _postagemRepository.save(postagem);

        for (Imagem urlImagem : novaPostagem.getImagens()) {
            Imagem imagem = new Imagem(urlImagem.getCodigoImagem(), postagem);

            _imagemRepository.save(imagem);

            postagem.getImagens().add(imagem);
        }

        return postagem;
    }
}
