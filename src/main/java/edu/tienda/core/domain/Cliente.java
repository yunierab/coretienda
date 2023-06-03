package edu.tienda.core.domain;

public class Cliente
{
    private String username;
    private String pasword;
    private String nombre;

    public Cliente(String username, String pasword, String nombre)
    {
        this.username = username;
        this.pasword = pasword;
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
