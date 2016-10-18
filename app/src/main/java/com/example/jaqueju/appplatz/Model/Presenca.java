package com.example.jaqueju.appplatz.Model;

/**
 *
 * @author 15153770
 */
public class Presenca {

    private String id;
    private Evento evento;
    private Conta conta;
    private String tipoPresenca;
    private String dataCadastro;

    public Presenca() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getTipoPresenca() {
        return tipoPresenca;
    }

    public void setTipoPresenca(String tipoPresenca) {
        this.tipoPresenca = tipoPresenca;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
