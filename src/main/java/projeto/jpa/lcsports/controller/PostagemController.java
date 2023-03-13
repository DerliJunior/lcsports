package projeto.jpa.lcsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.jpa.lcsports.domain.Costureira;
import projeto.jpa.lcsports.domain.Imagem;
import projeto.jpa.lcsports.domain.Postagem;
import projeto.jpa.lcsports.repository.ICostureiraRepository;
import projeto.jpa.lcsports.repository.IImagemRepository;
import projeto.jpa.lcsports.repository.IPostagemRepository;

import java.util.Optional;

@RestController
@RequestMapping("v1/postagens")
public class PostagemController {

    private IPostagemRepository _postagemRepository;
    private ICostureiraRepository _costureiraRepository;
    private IImagemRepository _imagemRepository;

    @Autowired
    public PostagemController(IPostagemRepository postagemRepository,
                              ICostureiraRepository costureiraRepository,
                              IImagemRepository imagemRepository) {
        _postagemRepository = postagemRepository;
        _costureiraRepository = costureiraRepository;
        _imagemRepository = imagemRepository;
    }

    @PostMapping("{idCostureira}")
    public ResponseEntity<Postagem> adicionarPostagem(@PathVariable int idCostureira,
                                                      @RequestBody Postagem postagem) throws InterruptedException {
        Postagem novaPostagem = new Postagem();

        Optional<Costureira> costureira = _costureiraRepository.findById(idCostureira);

        if (costureira.isPresent()) {
            System.out.println(costureira.get());

            novaPostagem.setCostureira(costureira.get());
            novaPostagem.setDescricao(postagem.getDescricao());
            novaPostagem.setTitulo(postagem.getTitulo());

            _postagemRepository.save(novaPostagem);

            System.out.println(novaPostagem.getIdPostagem());


            for (int i = 0; i < postagem.getImagens().size(); i++) {
                Imagem novaImagem = new Imagem();
                novaImagem.setPostagem(novaPostagem);
                novaImagem.setCodigoImagem(postagem.getImagens().get(i).getCodigoImagem());

                _imagemRepository.save(novaImagem);

                System.out.println(i);
                System.out.println(novaImagem.getIdImagem());


                novaPostagem.getImagens().add(novaImagem);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(novaPostagem);
        }

        System.out.println("Não deu certo");
        return ResponseEntity.badRequest().build();
    }
}
