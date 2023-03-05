package projeto.jpa.lcsports.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Costureira")
@CrossOrigin
public class Costureira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCostureira")
    private int idCostureira;

    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @NotNull
    private Usuario usuario;

//    public Usuario getUsuario() {
//        return usuario;
//    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdCostureira() {
        return idCostureira;
    }

    public void setIdCostureira(int idCostureira) {
        this.idCostureira = idCostureira;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

}
