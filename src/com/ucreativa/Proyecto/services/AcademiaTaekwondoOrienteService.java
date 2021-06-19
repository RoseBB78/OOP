package com.ucreativa.Proyecto.services;
import com.ucreativa.Proyecto.entities.Alumno;
import com.ucreativa.Proyecto.entities.Encargado;
import com.ucreativa.Proyecto.entities.Persona;
import com.ucreativa.Proyecto.repositories.RepositoryAcademia;
import com.ucreativa.Proyecto.ui.ErrorEnAlumnoException;

import java.util.Date;
import java.util.List;

public class AcademiaTaekwondoOrienteService {
    private RepositoryAcademia repository;

    public AcademiaTaekwondoOrienteService(RepositoryAcademia repository) {
        this.repository = repository;
    }
    public void save(String nombre, String cedula, String edad,
                     boolean padecimineto, boolean isAlumno, String encargado,
                     String parentesco, String cinturon) throws ErrorEnAlumnoException {
         String alumno = null;
        try {
        } catch (Exception e) {
            throw new ErrorEnAlumnoException(alumno);
        }
        Persona persona = new Persona();
        if (isAlumno) {
            persona = new Alumno(nombre, cedula, edad, padecimineto, encargado);

        } else {
            if (encargado.equals ("Persona a Cargo")) {
                persona = new Encargado (nombre, cedula);
            }
        }
        this.repository.save(persona, cinturon, new Date());
    }

    public List<String> get() {
        return this.repository.get();
    }

}
