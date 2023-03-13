package projeto.jpa.lcsports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.jpa.lcsports.domain.Postagem;

public interface IPostagemRepository extends JpaRepository<Postagem, Integer> {
}
