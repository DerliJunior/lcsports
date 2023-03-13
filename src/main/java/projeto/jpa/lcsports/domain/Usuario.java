package projeto.jpa.lcsports.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "telefone")
    private String telefone;


    @Column(name = "uf")
    private String uf;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Costureira costureira;

    @OneToMany(mappedBy = "usuario")
    private List<CurtidaCostureira> curtidasCostureiras;

    @OneToMany(mappedBy = "usuario")
    private List<CurtidaPostagem> curtidasPostagens;

    // getters e setters
    public Usuario() {
    }

    public Usuario(Boolean ativo, String cep, String cidade, LocalDate dataNascimento, String email, String nome, String senha, String telefone, String uf) {
        this.ativo = ativo;
        this.cep = cep;
        this.cidade = cidade;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.uf = uf;
    }

    public Costureira getCostureira() {
        return costureira;
    }

    public void setCostureira(Costureira costureira) {
        this.costureira = costureira;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String senha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<CurtidaCostureira> getCurtidasCostureiras() {
        return curtidasCostureiras;
    }

    public void setCurtidasCostureiras(List<CurtidaCostureira> curtidasCostureiras) {
        this.curtidasCostureiras = curtidasCostureiras;
    }

    public List<CurtidaPostagem> getCurtidasPostagens() {
        return curtidasPostagens;
    }

    public void setCurtidasPostagens(List<CurtidaPostagem> curtidasPostagens) {
        this.curtidasPostagens = curtidasPostagens;
    }

    public boolean isEqualsSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }
}
