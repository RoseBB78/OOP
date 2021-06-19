package com.ucreativa.vacunación.entities;

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

    public void setRelacion(String relacion) {
        this.relacion = relacion;}

    public String getFacebook() {
        return facebook;
    }

    //public void setFacebook(String facebook) { this.facebook = facebook;}

    public String toString(){
        return  super.getNombre();}
}
