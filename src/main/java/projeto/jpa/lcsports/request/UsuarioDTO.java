package projeto.jpa.lcsports.request;

public class UsuarioDTO {
    private String email;
    private String senha;

    public String getSenha() {
        return senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
