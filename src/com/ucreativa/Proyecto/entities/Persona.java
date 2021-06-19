package com.ucreativa.Proyecto.entities;

public class Persona {
    private String nombre;
    private String cedula;
    private String edad;
    private boolean padecimineto;

    public Persona() {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.padecimineto = padecimineto;
    }

    public String getNombre() {

        return nombre;
    }

    public String getCedula() {

        return cedula;
    }

    public String getEdad() {

        return edad;
    }

    public Boolean getpadecimineto() {

        return padecimineto;
    }
    public void setEdad(String edad) {

        this.edad = edad;
    }

    public void setpadecimineto(Boolean padecimineto) {

        this.padecimineto = padecimineto;
    }
}
