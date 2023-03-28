package projeto.jpa.lcsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.jpa.lcsports.domain.Usuario;
import projeto.jpa.lcsports.repository.IUsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {
    private IUsuarioRepository _usuarioRepository;

    @Autowired
    public UsuarioController(IUsuarioRepository usuarioRepository) {
        _usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Void> adicionarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCadastrado = _usuarioRepository.save(usuario);

        return ResponseEntity.created(null).build();

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = _usuarioRepository.findAll();

        if (usuarios.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> consultarUsuario(@PathVariable int idUsuario) {
        Optional<Usuario> usuario = _usuarioRepository.findById(idUsuario);

        if (usuario.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(usuario.get());
    }

}
