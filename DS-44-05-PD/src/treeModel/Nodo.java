/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeModel;

/**
 *
 * @author manuc
 */
public abstract class Nodo {
    
    /* Declaraciones de variables */
    private Integer peso;
    private Integer nivel;
    
 
    private Nodo padre;
    private Nodo hojaIzquierda;
    private Nodo hojaDerecha;
 
    /* Constructor */
    public Nodo(int peso) {
        this.peso = peso;
    }
 
    /* Setters y Getters */
    public void setPeso(int peso){
    	this.peso = peso;
    }
    
    public Integer getPeso() {
    	return peso;
    }
    
    public void setNivel(Integer nivel) {
    	this.nivel = nivel;
    }
    public int getNivel() {
    	return nivel;
    }
  
    public Nodo getPadre() {
        return padre;
    }
 
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
 
    public Nodo getHojaIzquierda() {
        return hojaIzquierda;
    }
 
    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }
 
    public Nodo getHojaDerecha() {
        return hojaDerecha;
    }
 
    public void setHojaDerecha(Nodo hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }
    
   
    
	@Override
	public String toString() {
		return "Nodo [ peso=" + peso + ", nivel=" + nivel + ", hojaIzquierda="
				+ ((null != hojaIzquierda)?hojaIzquierda.getPeso():null) + ", hojaDerecha=" + ((null != hojaDerecha)?hojaDerecha.getPeso():null) + "]";
	}
    
    
}
