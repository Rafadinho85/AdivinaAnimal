/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.io.Serializable;

public class NodoArbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Object valor; //valor que almacenado en el nodo
    public NodoArbol izquierda; //liga a la izquierda
    public NodoArbol derecha; //liga a al a derecha
    
    public NodoArbol (){
        this (null, null, null);
    }
    
    public NodoArbol(Object valor){
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
    
    public NodoArbol (NodoArbol iz, Object v, NodoArbol der){
        valor = v;
        izquierda = iz;
        derecha = der;
    }
    
        
}
