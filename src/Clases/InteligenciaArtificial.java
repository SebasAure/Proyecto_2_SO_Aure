/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.VentanaSimulacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class InteligenciaArtificial extends Thread{
    
    @Override
    public void run() {
        while (true) {            
            try {
                Administrador.proximoEnfrentamiento();
                this.sleep(VentanaSimulacion.tiempoDecision*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void decision(Personaje personajeNK, Personaje personajeCN) {
        // Mostrar info personaje Nickelodeon
        VentanaSimulacion.nombreNK.setText(personajeNK.nombre);
        VentanaSimulacion.habilidadesNK.setText("("+personajeNK.habilidades[0]+"/"+personajeNK.habilidades[1]+"/"+personajeNK.habilidades[2]+")");
        VentanaSimulacion.cantidadHabilidadesNK.setText(Integer.toString(personajeNK.contarHabilidades(personajeNK)));
        VentanaSimulacion.vidaNK.setText(Integer.toString(personajeNK.vida));
        VentanaSimulacion.fuerzaNK.setText(Integer.toString(personajeNK.fuerza));
        VentanaSimulacion.agilidadNK.setText(Integer.toString(personajeNK.agilidad));
        VentanaSimulacion.idNK.setText(personajeNK.idPersonaje);
        VentanaSimulacion.calidadNK.setText(personajeNK.calidad);
        // Mostrar info personaje Cartoon Network
        VentanaSimulacion.nombreCN.setText(personajeCN.nombre);
        VentanaSimulacion.habilidadesCN.setText("("+personajeCN.habilidades[0]+"/"+personajeCN.habilidades[1]+"/"+personajeCN.habilidades[2]+")");
        VentanaSimulacion.cantidadHabilidadesCN.setText(Integer.toString(personajeCN.contarHabilidades(personajeCN)));
        VentanaSimulacion.vidaCN.setText(Integer.toString(personajeCN.vida));
        VentanaSimulacion.fuerzaCN.setText(Integer.toString(personajeCN.fuerza));
        VentanaSimulacion.agilidadCN.setText(Integer.toString(personajeCN.agilidad));
        VentanaSimulacion.idCN.setText(personajeCN.idPersonaje);
        VentanaSimulacion.calidadCN.setText(personajeCN.calidad);
        
        Administrador.mostrarColas();
        
        double decision = Math.random();
        if (decision <= 0.4) {
            VentanaSimulacion.estadoIA.setText("elegió COMBATE");
            combate(personajeNK,personajeCN);
        } else if (decision>0.4 && decision<=0.67) {
            VentanaSimulacion.estadoIA.setText("elegió EMPATE");
            empate();
        } else if (decision>0.67){
            VentanaSimulacion.estadoIA.setText("elegió REFUERZO");
            refuerzo();
        }
        
    }
    
    public static void tiempoDecision(){
        String nuevoTiempoDecision = JOptionPane.showInputDialog("Tiempo de procesamiento de la IA (Tiempo actual: "+VentanaSimulacion.tiempoDecision+" seg.)");
        try {
            VentanaSimulacion.tiempoDecision = Long.parseLong(nuevoTiempoDecision);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingreso invalido");
        }
    }
    
    public static void combate(Personaje personajeNK, Personaje personajeCN) {
        VentanaSimulacion.ganador.setText("- - - -");
        // Se crean variales PODER para el personaje de Nickelodeon
        int poderBaseNK = 0;
        int poderExtraNK = 0;
        int poderFinalNK = 0;
        // Se crean variales PODER para el personaje de Cartoon Network
        int poderBaseCN = 0;
        int poderExtraCN = 0;
        int poderFinalCN = 0;
        
        
        //Calculo PODER BASE (Fuerza + Agilidad) del personaje de Nickelodeon 
        poderBaseNK = personajeNK.fuerza + personajeNK.agilidad;
        //Calculo PODER BASE (Fuerza + Agilidad) del personaje de Cartoon Network
        poderBaseCN = personajeCN.fuerza + personajeCN.agilidad;
        
        
        //Calculo PODER EXTRA (en funcion de la cantidad de habilidades) del personaje de Nickelodeon
        switch (personajeNK.contarHabilidades(personajeNK)) {
            case 1:
                poderExtraNK += poderBaseNK*0.25;
                break;
            case 2:
                poderExtraNK += poderBaseNK*0.5;
                break;
            case 3:
                poderExtraNK += poderBaseNK*0.75;
                break;    
            default:
                break;
        }
        //Calculo PODER EXTRA (en funcion de la cantidad de habilidades) del personaje de Cartoon Network
        switch (personajeCN.contarHabilidades(personajeCN)) {
            case 1:
                poderExtraCN += poderBaseCN*0.25;
                break;
            case 2:
                poderExtraCN += poderBaseCN*0.5;
                break;
            case 3:
                poderExtraCN += poderBaseCN*0.75;
                break;    
            default:
                break;
        }
        
        //Calculo PODER FINAL (BASE + EXTRA) del personaje de Nickelodeon
        poderFinalNK = poderBaseNK + poderExtraNK;
        //Calculo PODER FINAL (BASE + EXTRA) del personaje de Cartoon Network
        poderFinalCN = poderBaseCN + poderExtraCN;
        
        // Proceso para definir el ganador del combate
        
        //Personaje Nickelodeon ataca al del Cartoon Network
        personajeCN.vida -= poderFinalNK;
        //Se actualiza la vida del personaje de Cartoon Network
        if (personajeCN.vida < 0) {
            personajeCN.vida = 0;
            VentanaSimulacion.vidaCN.setText(Integer.toString(personajeCN.vida));
        } else  {
            VentanaSimulacion.vidaCN.setText(Integer.toString(personajeCN.vida));
        }
        //Personaje Cartoon Network ataca al del Nickelodeon
        personajeNK.vida -= poderFinalCN;
        //Se actualiza la vida del personaje de Nickelodeon
        if (personajeNK.vida < 0) {
            personajeNK.vida = 0;
            VentanaSimulacion.vidaNK.setText(Integer.toString(personajeNK.vida));
        } else {
            VentanaSimulacion.vidaNK.setText(Integer.toString(personajeNK.vida));
        }
        
        vidaExtraExcepcional(personajeNK, personajeCN);
        verificarEmpateBatalla(personajeNK, personajeCN);
        // Definicion de ganador
        if (personajeNK.vida > personajeCN.vida) {
            VentanaSimulacion.contadorCombates += 1;
            VentanaSimulacion.ganador.setText(personajeNK.nombre+" ("+personajeNK.idPersonaje+")");
            VentanaSimulacion.historialGanadores.setText("Combate "+VentanaSimulacion.contadorCombates+": "+personajeNK.nombre+" ("+personajeNK.idPersonaje+")");
            
        } else{
            VentanaSimulacion.contadorCombates += 1;
            VentanaSimulacion.ganador.setText(personajeCN.nombre+" ("+personajeCN.idPersonaje+")");
            VentanaSimulacion.historialGanadores.setText("Combate "+VentanaSimulacion.contadorCombates+": "+personajeCN.nombre+" ("+personajeCN.idPersonaje+")");

        }
        
        
        
             
    }
    
    //Otorga una salvacion en caso de empate por ser de calidad Excepcional sumandole un punto de vida
    public static void vidaExtraExcepcional(Personaje personajeNK, Personaje personajeCN) {
        if (personajeNK.vida == 0 && personajeCN.vida == 0) {
            if (personajeNK.calidad.equals("Excepcional")) {
                personajeNK.vida += 1;
                VentanaSimulacion.vidaNK.setText(Integer.toString(personajeNK.vida));
            }
            if (personajeCN.calidad.equals("Excepcional")) {
                personajeCN.vida += 1;
                VentanaSimulacion.vidaCN.setText(Integer.toString(personajeCN.vida));
            }
            
        }
    }
    //El ganador se decide al tirar un dado ya que han habido muchos empates
    public static void verificarEmpateBatalla(Personaje personajeNK, Personaje personajeCN) {
        if (personajeNK.vida == personajeCN.vida) {
            double dadoNK = Math.random();
            double dadoCN = Math.random();
            
            if (dadoNK > dadoCN) {
                personajeNK.vida = 9999;
                personajeCN.vida = 0;
            } else {
                personajeNK.vida = 0;
                personajeCN.vida = 9999;
            }
        }
    }
    
    public static void empate() {
    }
    
    public static void refuerzo() {
    }
}