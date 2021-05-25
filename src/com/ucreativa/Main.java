package com.ucreativa;

import com.ucreativa.familia.Rosemary;
import com.ucreativa.familia.Rosemary;
import com.ucreativa.familia.Rossy;

public class Main {
    public static void main(String[] args){
        Rosemary yo = new Rosemary();
        Rossy mama = new Rossy("Hola mi mamí es:");
        mama.setAge();
        int age = mama.getAge();
        System.out.println(" Chao Class " + age);
    }
}