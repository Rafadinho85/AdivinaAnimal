package adivina;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class serializeNodo {
    public void serialize(NodoArbol nodo) {
//Guarda el Nodo en el archivo de texto, por eso el parametro es NodoAbol
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream("C:\\Users\\rafa8\\Desktop\\animal.txt");//CREA EL ARCHIVO DE TEXTO 
			oos = new ObjectOutputStream(fout);
			oos.writeObject(nodo);
                        fout.close();
			System.out.println("Creado");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
