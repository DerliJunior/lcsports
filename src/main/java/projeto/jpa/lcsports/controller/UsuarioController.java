package projeto.jpa.lcsports.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import projeto.jpa.lcsports.domain.Usuario;
import projeto.jpa.lcsports.repository.IUsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {
    private IUsuarioRepository _usuarioRepository;

    @Autowired
    public UsuarioController(IUsuarioRepository usuarioRepository) {
        _usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public void adicionarUsuario(@RequestBody Usuario usuario) {
        _usuarioRepository.save(usuario);

        System.out.println("Usuario cadastrado");

    }

    @GetMapping
    public List<Usuario> listarUsuarios() {

        return _usuarioRepository.findAll();
    }

}
