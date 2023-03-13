package projeto.jpa.lcsports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.jpa.lcsports.domain.Imagem;

public interface IImagemRepository extends JpaRepository<Imagem, Integer> {
}
