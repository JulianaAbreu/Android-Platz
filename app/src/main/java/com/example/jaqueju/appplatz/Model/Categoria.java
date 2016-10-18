package com.example.jaqueju.appplatz.Model;

/**
 * Created by 15153818 on 29/09/2016.
 */
public class Categoria {

    private String id;
    private String nome;
    private String dataCadastro;
    private String caminhoIcone;
    private String deletado;

    //Construtores
    public Categoria() {

    }

    public Categoria(String id, String nome, String dataCadastro, String caminhoIcone, String deletado) {
        setId(id);
        setNome(nome);
        setDataCadastro(dataCadastro);
        setCaminhoIcone(caminhoIcone);
        setDeletado(deletado);
    }

    //Getters and Setters
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

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCaminhoIcone() {
        return caminhoIcone;
    }

    public void setCaminhoIcone(String caminhoIcone) {
        this.caminhoIcone = caminhoIcone;
    }

    public String getDeletado() {
        return deletado;
    }

    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
}

