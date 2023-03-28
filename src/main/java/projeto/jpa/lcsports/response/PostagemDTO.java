package projeto.jpa.lcsports.response;

import projeto.jpa.lcsports.domain.Imagem;
import projeto.jpa.lcsports.domain.Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostagemDTO {
    private Integer idCostureira;
    private Integer idPostagem;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPostagem;
    private List<Imagem> imagens;

    public PostagemDTO(Postagem postagem) {
        this.idCostureira = postagem.getCostureira().getIdCostureira();
        this.idPostagem = postagem.getIdPostagem();
        this.titulo = postagem.getTitulo();
        this.descricao = postagem.getDescricao();
        this.dataPostagem = postagem.getDataPostagem();
        this.imagens = new ArrayList<>(postagem.getImagens());
    }

    public Integer getIdCostureira() {
        return idCostureira;
    }

    public void setIdCostureira(Integer idCostureira) {
        this.idCostureira = idCostureira;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDateTime dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
}
