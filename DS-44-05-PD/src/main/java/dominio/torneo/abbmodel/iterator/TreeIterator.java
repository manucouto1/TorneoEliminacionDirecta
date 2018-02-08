/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.torneo.abbmodel.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import dominio.torneo.abbmodel.Nodo;

/**
 *
 * @author manuc
 */
public class TreeIterator implements Iterator<Nodo>{
    
    private Queue<Nodo> colaAuxiliar = new LinkedList<>();
	
    public TreeIterator(Nodo t){
        this.colaAuxiliar.add( t);
    }
    
    @Override
    public boolean hasNext() {
        return colaAuxiliar.isEmpty();
    }

    @Override
    public Nodo next() {
        Nodo nodo = colaAuxiliar.remove();
        colaAuxiliar.add(nodo.getHojaIzquierda());
        colaAuxiliar.add(nodo.getHojaDerecha());
        return nodo;
    }
    
}
