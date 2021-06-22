package com.ucreativa.vacunación.services;

public class ContadorRiesgo {

    private int cantidadRiesgo;
    private static ContadorRiesgo instancia;

    public static ContadorRiesgo getInstance(){
        if(instancia == null){
            instancia = new ContadorRiesgo ();
        }
        return instancia;
    }
    public void SumarRiesgo(){
        this.cantidadRiesgo++;
    }
    public int getCantidadRiesgo(){
        return this.cantidadRiesgo;
    }
}
