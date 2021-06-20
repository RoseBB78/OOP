package com.ucreativa.Proyecto.repositories;
import com.ucreativa.Proyecto.entities.Persona;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface RepositoryAcademia {
    void save(Persona persona, String cinturon, Date fecha);


    List<String> get();
}
