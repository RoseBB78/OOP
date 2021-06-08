package com.ucreativa.vacunación.repositories;

import com.ucreativa.vacunación.entities.Persona;

import java.util.Date;
import java.util.List;

public class FileRepository implements Repository {
    @Override
    public void save(Persona persona, java.lang.String marca, Date fecha) {

    }

    @Override
    public List<String> get() {
        return null;
    }
}
