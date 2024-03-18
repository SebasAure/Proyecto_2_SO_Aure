/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.VentanaSimulacion;
import java.util.Random;

/**
 *
 * @author sebas
 */
public class Personaje {
    
    
    public String idPersonaje; //id unico
    public String nombre; // nombre personaje
    public String[] habilidades; // habilidades del competidor (Valores posibles: 1/2/3/4/5)
    public int vida; // puntos de vida (Valores posibles: 250/500/750/1000)
    public int fuerza; // puntos de fuerza (Valores posibles: 250/500/750/1000)
    public int agilidad; // puntos de agilidad (Valores posibles: 250/500/750/1000)
    public String calidad; // (Valores posibles: excepcional/promedio/deficiente)
    public int contadorCola;
    
    public Personaje(int idEstudio) {
        this.contadorCola = 0;
        switch (idEstudio) {
            // Personaje Nickelodeon
            case 0: 
                this.idPersonaje = "NK"+VentanaSimulacion.idDistintivoNK;
                this.nombre = null;
                this.habilidades = new String[3];
                this.vida = 0;
                this.fuerza = 0;
                this.agilidad = 0;
                this.calidad = null;
                creacionPersonaje(idEstudio);
                VentanaSimulacion.idDistintivoNK += 1;
                break;
            // Personaje Cartoon Network
            case 1:
                this.idPersonaje = "CN"+VentanaSimulacion.idDistintivoCN;
                this.nombre = null;
                this.habilidades = new String[3];
                this.vida = 0;
                this.fuerza = 0;
                this.agilidad = 0;
                this.calidad = null;
                creacionPersonaje(idEstudio);
                VentanaSimulacion.idDistintivoCN += 1;
                break;
            default:
                break;
        }
    }
    
    // Sistema para determinar los atributos del competidor
    public void creacionPersonaje(int idEstudio) {
        switch (idEstudio) {
            // Personaje Nickelodeon
            case 0: 
                String personajeNK;
                String[] personajesNK = {"Aang", "Katara", "Sokka", "Zuko", "Ozai"};
                Random randNK = new Random();
                //escoje uno de los 5 personajes
                personajeNK = personajesNK[randNK.nextInt(5)];
                nombre = personajeNK;
                switch (personajeNK) {
                    case "Aang":
                        habilidades[0] = "Agua";
                        habilidades[1] = "Fuego";
                        habilidades[2] = "Aire";
                        vida += 1750;
                        fuerza += 750;
                        agilidad += 750;
                        break;
                    case "Katara":
                        habilidades[0] = "Agua";
                        habilidades[1] = "- - -";
                        habilidades[2] = "- - -";
                        vida += 1500;
                        fuerza += 500;
                        agilidad += 750;
                        break;
                    case "Sokka":
                        habilidades[0] = "Agua";
                        habilidades[1] = "- - -";
                        habilidades[2] = "- - -";
                        vida += 1500;
                        fuerza += 500;
                        agilidad += 500;
                        break;
                    case "Zuko":
                        habilidades[0] = "Fuego";
                        habilidades[1] = "- - -";
                        habilidades[2] = "- - -";
                        vida += 1500;
                        fuerza += 750;
                        agilidad += 1000;
                        break;
                    case "Ozai":
                        habilidades[0] = "Fuego";
                        habilidades[1] = "Aire";
                        habilidades[2] = "- - -";
                        vida += 1750;
                        fuerza += 1000;
                        agilidad += 500;
                        break;
                    default:
                        break;
                }
                break;
            // Personaje Cartoon Network
            case 1:
                String personajeCN;
                String[] personajesCN = {"Mordecai", "Rigby", "Musculoso", "Skips", "Benson"};
                Random randCN = new Random();
                //escoje uno de los 5 personajes
                personajeCN = personajesCN[randCN.nextInt(5)];
                nombre = personajeCN;
                switch (personajeCN) {
                    case "Mordecai":
                        habilidades[0] = "Caos";
                        habilidades[1] = "Chamba";
                        habilidades[2] = "- - -";
                        vida += 1750;
                        fuerza += 750;
                        agilidad += 500;
                        break;
                    case "Rigby":
                        habilidades[0] = "Caos";
                        habilidades[1] = "Chamba";
                        habilidades[2] = "- - -";
                        vida += 1500;
                        fuerza += 500;
                        agilidad += 1000;
                        break;
                    case "Musculoso":
                        habilidades[0] = "Caos";
                        habilidades[1] = "- - -";
                        habilidades[2] = "- - -";
                        vida += 1500;
                        fuerza += 1000;
                        agilidad += 250;
                        break;
                    case "Skips":
                        habilidades[0] = "Chamba";
                        habilidades[1] = "Mistica";
                        habilidades[2] = "- - -";
                        vida += 2000;
                        fuerza += 750;
                        agilidad += 500;
                        break;
                    case "Benson":
                        habilidades[0] = "Chamba";
                        habilidades[1] = "- - -";
                        habilidades[2] = "- - -";
                        vida += 1500;
                        fuerza += 250;
                        agilidad += 500;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        // Calidad
        int contadorCalidad = 0;
        // Habilidades de calidad (60% prob)
        if (Math.random()>0.4) {
            contadorCalidad += 2;
        }
        // Vida de calidad(70% prob)
        if (Math.random()>0.3) {
            contadorCalidad += 1;
        }
        // Fuerza de calidad (50% prob)
        if (Math.random()>0.5) {
            contadorCalidad += 3;
        }
        // Agilidad de calidad (40% prob)
        if (Math.random()>0.6) {
            contadorCalidad += 5;
        }
        // Definicion calidad
        if (contadorCalidad < 5) {
            // Si es deficiente los atributos bases empeoran 
            calidad = "Deficiente";
            vida -= 200;
            fuerza -= 100;
            agilidad -= 100;
        } else if ((contadorCalidad == 5) || (contadorCalidad < 8)) {
            // Si es promedio los atributos bases mejoran ligeramente
            calidad = "Promedio";
            vida += 200;
            fuerza += 100;
            agilidad += 100;
        } else {
            // Si es excepcional los atributos bases reciben una buena mejora
            calidad = "Excepcional";
            vida += 400;
            fuerza += 200;
            agilidad += 200;
        }
        
        
    }
    
    public int contarHabilidades(Personaje personaje) {
        int contadorHabilidades = 0;
        for (int i = 0; i < personaje.habilidades.length; i++) {
            if (!personaje.habilidades[i].equals("- - -")) {
                contadorHabilidades += 1;
            }
        }
        return contadorHabilidades;
    }
    
    public String getidPersonaje() {
        return idPersonaje;
    }

    public void setidPersonaje(String idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
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


