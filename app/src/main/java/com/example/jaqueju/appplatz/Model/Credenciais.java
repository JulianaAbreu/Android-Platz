package com.example.jaqueju.appplatz.Model;

/**
 * Created by 15153766 on 21/10/2016.
 */

public class Credenciais {

    private String email;
    private String senha;

    public Credenciais(String email, String senha){
        this.email =email;
        this.senha =senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
