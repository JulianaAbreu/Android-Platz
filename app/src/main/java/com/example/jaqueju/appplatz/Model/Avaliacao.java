package com.example.jaqueju.appplatz.Model;

/**
 *
 * @author 15153770
 */
public class Avaliacao {

    private String id;
    private Integer nota;
    private Usuario usuario;
    private Evento evento;
    private String dataCadastro;

    public Avaliacao() {
    }

    public Avaliacao(String id, Integer nota, Usuario usuario, Evento evento, String dataCadastro) {
        setId(id);
        setNota(nota);
        setUsuario(usuario);
        setUsuario(usuario);
        setDataCadastro(dataCadastro);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
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

}
