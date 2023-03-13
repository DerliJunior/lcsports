package projeto.jpa.lcsports.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "curtida_costureira")
public class CurtidaCostureira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curtida_costureira")
    private Integer idCurtidaCostureira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_costureira", referencedColumnName = "id_costureira")
    private Costureira costureira;

    // getters e setters
}
