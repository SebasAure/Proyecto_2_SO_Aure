/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author sebas
 */
public class Competidor {
    
    public String idComp; //id unico
    public String status; // excepcional/promedio/deficiente
    public String[] habilidades; // habilidades del competidor
    public int vida; // puntos de vida
    public int fuerza; // puntos de fuerza
    public int agilidad; // puntos de agilidad
    
    public Competidor(int idEstudio) {
        // Competidor Nickelodeon
        if (idEstudio == 0) {
            return;
            
        // Competidor Cartoon Network
        } else if (idEstudio == 1) {
            return;
        }
    }
    
    // Sistema para determinar el status del competidor
    public void SistemaStatus() {
        // proceso para definir el estatus del competidor
    }
    
    public String getIdComp() {
        return idComp;
    }

    public void setId(String idComp) {
        this.idComp = idComp;
    }

    public String getStatus() {
        return status;
    }

    public void setCopas(String status) {
        this.status = status;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setNro_pantallas(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
}


