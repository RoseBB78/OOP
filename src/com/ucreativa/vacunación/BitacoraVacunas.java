package com.ucreativa.vacunación;


import java.util.Date;

public class BitacoraVacunas {
        public BitacoraVacunas(Persona persona, String marca, Date fecha) {
            this.persona = persona;
            this.marca = marca;
            this.fecha = fecha;
        }

        private Persona persona;
        private String marca;
        private Date fecha;

    public Persona getPersona(){
        return persona;
    }
    public String getMarca(){
        return marca;
    }
    public Date getFecha(){
        return fecha;
    }
}