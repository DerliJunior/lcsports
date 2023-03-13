package projeto.jpa.lcsports.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;

@Entity
@Table(name = "imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Integer idImagem;

    @Column(name = "codigo_imagem")
    private String codigoImagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_postagem", referencedColumnName = "id_postagem")
    @JsonIdentityReference(alwaysAsId = true)
    private Postagem postagem;

    // getters e setters


    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getCodigoImagem() {
        return codigoImagem;
    }

    public void setCodigoImagem(String codigoImagem) {
        this.codigoImagem = codigoImagem;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
}
