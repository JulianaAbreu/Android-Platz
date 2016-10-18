package com.example.jaqueju.appplatz.Model;

/**
 *
 * @author Anderson
 */
public class Curtida {

    private String id;
    private boolean curtido;
    private Usuario usuario;
    private Evento evento;
    private String dataCadastro;

    public Curtida() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isCurtido() {
        return curtido;
    }

    public void setCurtido(boolean curtido) {
        this.curtido = curtido;
    }

}
