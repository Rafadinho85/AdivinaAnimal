
package adivina;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Adivina{
    public static void main (String [] pps) { 
     char ch = ' ';
     String c;
     boolean valido, mas = true;
     

    BufferedReader entrada = new BufferedReader(
	            new InputStreamReader(System.in));
			
        while(mas)
        {
          System.out.println("Para terminar la simulación: X.");
          try {
              do {
                System.out.print("acción(J/V/E): ");
                System.out.println("\n[J] - Jugar \n[V] - Ver Árbolito");
                c = entrada.readLine();
                ch = c.charAt(0); 
                ch = Character.toUpperCase(ch);
                valido = (c.length() == 1) &&
               (ch == 'J' || ch == 'V');
              } while(!valido);
              
              if(ch == 'J')
              {
                 
                System.out.println("Juguemos a adivinar animales");
                boolean otroJuego = true;
                Adivina juego = new Adivina();
                
                do {
                  
                  juego.jugar(); 
                  System.out.println("Jugamos otra vez?");
                  otroJuego = juego.respuesta();
                } while (otroJuego);
            	  
              }
                if(ch == 'V')
              {
                  deserialNodo d = new deserialNodo();
                  NodoArbol nodo = d.deserializeNodo("C:\\Users\\rafa8\\Desktop\\animal.txt");
            	  System.out.println("----");
                  Auxiliar a = new Auxiliar();
                  System.out.println(a.recorrido2(a.imprimirNivel(nodo), "IMPRESION DE NIVELES"));
                  System.out.println("----");
              }
           
          }
          catch(Exception e)
          {
        	  System.out.println("PROBLEMAS");
          }
          mas = !(ch == 'X');
        }
	System.out.println("SIMULACIÓN TERMINADA"); 
  } 
    
    public static NodoArbol raiz, aux;
    private Scanner in;
    static serializeNodo s = new serializeNodo();

    /**
     * Constructor Crea el nodo raiz con un Perro
     */
    public Adivina (){
	raiz = new NodoArbol("Perro");  //El arbol se iniciará con un animal
        deserialNodo d = new deserialNodo();
        raiz = d.deserializeNodo("C:\\Users\\rafa8\\Desktop\\animal.txt");
	in = new Scanner(System.in); //Scanner para pedir que ingresen los animales
    }
    
    //metodo para visualizar el valor del nodo
    public void visualizar(NodoArbol nodo)
    {
        System.out.println(nodo.valor);
    }
    
    //metodo que desplegara nuesto arbol primero raiz, luego subarbol izq y luego subarbol der.
     public void desplegar(NodoArbol raiz)
    {
    	if(raiz != null)
    	{
    		System.out.print(raiz.valor.toString() + " ");
    		desplegar(raiz.izquierda);
    		desplegar(raiz.derecha);
    	}
    }
     
    /**
     * Metodo para jugar a adivinar animales
     */
   public void jugar() {   
    NodoArbol nodo = raiz;
    System.out.println("----");
    
    Auxiliar a = new Auxiliar();
    System.out.println(a.recorrido2(a.imprimirNivel(nodo), "IMPRESION DE NIVELES"));
    System.out.println("----");
    
    while (nodo != null) { 
        
      if (nodo.izquierda != null) {   //Hay una pregunta
        System.out.println(nodo.valor); //hara la pregunta 
        nodo = (respuesta()) ? nodo.izquierda : nodo.derecha; //si resp. es true nodo.izquierda else nodo.derecha
      } else {  // Se tiene un animal
        System.out.println("Ya sé, es un(a) " + nodo.valor);  //dice que animal es
        if (respuesta())
        {
        //si la respuesta es true
          System.out.println("Gané :) Yey!");       
        }
        else 
        {
           animalNuevo(nodo);//crea un nuevo animal    
        }
        //si no existe el animal lo crea en el archivo txt
        s.serialize(raiz);
        nodo = null;
	return;
      }
     
    }
    
  }


  private boolean respuesta () { 
      
          while (true) { //mientras no true
          System.out.println("RESPUESTA: ");
	  String resp = in.nextLine().toLowerCase().trim();
          

	  if (resp.equals("si")) return true;
	  if (resp.equals("no")) return false;
	  System.out.println("La respuesta debe ser si o no");
        }
  }
 
  private void animalNuevo (NodoArbol nodo) {
    String animalNodo = (String) nodo.valor; //jala al animal que esta en la raiz
    System.out.println("Cuál es tu animal?");
    String nuevoA = in.nextLine(); //se ingresa el animal
    System.out.println("Qué pregunta con respuesta si/no puedo hacer" +
             " para poder decir que es un(a) " + nuevoA);
    String pregunta = in.nextLine(); //se ingresa la pregunta
    NodoArbol nodo1 = new NodoArbol(animalNodo); //se hace un nodo con el animal
    NodoArbol nodo2 = new NodoArbol(nuevoA); //se hace un nodo con el animal nuevo
    System.out.println("Para un(a) " + nuevoA + " la respuesta es si/no?");
    nodo.valor = ""+pregunta+"?"; //se deja a la raiz con el valor de la pregunta
    if (respuesta()) { //si la respuesta es true
	nodo.izquierda = nodo2; //el nodo 2 (nuevo) se irá para la izquierda
	nodo.derecha = nodo1; //el nodo 1 (animalNodo) se irá a la derecha
        
    } else {
	nodo.izquierda = nodo1; //el animalNodo se ira a la izquierda
	nodo.derecha = nodo2; //el animalNodo se irá a la derecha
    }
    s.serialize(nodo);
  }
  
  
  
  
    
}
