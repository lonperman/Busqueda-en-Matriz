/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_d2;

import java.util.*;

/**
 *
 * @author Usuario
 */
public class Arbol {

    private int[][] MatrizJuego;
    private boolean[][] MatrizBoolean;
    private int hojas;
    private int recorrido;

    Arbol(int[][] MatrizJuego, boolean[][] MatrizBoolean,int hojas,int recorrido) {
        this.MatrizJuego = MatrizJuego;
        this.MatrizBoolean = MatrizBoolean;
        this.hojas = hojas;
        this.recorrido = recorrido;
    }

   
   

    public int[][] getMatrizJuegoPro() {
        return MatrizJuego;
    }

    public boolean[][] getMatrizBooleanPro() {
        return MatrizBoolean;
    }
    
    public int getHojas(){
        return hojas;
    }
    
    public int getRecorrido(){
        return recorrido;
    }

    public String getMatrizJuego() {
        String fila1 = Arrays.toString(MatrizJuego[0]);
        String fila2 = Arrays.toString(MatrizJuego[1]);
        String fila3 = Arrays.toString(MatrizJuego[2]);
        String fila4 = Arrays.toString(MatrizJuego[3]);
        String fila5 = Arrays.toString(MatrizJuego[4]);
        String fila6 = Arrays.toString(MatrizJuego[5]);
        return fila1 + "\n" + fila2 + "\n" + fila3 + "\n" + fila4
                + "\n" + fila5 + "\n" + fila6;
 
    }

    public String getMatrizBoolean() {
        String fila1 = Arrays.toString(MatrizBoolean[0]);
        String fila2 = Arrays.toString(MatrizBoolean[1]);
        String fila3 = Arrays.toString(MatrizBoolean[2]);
        String fila4 = Arrays.toString(MatrizBoolean[3]);
        String fila5 = Arrays.toString(MatrizBoolean[4]);
        String fila6 = Arrays.toString(MatrizBoolean[5]);
        return fila1 + "\n" + fila2 + "\n" + fila3 + "\n" + fila4
                + "\n" + fila5 + "\n" + fila6;

    }

}
