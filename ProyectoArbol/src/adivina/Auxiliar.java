/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.util.ArrayList;


public class Auxiliar {
    public int altura = 0;
        //----------MÉTODOS----------
    //altura del arbol
    public int retornarAltura(NodoArbol nodo) {
        altura = 0;
        retornarAltura(nodo, 1);
        return altura;
    }

    private void retornarAltura(NodoArbol reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.izquierda, nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.derecha, nivel + 1);
        }
    }
    
    String[] niveles;
public ArrayList imprimirNivel(NodoArbol nodo) {
        niveles = new String[retornarAltura(nodo) + 1];
        ArrayList l=new ArrayList();
        imprimirNivel(nodo, 0);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + " ");
            //System.out.println(niveles[i] + " ");
        }
        return l;
    }
public void imprimirNivel(NodoArbol pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.valor + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.derecha, nivel2 + 1);
            imprimirNivel(pivote.izquierda, nivel2 + 1);
        }
    }

//Devuelve el string, solo para imprimir.
public String recorrido2(ArrayList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\n" + it.get(i).toString();
            i++;
        }
        return (r);
    }
    
   
    
}
