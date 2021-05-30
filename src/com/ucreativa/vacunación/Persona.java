package com.ucreativa.vacunación;

public class Persona {

    private String nombre;
    private String cedula;
    private int edad;
    private boolean riesgo;

    public Persona(String nombre, String cedula, int edad, boolean riesgo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.riesgo = riesgo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public Boolean getRiesgo() {
        return riesgo;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRiesgo(Boolean riesgo) {
        this.riesgo = riesgo;
    }

}
