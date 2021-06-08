package com.ucreativa.vacunación;

import com.ucreativa.vacunación.entities.Amigo;
import com.ucreativa.vacunación.entities.BitacoraVacunas;
import com.ucreativa.vacunación.entities.Familiar;
import com.ucreativa.vacunación.entities.Persona;
import com.ucreativa.vacunación.repositories.InMemoryRepository;
import com.ucreativa.vacunación.repositories.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String print;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //InMemoryRepository repo = new InMemoryRepository();
        Repository repo = (Repository) new InMemoryRepository();
        Persona persona;
        String nombre, cedula, edad, riesgo, isAmigo, relacion, facebook, parentesco, marca;
        while (true) {
            System.out.println("Nombre");
            nombre = in.nextLine();
            System.out.println("Cedula");
            cedula = in.nextLine();
            System.out.println("Edad");
            edad = in.nextLine();
            System.out.println("Riesgo");
            riesgo = in.nextLine();
            System.out.println("Amigo(A)/ Familiar(F)");
            isAmigo = in.nextLine();
            if (isAmigo.equals("A")) {
                System.out.println("Relación");
                relacion = in.nextLine();
                System.out.println("Facebook");
                facebook = in.nextLine();
                persona = new Amigo(nombre, cedula, Integer.parseInt(edad), riesgo.equals("S"), relacion, facebook);
            } else {
                System.out.println("Parentesco");
                parentesco = in.nextLine();
                persona = new Familiar(nombre, cedula, Integer.parseInt(edad), riesgo.equals("S"), parentesco);
            }
            System.out.println("Vacuna -- Marca");
            marca = in.nextLine();
            repo.save(persona, marca, new Date());
            System.out.println("Quiere imprimir Lista(S)");
            print = in.nextLine();
            if (print.equals("S")) {
                for (String item : repo.get()) {
                    System.out.println(item);
                }
            }
        }
    }
}