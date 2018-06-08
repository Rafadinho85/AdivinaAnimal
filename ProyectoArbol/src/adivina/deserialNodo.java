/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class deserialNodo {
     public NodoArbol deserializeNodo(String filename) {
//lee el archivo, y construye un arbol con el archiivo  de txt
		NodoArbol address = null;
                    //crea el nodo nuevo
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			address = (NodoArbol) ois.readObject();
                        //escribe cada linea del archivo, y crea un nodo nuevo con esos datos.

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return address;

	}
}
