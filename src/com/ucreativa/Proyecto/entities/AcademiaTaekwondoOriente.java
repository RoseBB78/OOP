package com.ucreativa.Proyecto.entities;

import java.util.Date;

public class AcademiaTaekwondoOriente {
    public AcademiaTaekwondoOriente(Persona persona, String cinturon, Date fecha) {
        this.persona = persona;
        this.cinturon = cinturon;
        this.fecha = fecha;
    }

    private Persona persona;
    private String cinturon;
    private Date fecha;

    public Persona getPersona(){
        return persona;
    }
    public String getcinturon(){
        return cinturon;
    }
    public Date getFecha(){
        return fecha;
    }
}
