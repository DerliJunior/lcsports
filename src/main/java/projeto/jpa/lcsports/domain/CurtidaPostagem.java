package projeto.jpa.lcsports.domain;

import projeto.jpa.lcsports.domain.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "curtida_postagem")
public class CurtidaPostagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curtida")
    private Integer idCurtida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_postagem", referencedColumnName = "id_postagem")
    private Postagem postagem;

    // getters e setters
}
