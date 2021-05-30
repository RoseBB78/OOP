package com.ucreativa;

import com.ucreativa.familia.Rosemary;
import com.ucreativa.familia.Rosemary;
import com.ucreativa.familia.Rossy;

public class Main {
    public static void main(String[] args){
        Rossy mama = new Rossy("Saludos", 74, "Kniting" );
        Rosemary yo = new Rosemary("Hello", 42, "Cocking");
        mama.setAge();
        int age = mama.getAge();
        System.out.println("My mom is: " + age + " old");
    }
}