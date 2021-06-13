package com.ucreativa.vacunación;

import com.ucreativa.vacunación.repositories.FileRepository;
import com.ucreativa.vacunación.services.BitacoraService;

import java.util.Scanner;

public class Main {
    private static String print;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BitacoraService service = new BitacoraService(new FileRepository());
        String nombre, cedula, edad, riesgo, isAmigo,
                relacion = "", facebook = "", parentesco = "", marca, print;
        boolean seguir = true;
        while (seguir) {
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
                //persona = new Amigo(nombre, cedula, Integer.parseInt(edad), riesgo.equals("S"), relacion, facebook);
            } else {
                System.out.println("Parentesco");
                parentesco = in.nextLine();
                //persona = new Familiar(nombre, cedula, Integer.parseInt(edad), riesgo.equals("S"), parentesco);
            }
            System.out.println("Vacuna -- Marca");
            marca = in.nextLine();
           service.save(nombre, cedula, edad, riesgo, isAmigo,
                    relacion, facebook, parentesco, marca);
            System.out.println("Quiere imprimir Lista(S)");
            print = in.nextLine();
            if (print.equals("S")) {
                for (String item : service.get()) {
                    System.out.println(item);
                }
            }
            System.out.println("Continuar? (Default 'S')");
            seguir = !in.nextLine().equals("N");
        }
    }
}