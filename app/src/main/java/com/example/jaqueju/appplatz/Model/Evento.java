package com.example.jaqueju.appplatz.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 15153770
 */
public class Evento {

    private String id;
    private String nome;
    private String detalhes;
    private String imagemCapa;
    private int idade;
    private String dataInicio;
    private String dataFim;
    private int lotacaoMin;
    private int lotacaoMax;
    private Double preco;
    private Empresa empresa;
    private ArrayList<Categoria> categorias;
    private ArrayList<Imagem> imagens;
    private String cancelado;
    private String censurado;
    private boolean destaque;
    private String dataCadastro;

    public Evento() {
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

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(ArrayList<Imagem> imagens) {
        this.imagens = imagens;
    }

    public String getCancelado() {
        return cancelado;
    }

    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    public String getCensurado() {
        return censurado;
    }

    public void setCensurado(String censurado) {
        this.censurado = censurado;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getLotacaoMin() {
        return lotacaoMin;
    }

    public void setLotacaoMin(int lotacaoMin) {
        this.lotacaoMin = lotacaoMin;
    }

    public int getLotacaoMax() {
        return lotacaoMax;
    }

    public void setLotacaoMax(int lotacaoMax) {
        this.lotacaoMax = lotacaoMax;

    }

    public String getImagemCapa() {
        return imagemCapa;
    }

    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }

}
