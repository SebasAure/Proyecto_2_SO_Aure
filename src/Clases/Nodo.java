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
public class Nodo {
    
    private Personaje competidor;
    private Nodo next;
    
    public Nodo() {
        this.competidor = competidor;
        this.next = null;
    }
    
    public Nodo getNext() {
        return next;
    }
    
    public void setNext(Nodo next) {
        this.next = next;
    }
    
    public Personaje getInfo() {
        return competidor;
    }
    
    public void setInfo(Personaje competidor) {
        this.competidor = competidor;
    }
}
