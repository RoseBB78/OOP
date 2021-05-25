package com.ucreativa.familia;

public class Rossy {
    private int age;
    private String hobby;

    public Rossy(String saludo){
        this.age = 74;
        this.hobby = "knitting";
        System.out.println(saludo);
    }
    public void setAge(){
        this.age = this.age + 1;
    }
    public int getAge(){
        return this.age;

    }
     public String getHobby(){
        return hobby;
     }
}
