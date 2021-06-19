package com.ucreativa.Proyecto.entities;

public class Alumno extends Persona {
    private String encargados; // Encargado si es un menor de edad


    public Alumno(String nombre, String cedula, String edad, Boolean padecimineto, String encargados) {
        super();
        this.encargados = encargados;

    }

    public String getencargados() {
        return encargados;
    }

}
