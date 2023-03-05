package projeto.jpa.lcsports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.jpa.lcsports.domain.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}

