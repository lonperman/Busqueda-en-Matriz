/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_d2;

import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class Generador {

    boolean f;
    boolean v;
    int nodos = 0;
    int hojas =0;
    int recorrido =0;
    /*private int MatrizInicial[][] = {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{3,0,0,0,0,0},{0,0,0,0,0,0},{1,0,0,0,0,0}} ;
     private boolean MatrizBoolean[][] = {{ f,f,f,f,f,f},{f,f,f,f,f,f},{f,f,f,f,f,f},{f,f,f,f,f,f}
     ,{f,f,f,f,f,f},{f,f,f,f,f,f}};*/

    public Generador() {
        this.f = false;
        this.v = true;

    }

    public void generar(int[][] Matriz_Inicial, boolean[][] Matriz_Boolean,Vector<Arbol> contador) {

        /* this.MatrizInicial = MatrizInicial;
         this.MatrizBoolean = MatrizBoolean; */
        Arbol objArbol = new Arbol(Matriz_Inicial, Matriz_Boolean,hojas,recorrido);
         /*System.out.println(objArbol.getMatrizJuego());
         System.out.println(objArbol.getMatrizBoolean());*/
       
        

        while (true) {
            int[][] matrizCopia1 = objArbol.getMatrizJuegoPro();
            boolean[][] matrizCopia2 = objArbol.getMatrizBooleanPro();

          
            mover m = new mover();

            /*m.mover(matrizCopia1,matrizCopia2*/
            if (m.mover(matrizCopia1, matrizCopia2) == null) {
                
            } //Imorimir la ultima matriz
            else {

                Vector<Arbol> hijos = m.mover(matrizCopia1, matrizCopia2);
                for (int i = 0; i < hijos.size(); i++) {
                    Arbol arbolActual = hijos.elementAt(i);
                    hojas = hojas + hijos.get(i).getHojas();
                    if(hijos.get(i).getRecorrido()>0){
                    recorrido = hijos.get(i).getRecorrido();
                    }
                    /*  System.out.println("Primer nivel\n");*/

                    int[][] matrizNietos = arbolActual.getMatrizJuegoPro();
                    boolean[][] matrizBoole = arbolActual.getMatrizBooleanPro();
                   // System.out.println(arbolActual.getMatrizJuego());
                   // System.out.println(arbolActual.getMatrizBoolean());
                   /* System.out.println("Tamaño del Vector : " + hijos.size());
                    System.out.println("Cantidad de hijos : " + contador.size());*/

                    //generar(hijos.MatrizdeEnetero, hijos.matrizBooleana)
                    if (matrizNietos != null && matrizBoole != null) {
                        for (int k = 0; k < hijos.size(); k++) {
                            int[][] Nieto = hijos.get(k).getMatrizJuegoPro();
                            boolean[][] Boole = hijos.get(k).getMatrizBooleanPro();

                            generar(Nieto, Boole,contador);
                            contador.addElement(hijos.remove(k));
                            nodos = nodos + contador.size();
                          
                            
                            

                        }
                        

                    }

                }
                
              
            }
             

            break;

        }
        
        
    }
public void mostrar(){
    int resultado = nodos - hojas;
     System.out.println("Tamaño de nodos Internos  : " + resultado); 
     if(recorrido>0){
     System.out.println("Altura : " + recorrido);
     }
     System.out.println("Numero de Hojas : " + hojas);
}

   


}
