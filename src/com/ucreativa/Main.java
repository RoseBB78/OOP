package com.ucreativa;

import com.ucreativa.familia.Rosemary;
import com.ucreativa.familia.Rosemary;
import com.ucreativa.familia.Rossy;

public class Main {
    public static void main(String[] args){
        Rosemary yo = new Rosemary();
        Rossy mama = new Rossy("Hi my mom name is: Rossy");
        mama.setAge();
        int age = mama.getAge();
        System.out.println("My mom's Age is: " + age);
    }
}