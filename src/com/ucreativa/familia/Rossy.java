package com.ucreativa.familia;

public class Rossy {
    private int age;
    private String hobby;

    public Rossy(String saludo,
                 int age,
                 String hobby){
        this.age = age;
        this.hobby = hobby;
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
