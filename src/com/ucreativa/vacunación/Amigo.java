package com.ucreativa.vacunación;

public class Amigo extends Persona {

    private String relacion;
    private String facebook;

    public Amigo(String nombre, String cedula, int edad, Boolean riesgo, String relacion, String facebook) {
        super(nombre, cedula, edad, riesgo);
        this.relacion = relacion;
        this.facebook = facebook;
    }

    public String getRelacion() {
        return relacion;
    }

    public String getFacebook() {
        return facebook;
    }
}
