package projeto.jpa.lcsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.jpa.lcsports.domain.Postagem;
import projeto.jpa.lcsports.repository.IImagemRepository;
import projeto.jpa.lcsports.response.PostagemDTO;
import projeto.jpa.lcsports.service.postagem.IPostagemService;

@RestController
@RequestMapping("v1/postagens")
public class PostagemController {

    private IImagemRepository _imagemRepository;
    private IPostagemService _postagemService;

    @Autowired
    public PostagemController(IPostagemService postagemService,
                              IImagemRepository imagemRepository) {
        _postagemService = postagemService;
        _imagemRepository = imagemRepository;
    }

    @PostMapping("{idCostureira}")
    public ResponseEntity<PostagemDTO> adicionarPostagem(@PathVariable int idCostureira,
                                                         @RequestBody Postagem postagem) {

        Postagem publicacao = _postagemService.adicionarPostagem(idCostureira, postagem);

        return ResponseEntity.created(null).body(new PostagemDTO(publicacao));
    }
}
