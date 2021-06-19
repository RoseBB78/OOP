package com.ucreativa.Proyecto.ui;

import com.ucreativa.Proyecto.entities.Alumno;
import com.ucreativa.Proyecto.entities.Persona;

public class ErrorEnAlumnoException extends Exception{

    public ErrorEnAlumnoException(String alumno) {
        super("El alumno ya existe: " + alumno);
        Persona persona = new Persona();
        if (alumno.equals (persona)) {
            persona.getNombre ();
        }
    }
}
