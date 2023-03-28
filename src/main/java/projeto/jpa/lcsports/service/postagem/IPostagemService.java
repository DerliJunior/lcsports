package projeto.jpa.lcsports.service.postagem;

import projeto.jpa.lcsports.domain.Postagem;

public interface IPostagemService {
    public Postagem adicionarPostagem(int idCostureira, Postagem novaPostagem);
}
