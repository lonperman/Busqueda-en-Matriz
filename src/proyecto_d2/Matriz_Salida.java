/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_d2;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class Matriz_Salida {

    public Vector<Salidas> Matriz_Salida(int[][] MatrizInt, boolean[][] MatrizBoolean) {
        int[][] Matriz_creada = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};

        mover m = new mover();
        Vector<Arbol> resultado = m.mover(MatrizInt, MatrizBoolean);
        Vector<Salidas> salida = new Vector<Salidas>();

        for (int i = 0; i < resultado.size(); i++) {
            boolean[][] Matriz_B = resultado.get(i).getMatrizBooleanPro();
            
            

            for (int l = 0; l < Matriz_B.length; l++) {
                for (int j = 0; j < Matriz_B.length; j++) {
                    /*System.out.println("Resultados de booelanas : " + Matriz_B[l][j]);*/
                    if (Matriz_B[l][j] = true) {

                        int[][] matrizActual = new int[6][6];

                        for (int k = 0; k < Matriz_B.length; k++) {
                         for (int n = 0; n < Matriz_B[0].length; n++) {
                         matrizActual[k][n] = Matriz_creada[k][n];
                         }

                         }
                         
                        matrizActual[i][j] = 1;

                        Salidas hijonuevo = new Salidas(matrizActual);
                        salida.addElement(hijonuevo);
                    }
                }
            }

        }

        return salida;
    }

}
