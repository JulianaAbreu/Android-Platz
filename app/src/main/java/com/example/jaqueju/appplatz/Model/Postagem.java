package com.example.jaqueju.appplatz.Model;

import java.util.List;

/**
 *
 * @author 15153770
 */
public class Postagem {
    
    private String id;
    private String conteudo;
    private Conta conta;
    private Evento evento;
    private String dataCadastro;
    private String deletado;
    private String censurado;
    private List<Imagem> imagens;
    
    public Postagem() {
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getConteudo() {
        return conteudo;
    }
    
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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
    
    public String getDeletado() {
        return deletado;
    }
    
    public void setDeletado(String deletado) {
        this.deletado = deletado;
    }
    
    public String getCensurado() {
        return censurado;
    }
    
    public void setCensurado(String censurado) {
        this.censurado = censurado;
    }
    
    public Conta getConta() {
        return conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public List<Imagem> getImagens() {
        return imagens;
    }
    
    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    
}
