/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.VentanaSimulacion;

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
                    " Habilidades: " +VentanaSimulacion.personajesInicialesNK[i].habilidades+
                    " Calidad: " +VentanaSimulacion.personajesInicialesNK[i].calidad);
           
        }
        System.out.println("PERSONAJES CN");
        for (int i = 0; i < VentanaSimulacion.personajesInicialesCN.length; i++) {
            System.out.println("Id: " +(VentanaSimulacion.personajesInicialesCN[i].idPersonaje)+
                    " Nombre: "+VentanaSimulacion.personajesInicialesCN[i].nombre+
                    " Vida: " + VentanaSimulacion.personajesInicialesCN[i].vida+
                    " Fuerza: " +VentanaSimulacion.personajesInicialesCN[i].fuerza+
                    " Agildad: " +VentanaSimulacion.personajesInicialesCN[i].agilidad+
                    " Habilidades: " +VentanaSimulacion.personajesInicialesCN[i].habilidades+
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
        mostrarColas();
    }
    
    // Muestra en pantalla los ID unicos de los personajes de cada cola
    public static void mostrarColas() {
        String colaENK = VentanaSimulacion.colaExcepcionalesNK.recorrido();
        String colaPNK = VentanaSimulacion.colaPromediosNK.recorrido();
        String colaDNK = VentanaSimulacion.colaDeficientesNK.recorrido();
        
        String colaECN = VentanaSimulacion.colaExcepcionalesCN.recorrido();
        String colaPCN = VentanaSimulacion.colaPromediosCN.recorrido();
        String colaDCN = VentanaSimulacion.colaDeficientesCN.recorrido();
        
        VentanaSimulacion.cola1NK.setText(colaENK);
        VentanaSimulacion.cola2NK.setText(colaPNK);
        VentanaSimulacion.cola3NK.setText(colaDNK);
        
        VentanaSimulacion.cola1CN.setText(colaECN);
        VentanaSimulacion.cola2CN.setText(colaPCN);
        VentanaSimulacion.cola3CN.setText(colaDCN);
        
    }
}
