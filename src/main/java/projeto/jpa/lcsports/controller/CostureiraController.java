package projeto.jpa.lcsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.jpa.lcsports.domain.Costureira;
import projeto.jpa.lcsports.domain.Usuario;
import projeto.jpa.lcsports.repository.ICostureiraRepository;
import projeto.jpa.lcsports.repository.IUsuarioRepository;
import projeto.jpa.lcsports.request.UsuarioCostureiraDTO;

import java.util.List;

@RestController
@RequestMapping("v1/costureiras")
public class CostureiraController {
    private ICostureiraRepository costureiraRepository;
    private IUsuarioRepository usuarioRepository;

    @Autowired
    public CostureiraController(ICostureiraRepository costureiraRepository, IUsuarioRepository usuarioRepository) {
        this.costureiraRepository = costureiraRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarCostureira(@RequestBody UsuarioCostureiraDTO costureira) {
        Usuario usuario = new Usuario();
        Costureira novaCostureira = new Costureira();

        if (costureira.getCostureira() != null) {

            usuario.setNome(costureira.getUsuario().getNome());
            usuario.setEmail(costureira.getUsuario().getEmail());
            usuario.setSenha(costureira.getUsuario().senha());
            usuario.setDataNascimento(costureira.getUsuario().getDataNascimento());
            usuario.setCep(costureira.getUsuario().getCep());
            usuario.setUf(costureira.getUsuario().getUf());
            usuario.setCidade(costureira.getUsuario().getCidade());
            usuario.setTelefone(costureira.getUsuario().getTelefone());
            usuario.setAtivo(costureira.getUsuario().isAtivo());
//            usuario.setCostureira(costureira.getCostureira());

            System.out.println(usuario.getIdUsuario());

            usuarioRepository.save(usuario);

            System.out.println(usuario.getIdUsuario());

            novaCostureira.setUsuario(usuario);
            novaCostureira.setLatitude(costureira.getCostureira().getLatitude());
            novaCostureira.setLongitude(costureira.getCostureira().getLongitude());

            costureiraRepository.save(novaCostureira);

            usuario.setCostureira(novaCostureira);
            return ResponseEntity.created(null).body(usuario);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Costureira>> listarCostureiras(){
        List<Costureira> listaCostureiras = costureiraRepository.findAll();

        return ResponseEntity.ok(listaCostureiras);
    }
}
