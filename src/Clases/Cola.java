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
public class Cola {
    
    private Nodo pfirst, plast;
    private int size;
    
    public Cola() {
        this.pfirst = null;
        this.plast = null;
        this.size = 0;
    }
    
    public Nodo getPfirst() {
        return pfirst;
    }

    public void setPfirst(Nodo pfirst) {
        this.pfirst = pfirst;
    }

    public Nodo getPlast() {
        return plast;
    }

    public void setPlast(Nodo plast) {
        this.plast = plast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0 || pfirst == null;
    }
    
    public void encolar(Personaje comp) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setInfo(comp);

        if (pfirst == null) {
            pfirst = nuevo_nodo;
        } else {
            plast.setNext(nuevo_nodo);
        }
        plast = nuevo_nodo;
        size++;
    }
    
    public void desencolar() {
        if (!isEmpty()) {
            pfirst = pfirst.getNext();
            size--;
            if (pfirst == null) {
                plast = null;
            }
        }
    }
    
    public Personaje getCabeza() {
        return pfirst.getInfo();
    }
    // Funcion hecha para las colas de los estudios. Recorre la cola para imprimir el ID del personaje
    public String infoIdColas() {
        String palabra = "";
        Nodo aux = pfirst;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (aux != null) {
                    palabra += "    "+String.valueOf(aux.getInfo().idPersonaje) + "\n";
                    aux = aux.getNext();
                }
            }
        }
        return palabra;
    }
    
    // Funcion hecha para la cola de ganadores. Recorre la cola para imprimir el numero de combate, el nombre del ganador y su ID
    public String infoColaGanadores() {
        String palabra = "";
        Nodo aux = pfirst;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (aux != null) {
                    palabra += "          Combate "+(i+1)+": "+String.valueOf(aux.getInfo().nombre)+" ("+String.valueOf(aux.getInfo().idPersonaje)+ ")" + "\n";
                    aux = aux.getNext();
                }
            }
        }
        return palabra;
    }
    
    //Recorre la cola y aumenta el contador de inanicion de cada personaje
    public void contarRonda() {

        Nodo aux = pfirst;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (aux != null) {
                    aux.getInfo().contadorInanicion += 1;
                    aux = aux.getNext();
                }
            }
        }
    }
    
    // Reincia los contadores de inanicion cada vez que este llegue a 8
    public void reinciarContadoresInanicion() {

        Nodo aux = pfirst;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (aux != null) {
                    if (aux.getInfo().contadorInanicion == 8) {
                        aux.getInfo().contadorInanicion -= 8;
                    }
                    aux = aux.getNext();
                }
            }
        }
    }
}
