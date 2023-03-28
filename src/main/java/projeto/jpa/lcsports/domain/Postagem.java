package projeto.jpa.lcsports.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name = "postagem")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPostagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postagem")
    private Integer idPostagem;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_postagem")
    private LocalDateTime dataPostagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_costureira", referencedColumnName = "id_costureira")
    @JsonIdentityReference(alwaysAsId = true)
    private Costureira costureira;

    @OneToMany(mappedBy = "postagem")
    private List<CurtidaPostagem> curtidas;

    @OneToMany(mappedBy = "postagem")
    private List<Imagem> imagens;

    public Postagem(String titulo, String descricao, Costureira costureira) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.costureira = costureira;
        this.imagens = new ArrayList<>();
    }

    public Postagem() {
    }

    // getters e setters
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

    public void setDataPostagem() {
        this.dataPostagem = LocalDateTime.now();
    }

    public Costureira getCostureira() {
        return costureira;
    }

    public void setCostureira(Costureira costureira) {
        this.costureira = costureira;
    }

    public List<CurtidaPostagem> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<CurtidaPostagem> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
}
