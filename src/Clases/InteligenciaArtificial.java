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
public class InteligenciaArtificial extends Thread{
    
    @Override
    public void run() {
        while (true) {            
            Administrador.proximoEnfrentamiento();
        }
    }
    
    public static void decision(Personaje personajeNK, Personaje personajeCN) {
        // Mostrar info personaje Nickelodeon
        VentanaSimulacion.nombreNK.setText(personajeNK.nombre);
        VentanaSimulacion.habilidadesNK.setText(Integer.toString(personajeNK.habilidades));
        VentanaSimulacion.vidaNK.setText(Integer.toString(personajeNK.vida));
        VentanaSimulacion.fuerzaNK.setText(Integer.toString(personajeNK.fuerza));
        VentanaSimulacion.agilidadNK.setText(Integer.toString(personajeNK.agilidad));
        VentanaSimulacion.idNK.setText(personajeNK.idPersonaje);
        VentanaSimulacion.calidadNK.setText(personajeNK.calidad);
        // Mostrar info personaje Cartoon Network
        VentanaSimulacion.nombreCN.setText(personajeCN.nombre);
        VentanaSimulacion.habilidadesCN.setText(Integer.toString(personajeCN.habilidades));
        VentanaSimulacion.vidaCN.setText(Integer.toString(personajeCN.vida));
        VentanaSimulacion.fuerzaCN.setText(Integer.toString(personajeCN.fuerza));
        VentanaSimulacion.agilidadCN.setText(Integer.toString(personajeCN.agilidad));
        VentanaSimulacion.idCN.setText(personajeCN.idPersonaje);
        VentanaSimulacion.calidadCN.setText(personajeCN.calidad);
        
        Administrador.mostrarColas();
        
        double decision = Math.random();
        if (decision <= 0.4) {
            combate();
        } else if (decision>0.4 && decision<=0.67) {
            empate();
        } else if (decision>0.67){
            refuerzo();
        }
    }
    
    public static void combate() {
        //TO DO
    }
    
    public static void empate() {
        //TO DO
    }
    
    public static void refuerzo() {
        //TO DO
    }
}
