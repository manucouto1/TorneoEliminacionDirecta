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
public class Abb <T extends Nodo>{
	
	/* Atributos */
    private T raiz;
    private int altura;
    /* Contructories */    
    public Abb() {}
 
 
    /* Setters y Getters */
    public T getRaiz() {
        return (T) raiz;
    }
 
    public void setRaiz(T raiz) {
        this.raiz = raiz;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
      
    private void addNodo( T nodo, Nodo raiz ) {
        
        if ( raiz == null ) {
            
            nodo.setNivel(1);
            this.setRaiz(nodo);
            System.out.println(" -- Nodo Raiz >> "+nodo);
        }
        else {
            if ( nodo.getPeso() <= raiz.getPeso() ) {
                if (raiz.getHojaIzquierda() == null) {
                    nodo.setNivel(raiz.getNivel()+1);
                    nodo.setPadre(raiz);
                    raiz.setHojaIzquierda(nodo);
                    System.out.println(" -- hojaIzquierda > "+nodo);
                }
                else {
                    addNodo( nodo , raiz.getHojaIzquierda() );
                }
            }
            else {
                if (raiz.getHojaDerecha() == null) {
                    nodo.setNivel(raiz.getNivel()+1);
                    nodo.setPadre(raiz);
                    raiz.setHojaDerecha(nodo);
                    System.out.println(" -- hojaDerecha > "+nodo);
                }
                else {
                    addNodo( nodo, raiz.getHojaDerecha() );
                }
            }
        }
    }
 
    public void addNodo( T nodo ) {
        this.addNodo( nodo , this.raiz );
    }

}
