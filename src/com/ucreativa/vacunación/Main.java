package com.ucreativa.vacunación;

import com.sun.tools.javac.util.List;
import java.util.Date;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        Amigo juan = new Amigo("Juan", "110010010", 52,
                true, "Amigo", "Sí");
        Familiar mama = new Familiar("Rossy", "103150217", 75,
                true, "madre");
        Familiar padre = new Familiar("Otto", "103170215", 75,
                true,"padre");


        ArrayList<BitacoraVacunas> bitacora = new ArrayList<BitacoraVacunas>();
        bitacora.add(new BitacoraVacunas(juan, "Pfizer", new Date()));
        bitacora.add(new BitacoraVacunas(mama,"AstraZeneca", new Date()));
        bitacora.add(new BitacoraVacunas(padre, "Johnson", new Date()));



    }

}
