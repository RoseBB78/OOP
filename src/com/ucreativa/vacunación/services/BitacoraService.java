package com.ucreativa.vacunación.services;

import com.ucreativa.vacunación.entities.Amigo;
import com.ucreativa.vacunación.entities.BitacoraVacunas;
import com.ucreativa.vacunación.entities.Familiar;
import com.ucreativa.vacunación.entities.Persona;
import com.ucreativa.vacunación.repositories.Repository;

import java.util.Date;
import java.util.List;

public class BitacoraService {

    private Repository repository;

    public BitacoraService(Repository repository){
        this.repository = repository;
    }
    public void save(String nombre, String cedula, String txtEdad,
                     String txtRiesgo, String txtIsAmigo, String relacion,
                     String facebook, String parentesco, String marca){

        int edad = Integer.parseInt(txtEdad);
        boolean isAmigo = txtIsAmigo.equals("A");
        boolean riesgo = txtRiesgo.equals("S");
        Persona persona;
        if (isAmigo){
            persona = new Amigo(nombre, cedula, edad, riesgo, relacion, facebook);
        }else {
            persona = new Familiar(nombre, cedula, edad, riesgo, parentesco);
        }
        this.repository.save(persona, marca, new Date());
    }

    public List<String> get(){
        return this.repository.get();
    }

}