package com.ucreativa.Proyecto.repositories;
import com.ucreativa.Proyecto.entities.AcademiaTaekwondoOriente;
import com.ucreativa.Proyecto.entities.Persona;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMemoryRepositoryAcademia {

    private final List<AcademiaTaekwondoOriente> db;
    public InMemoryRepositoryAcademia(){

        this.db = new ArrayList<>();
    }

    public InMemoryRepositoryAcademia(List<AcademiaTaekwondoOriente> db) {
        this.db = db;
    }

    public void save(Persona persona, String cinturon, Date fecha){
        this.db.add(new AcademiaTaekwondoOriente(persona, cinturon, fecha));
    }

    public List<String> get() {
        List<String> lines = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy hh:mm:ss");
        for (AcademiaTaekwondoOriente item: db) {
            lines.add(item.getPersona().getNombre()
                    + " - " + item.getcinturon()
                    + " + " + format.format(item.getFecha()));
        }
        return lines;
    }
}
