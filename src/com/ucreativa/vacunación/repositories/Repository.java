package com.ucreativa.vacunación.repositories;
import com.ucreativa.vacunación.entities.Persona;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface Repository{
    void save(Persona persona, String marca, Date fecha);


    List<String> get();
}
