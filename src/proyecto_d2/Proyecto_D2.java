/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_d2;

import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
/**
 *
 * @author Usuario
 */
public class Proyecto_D2 {
   
    

    /**
     * @param args the command line arguments
     */
    
    static Scanner s = new Scanner(System.in);
  
   
    
    public static void main(String[] args) throws IOException{
    
    boolean f = false;
    boolean v = true;
    Vector<Arbol> contador = new Vector<Arbol>();
     Vector<Salidas> salidas = new Vector<Salidas>();
    
    /*int MatrizInicial[][] = {{1,0,0,0,3,0},{0,5,3,2,0,0},{0,3,3,0,3,0},{3,3,4,0,0,0},{4,3,3,0,0,0},{5,3,3,0,0,0}} ;*/
    boolean MatrizBoolean[][] = {{ f,f,f,f,f,f},{f,f,f,f,f,f},{f,f,f,f,f,f},{f,f,f,f,f,f},{f,f,f,f,f,f},{f,f,f,f,f,f}};
    
       
         
        
        // TODO code application logic here
        
      
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("Ingrese la ruta del archivo: \n");
        
        String ruta = s.next();
        
    
    
        
        
        Lectura lec = new Lectura(ruta);
        int [][] matriz = lec.generaMatriz();
        
        /*System.out.println("Matriz" + matriz);*/ 
        Generador objClase = new Generador();
        objClase.generar(matriz,MatrizBoolean,contador);
        objClase.mostrar();
        ///////////////////////////////////////////////////////////////////////////////////////////
        FileWriter fichero = new FileWriter("D:/Discretas_ 2/Proyecto_D2/src/salida.txt");
        for(int i=0;i<contador.size();i++){
             fichero.write(contador.get(i).getMatrizJuego()+ "\n"+"-------------------------"+ "\n");
        }
        
        Matriz_Salida salida = new Matriz_Salida();
        
        for(int j=0;j<contador.size();j++){
            salidas = salida.Matriz_Salida(contador.get(j).getMatrizJuegoPro(), MatrizBoolean);
            
        }
        /*
       for(int k=0;k<salidas.size();k++){
            System.out.println("Datos de Salida : " + "\n" + salidas.get(k).getMatrizJuego()+ "\n"+"-------------------------"+ "\n");
        }
        */
       
        
       /* for(int k=0;k<salidas.size();k++){
            System.out.println("Datos de Salida : " + "\n" + salidas.get(k).getMatrizJuego()+ "\n"+"-------------------------"+ "\n");
        }*/
        
        
        FileWriter fichero_2 = new FileWriter("D:/Discretas_ 2/Proyecto_D2/src/incidencia.txt");
        for(int i=0;i<salidas.size();i++){
             fichero_2.write(salidas.get(i).getMatrizJuego()+ "\n"+"-------------------------"+ "\n");
        }
        
        
       
        
        /*Lector l = new Lector();
        System.out.println(l.generarMatriz("D:\\ejemplo.txt"));*/
     
        
        
    }
    
}
