/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_d2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
// hay esta pa
public class Lectura {

    public int num_Vert = 6;
    private int[][] matriz = new int[num_Vert][num_Vert];
    private String Ruta_Matriz = " ";

    public Lectura(String Ruta_Matriz) {
        this.Ruta_Matriz = Ruta_Matriz;
    }

    public String getRuta() {
        return Ruta_Matriz;
    }

    public void setRuta() {
        this.Ruta_Matriz = Ruta_Matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] generaMatriz() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {

            archivo = new File(this.Ruta_Matriz);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //pertae hacemos algo
            String temp = "";
            String linea;

            /* this.matriz = new int[num_Vert][num_Vert];*/
            int ln = 0;
            while ((linea = br.readLine()) != null) {
                temp = temp + linea;
                String vecticAdyacentes[] = linea.split(" ", num_Vert);
                for (int j = 0; j < num_Vert; j++) {
                    matriz[ln][j] = Integer.parseInt(vecticAdyacentes[j]);//Mire haber que pasa
                }
                ln++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    public void imprimir(int[][] g) {
        int numVertices = this.num_Vert;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println(" ");
        }
    }

}//Cerrado de clase
