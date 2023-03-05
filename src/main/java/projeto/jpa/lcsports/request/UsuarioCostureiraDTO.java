package projeto.jpa.lcsports.request;

import projeto.jpa.lcsports.domain.Costureira;
import projeto.jpa.lcsports.domain.Usuario;

import java.time.LocalDate;

public class UsuarioCostureiraDTO {
    private Usuario usuario;
    private Costureira costureira;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Costureira getCostureira() {
        return costureira;
    }

    public void setCostureira(Costureira costureira) {
        this.costureira = costureira;
    }
}
