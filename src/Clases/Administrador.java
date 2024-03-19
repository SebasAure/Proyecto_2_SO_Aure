/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.VentanaSimulacion;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Administrador {
    
    // Crea 20 personajes para cada estudio y los guarda en arrays de Personajes
    public void creacionPersonajesIniciales() {
        for (int i = 0; i < VentanaSimulacion.personajesInicialesNK.length; i++) {
            Personaje personajeNK = new Personaje(0);
            VentanaSimulacion.personajesInicialesNK[i] = personajeNK;
        }
        for (int i = 0; i < VentanaSimulacion.personajesInicialesCN.length; i++) {
            Personaje personajeCN = new Personaje(1);
            VentanaSimulacion.personajesInicialesCN[i] = personajeCN;
        }
    }
    // FUNCION PARA TESTEAR, ELIMINAR DESPUES
    public void mostrarPersonajesIniciales() {
        System.out.println("PERSONAJES NK");
        for (int i = 0; i < VentanaSimulacion.personajesInicialesNK.length; i++) {
            System.out.println("Id: " +(VentanaSimulacion.personajesInicialesNK[i].idPersonaje)+
                    " Nombre: "+VentanaSimulacion.personajesInicialesNK[i].nombre+
                    " Vida: " + VentanaSimulacion.personajesInicialesNK[i].vida+
                    " Fuerza: " +VentanaSimulacion.personajesInicialesNK[i].fuerza+
                    " Agildad: " +VentanaSimulacion.personajesInicialesNK[i].agilidad+
                    " Habilidades: " +VentanaSimulacion.personajesInicialesNK[i].habilidades[0]+
                    " Calidad: " +VentanaSimulacion.personajesInicialesNK[i].calidad);
           
        }
        System.out.println("PERSONAJES CN");
        for (int i = 0; i < VentanaSimulacion.personajesInicialesCN.length; i++) {
            System.out.println("Id: " +(VentanaSimulacion.personajesInicialesCN[i].idPersonaje)+
                    " Nombre: "+VentanaSimulacion.personajesInicialesCN[i].nombre+
                    " Vida: " + VentanaSimulacion.personajesInicialesCN[i].vida+
                    " Fuerza: " +VentanaSimulacion.personajesInicialesCN[i].fuerza+
                    " Agildad: " +VentanaSimulacion.personajesInicialesCN[i].agilidad+
                    " Habilidades: " +VentanaSimulacion.personajesInicialesCN[i].habilidades[0]+
                    " Calidad: " +VentanaSimulacion.personajesInicialesCN[i].calidad);
        }
    }
    
    // Recorre las colas de los personajes creados inicialmente de cada estudio y los va colocando en sus respectivas colas
    public void llenarColasIniciales() {
        // Colas Nickelodeon
        for (int i = 0; i < VentanaSimulacion.personajesInicialesNK.length; i++) {
            if (VentanaSimulacion.personajesInicialesNK[i].calidad.equals("Excepcional")) {
                VentanaSimulacion.colaExcepcionalesNK.encolar(VentanaSimulacion.personajesInicialesNK[i]);
            }
        }
        for (int i = 0; i < VentanaSimulacion.personajesInicialesNK.length; i++) {
            if (VentanaSimulacion.personajesInicialesNK[i].calidad.equals("Promedio")) {
                VentanaSimulacion.colaPromediosNK.encolar(VentanaSimulacion.personajesInicialesNK[i]);
            }
        }
        for (int i = 0; i < VentanaSimulacion.personajesInicialesNK.length; i++) {
            if (VentanaSimulacion.personajesInicialesNK[i].calidad.equals("Deficiente")) {
                VentanaSimulacion.colaDeficientesNK.encolar(VentanaSimulacion.personajesInicialesNK[i]);
            }
        }
        // Colas Cartoon Network
        for (int i = 0; i < VentanaSimulacion.personajesInicialesCN.length; i++) {
            if (VentanaSimulacion.personajesInicialesCN[i].calidad.equals("Excepcional")) {
                VentanaSimulacion.colaExcepcionalesCN.encolar(VentanaSimulacion.personajesInicialesCN[i]);
            }
        }
        for (int i = 0; i < VentanaSimulacion.personajesInicialesCN.length; i++) {
            if (VentanaSimulacion.personajesInicialesCN[i].calidad.equals("Promedio")) {
                VentanaSimulacion.colaPromediosCN.encolar(VentanaSimulacion.personajesInicialesCN[i]);
            }
        }
        for (int i = 0; i < VentanaSimulacion.personajesInicialesCN.length; i++) {
            if (VentanaSimulacion.personajesInicialesCN[i].calidad.equals("Deficiente")) {
                VentanaSimulacion.colaDeficientesCN.encolar(VentanaSimulacion.personajesInicialesCN[i]);
            }
        }
        mostrarColasEstudios();
    }
    
    // Muestra en pantalla los ID unicos de los personajes de cada cola
    public static void mostrarColasEstudios() {
        
        String colaENK = VentanaSimulacion.colaExcepcionalesNK.recorrido();
        String colaPNK = VentanaSimulacion.colaPromediosNK.recorrido();
        String colaDNK = VentanaSimulacion.colaDeficientesNK.recorrido();
        String colaRNK = VentanaSimulacion.colaRefuerzoNK.recorrido();
        
        String colaECN = VentanaSimulacion.colaExcepcionalesCN.recorrido();
        String colaPCN = VentanaSimulacion.colaPromediosCN.recorrido();
        String colaDCN = VentanaSimulacion.colaDeficientesCN.recorrido();
        String colaRCN = VentanaSimulacion.colaRefuerzoCN.recorrido();
        
        if (!VentanaSimulacion.colaRefuerzoNK.isEmpty()) {
            double salidaRefuerzoNK = Math.random();
            if (salidaRefuerzoNK <= 0.4) {
                VentanaSimulacion.colaExcepcionalesNK.encolar(VentanaSimulacion.colaRefuerzoNK.getCabeza());
                VentanaSimulacion.colaRefuerzoNK.desencolar();
            } else if (salidaRefuerzoNK > 0.6) {
                VentanaSimulacion.colaRefuerzoNK.encolar(VentanaSimulacion.colaRefuerzoNK.getCabeza());
                VentanaSimulacion.colaRefuerzoNK.desencolar();
            }            
        }
        
        if (!VentanaSimulacion.colaRefuerzoCN.isEmpty()) {
            double salidaRefuerzoCN = Math.random();
            if (salidaRefuerzoCN <= 0.4) {
                VentanaSimulacion.colaExcepcionalesCN.encolar(VentanaSimulacion.colaRefuerzoCN.getCabeza());
                VentanaSimulacion.colaRefuerzoCN.desencolar();
            } else if (salidaRefuerzoCN > 0.6) {
                VentanaSimulacion.colaRefuerzoCN.encolar(VentanaSimulacion.colaRefuerzoCN.getCabeza());
                VentanaSimulacion.colaRefuerzoCN.desencolar();
            }
        }
        
        
        VentanaSimulacion.cantidadCola1NK.setText(Integer.toString(VentanaSimulacion.colaExcepcionalesNK.getSize()));
        VentanaSimulacion.cantidadCola2NK.setText(Integer.toString(VentanaSimulacion.colaPromediosNK.getSize()));
        VentanaSimulacion.cantidadCola3NK.setText(Integer.toString(VentanaSimulacion.colaDeficientesNK.getSize()));
        
        VentanaSimulacion.cola1NK.setText(colaENK);
        VentanaSimulacion.cola2NK.setText(colaPNK);
        VentanaSimulacion.cola3NK.setText(colaDNK);
        VentanaSimulacion.cola4NK.setText(colaRNK);
        
        VentanaSimulacion.cantidadCola1CN.setText(Integer.toString(VentanaSimulacion.colaExcepcionalesCN.getSize()));
        VentanaSimulacion.cantidadCola2CN.setText(Integer.toString(VentanaSimulacion.colaPromediosCN.getSize()));
        VentanaSimulacion.cantidadCola3CN.setText(Integer.toString(VentanaSimulacion.colaDeficientesCN.getSize()));
        
        VentanaSimulacion.cola1CN.setText(colaECN);
        VentanaSimulacion.cola2CN.setText(colaPCN);
        VentanaSimulacion.cola3CN.setText(colaDCN);
        VentanaSimulacion.cola4CN.setText(colaRCN);

        
    }
    
    // Muestra en pantalla los ganadores historicos de los combates
    public static void mostrarColaGanadores() {
        String colaHistorial = VentanaSimulacion.colaHistorialGanadores.recorridoHistorial();
        VentanaSimulacion.historialGanadores.setText(colaHistorial);
    }
    
    public static void creacionNuevosPersonajes() {
        VentanaSimulacion.contadorPersonajesNuevos += 1;
        if (VentanaSimulacion.contadorPersonajesNuevos == 2) {            
            double dado = Math.random();
            if (dado <= 0.8) {
                
                Personaje personajeNK = new Personaje(0);
                
                switch (personajeNK.calidad) {
                    case "Deficiente":
                        VentanaSimulacion.colaDeficientesNK.encolar(personajeNK);
                        break;
                    case "Promedio":
                        VentanaSimulacion.colaPromediosNK.encolar(personajeNK);
                        break;
                    case "Excepcional":
                        VentanaSimulacion.colaExcepcionalesNK.encolar(personajeNK);
                        break;
                    default:
                        break;
                }
                
                Personaje personajeCN = new Personaje(1);
                
                switch (personajeCN.calidad) {
                    case "Deficiente":
                        VentanaSimulacion.colaDeficientesCN.encolar(personajeCN);
                        break;
                    case "Promedio":
                        VentanaSimulacion.colaPromediosCN.encolar(personajeCN);
                        break;
                    case "Excepcional":
                        VentanaSimulacion.colaExcepcionalesCN.encolar(personajeCN);
                        break;
                    default:
                        break;
                }
                
            }
            VentanaSimulacion.contadorPersonajesNuevos -= 2;
        }
    }
    
    public static void proximoEnfrentamiento() {
        // Seleccion Personaje Nickelodeon
        Personaje personajeNK = null;
        if (!VentanaSimulacion.colaExcepcionalesNK.isEmpty()) {
            
            personajeNK = VentanaSimulacion.colaExcepcionalesNK.getCabeza();
            VentanaSimulacion.colaExcepcionalesNK.desencolar();
            
        } else if (!VentanaSimulacion.colaPromediosNK.isEmpty()) {
            
            personajeNK = VentanaSimulacion.colaPromediosNK.getCabeza();
            VentanaSimulacion.colaPromediosNK.desencolar();
            
        } else {
            
            personajeNK = VentanaSimulacion.colaDeficientesNK.getCabeza();
            VentanaSimulacion.colaDeficientesNK.desencolar();
        }
        
        // Seleccion Personaje Cartoon Network
        Personaje personajeCN = null;
        if (!VentanaSimulacion.colaExcepcionalesCN.isEmpty()) {
            
            personajeCN = VentanaSimulacion.colaExcepcionalesCN.getCabeza();
            VentanaSimulacion.colaExcepcionalesCN.desencolar();
            
        } else if (!VentanaSimulacion.colaPromediosCN.isEmpty()) {
            
            personajeCN = VentanaSimulacion.colaPromediosCN.getCabeza();
            VentanaSimulacion.colaPromediosCN.desencolar();
            
        } else {
            
            personajeCN = VentanaSimulacion.colaDeficientesCN.getCabeza();
            VentanaSimulacion.colaDeficientesCN.desencolar();
        } 
        //JOptionPane.showMessageDialog(null, personajeNK.idPersonaje + " vs " + personajeCN.idPersonaje);
        mostrarColasEstudios();
        InteligenciaArtificial.decision(personajeNK, personajeCN);
    }
}
