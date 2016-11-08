package com.example.jaqueju.appplatz.Model;

/**
 * Created by 15153766 on 04/11/2016.
 */

public class CurtidaCadastro {

    private String idEvento;
    private String idUsuario;

    public CurtidaCadastro(String idEvento, String idUsuario){
        this.setIdEvento(idEvento);
        this.setIdUsuario(idUsuario);
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
