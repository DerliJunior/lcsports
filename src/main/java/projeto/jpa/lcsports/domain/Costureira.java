package projeto.jpa.lcsports.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "costureira")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCostureira")
public class Costureira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costureira")
    private Integer idCostureira;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonIdentityReference(alwaysAsId = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "costureira")
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "costureira")
    private List<CurtidaCostureira> curtidas;

    @OneToMany(mappedBy = "costureira")
    private List<Competencia> competencias;



    // getters e setters


    public Integer getIdCostureira() {
        return idCostureira;
    }

    public void setIdCostureira(Integer idCostureira) {
        this.idCostureira = idCostureira;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public List<CurtidaCostureira> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<CurtidaCostureira> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }
}
