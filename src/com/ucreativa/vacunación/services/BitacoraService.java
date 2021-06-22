package com.ucreativa.vacunación.services;

import com.ucreativa.vacunación.entities.Amigo;
import com.ucreativa.vacunación.entities.Familiar;
import com.ucreativa.vacunación.entities.Persona;
import com.ucreativa.vacunación.repositories.Repository;
import com.ucreativa.vacunación.ui.ErrorEnEdadException;

import java.util.Date;
import java.util.List;

public class BitacoraService {

    private Repository repository;
    private ContadorRiesgo contador;

    public BitacoraService(Repository repository) {
        this.repository = repository;
        this.contador = ContadorRiesgo.getInstance ();
    }

    public void save(String nombre, String cedula, String txtEdad,
                     boolean riesgo, boolean isAmigo, String relacion,
                     String facebook, String parentesco, String marca) throws ErrorEnEdadException {
        int edad;
        try {
            edad = Integer.parseInt(txtEdad);
        } catch (NumberFormatException x) {
            throw new ErrorEnEdadException(txtEdad);
        }
        if(riesgo){
        this.contador.SumarRiesgo ();
        }

        Persona persona;
        if (isAmigo) {
            persona = new Amigo(nombre, cedula, edad, riesgo, relacion, facebook);

        } else {
            if (relacion.equals ("Hermano")) {
                persona = new Familiar (nombre, edad, riesgo, parentesco);
            } else{
            persona = new Familiar (nombre, cedula, edad, riesgo, parentesco);
            }
        }
        this.repository.save(persona, marca, new Date());
    }

    public List<String> get() {
        System.out.println ("La Cantidad de Personas con Riesgo es:"
                + this.contador.getCantidadRiesgo ());
        return this.repository.get();
    }
}
