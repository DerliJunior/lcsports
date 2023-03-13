package projeto.jpa.lcsports.domain;

import javax.persistence.*;

@Entity
@Table(name = "competencia")
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competencia")
    private Integer idCompetencia;

    @Column(name = "competencia")
    private String competencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_costureira", referencedColumnName = "id_costureira")
    private Costureira costureira;

    // getters e setters
}
