package com.ucreativa.vacunación.ui;

public class ErrorEnEdadException extends Exception {

    public ErrorEnEdadException(String edad) {
        super("La edad esta incorrecta: " + edad);
    }
}