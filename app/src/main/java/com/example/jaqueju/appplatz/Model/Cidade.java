package com.example.jaqueju.appplatz.Model;

/**
 *
 * @author 15153770
 */
public class Cidade {

    private String id;
    private String nome;
    private Estado estado;
    private String dataCadastro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estadoLeitura) {
        this.estado = estadoLeitura;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
