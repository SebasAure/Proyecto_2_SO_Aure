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
                VentanaSimulacion.contadorRondas += 1;
                VentanaSimulacion.ronda.setText(Integer.toString(VentanaSimulacion.contadorRondas));
                // Posibilidad de crear nuevos personajes
                Administrador.creacionNuevosPersonajes();
                // Control de inanicion
                Administrador.controlarInanicion();
                
                // Limpiar info personaje Nickelodeon
                VentanaSimulacion.nombreNK.setText("----");
                VentanaSimulacion.habilidadesNK.setText("(- - -/- - -/- - -)");
                VentanaSimulacion.cantidadHabilidadesNK.setText("----");
                VentanaSimulacion.vidaNK.setText("----");
                VentanaSimulacion.fuerzaNK.setText("----");
                VentanaSimulacion.agilidadNK.setText("----");
                VentanaSimulacion.idNK.setText("NK--");
                VentanaSimulacion.calidadNK.setText("- - - -");
                // Limpiar info personaje Cartoon Network
                VentanaSimulacion.nombreCN.setText("----");
                VentanaSimulacion.habilidadesCN.setText("(- - -/- - -/- - -)");
                VentanaSimulacion.cantidadHabilidadesCN.setText("----");
                VentanaSimulacion.vidaCN.setText("----");
                VentanaSimulacion.fuerzaCN.setText("----");
                VentanaSimulacion.agilidadCN.setText("----");
                VentanaSimulacion.idCN.setText("CN--");
                VentanaSimulacion.calidadCN.setText("- - - -");
                // Limpiar info ganador
                VentanaSimulacion.ganador.setText("- - - -");
                
                //Limpiar imagenes
                VentanaSimulacion.aangPic.setVisible(false);
                VentanaSimulacion.kataraPic.setVisible(false);
                VentanaSimulacion.sokkaPic.setVisible(false);
                VentanaSimulacion.zukoPic.setVisible(false);
                VentanaSimulacion.ozaiPic.setVisible(false);
        
                VentanaSimulacion.mordecaiPic.setVisible(false);
                VentanaSimulacion.rigbyPic.setVisible(false);
                VentanaSimulacion.musculosoPic.setVisible(false);
                VentanaSimulacion.skipsPic.setVisible(false);
                VentanaSimulacion.bensonPic.setVisible(false);
                // "Espera" durante X cantidad de segundos
                VentanaSimulacion.estadoIA.setText("esperando");
                Thread.sleep(VentanaSimulacion.tiempoDecision*1000);
                // Selecciona los competidores que recibira la IA
                Administrador.proximoEnfrentamiento();
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
        switch (personajeNK.nombre) {
            case "Aang":
                VentanaSimulacion.aangPic.setVisible(true);
                break;
            case "Katara":
                VentanaSimulacion.kataraPic.setVisible(true);
                break;
            case "Sokka":
                VentanaSimulacion.sokkaPic.setVisible(true);
                break;
            case "Zuko":
                VentanaSimulacion.zukoPic.setVisible(true);
                break;
            case "Ozai":
                VentanaSimulacion.ozaiPic.setVisible(true);
                break;
            default:
                break;
        }
        // Mostrar info personaje Cartoon Network
        VentanaSimulacion.nombreCN.setText(personajeCN.nombre);
        VentanaSimulacion.habilidadesCN.setText("("+personajeCN.habilidades[0]+"/"+personajeCN.habilidades[1]+"/"+personajeCN.habilidades[2]+")");
        VentanaSimulacion.cantidadHabilidadesCN.setText(Integer.toString(personajeCN.contarHabilidades(personajeCN)));
        VentanaSimulacion.vidaCN.setText(Integer.toString(personajeCN.vida));
        VentanaSimulacion.fuerzaCN.setText(Integer.toString(personajeCN.fuerza));
        VentanaSimulacion.agilidadCN.setText(Integer.toString(personajeCN.agilidad));
        VentanaSimulacion.idCN.setText(personajeCN.idPersonaje);
        VentanaSimulacion.calidadCN.setText(personajeCN.calidad);
        switch (personajeCN.nombre) {
            case "Mordecai":
                VentanaSimulacion.mordecaiPic.setVisible(true);
                break;
            case "Rigby":
                VentanaSimulacion.rigbyPic.setVisible(true);
                break;
            case "Musculoso":
                VentanaSimulacion.musculosoPic.setVisible(true);
                break;
            case "Skips":
                VentanaSimulacion.skipsPic.setVisible(true);
                break;
            case "Benson":
                VentanaSimulacion.bensonPic.setVisible(true);
                break;
            default:
                break;
        }
        
        Administrador.actualizarColasEstudios();
        try {
            
            VentanaSimulacion.estadoIA.setText("procesando DATOS");
            Thread.sleep(VentanaSimulacion.tiempoDecision*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }

        double decision = Math.random();
        if (decision <= 0.4) {
            // Toco combate
            combate(personajeNK,personajeCN);
        } else if (decision>0.4 && decision<=0.67) {
            // Toco empate
            empate(personajeNK,personajeCN);
        } else if (decision>0.67){
            // Toco refuerzo
            refuerzo(personajeNK,personajeCN);
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
        VentanaSimulacion.estadoIA.setText("anunciando COMBATE");
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
            VentanaSimulacion.contadorVictoriasNK +=1;
            VentanaSimulacion.ganador.setText("Ganador: "+personajeNK.nombre+" ("+personajeNK.idPersonaje+")");
            VentanaSimulacion.victoriasNK.setText(Integer.toString(VentanaSimulacion.contadorVictoriasNK));
            VentanaSimulacion.colaHistorialGanadores.encolar(personajeNK);
            Administrador.actualizarColaGanadores();
            //VentanaSimulacion.historialGanadores.setText("Combate "+VentanaSimulacion.contadorCombates+": "+personajeNK.nombre+" ("+personajeNK.idPersonaje+")");
            
        } else{
            VentanaSimulacion.contadorVictoriasCN +=1;
            VentanaSimulacion.ganador.setText("Ganador: "+personajeCN.nombre+" ("+personajeCN.idPersonaje+")");
            VentanaSimulacion.victoriasCN.setText(Integer.toString(VentanaSimulacion.contadorVictoriasCN));
            VentanaSimulacion.colaHistorialGanadores.encolar(personajeCN);
            Administrador.actualizarColaGanadores();
            //VentanaSimulacion.historialGanadores.setText("Combate "+VentanaSimulacion.contadorCombates+": "+personajeCN.nombre+" ("+personajeCN.idPersonaje+")");

        }
        try {
            Thread.sleep(VentanaSimulacion.tiempoDecision*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
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
    
    // Manda a cada competidor a la cola de excepcionales o prioridad uno respectiva
    public static void empate(Personaje personajeNK, Personaje personajeCN) {
        VentanaSimulacion.estadoIA.setText("anunciando EMPATE");
        VentanaSimulacion.colaExcepcionalesNK.encolar(personajeNK);
        VentanaSimulacion.colaExcepcionalesCN.encolar(personajeCN);
        Administrador.actualizarColasEstudios();


        try {
            Thread.sleep(VentanaSimulacion.tiempoDecision*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void refuerzo(Personaje personajeNK, Personaje personajeCN) {
        VentanaSimulacion.estadoIA.setText("anunciando REFUERZO");
        VentanaSimulacion.colaRefuerzoNK.encolar(personajeNK);
        VentanaSimulacion.colaRefuerzoCN.encolar(personajeCN);
        Administrador.actualizarColasEstudios();
        try {
            Thread.sleep(VentanaSimulacion.tiempoDecision*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(VentanaSimulacion.tiempoDecision*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InteligenciaArtificial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
