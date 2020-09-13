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
public class mover {
    /*  private int[][] matrizJ;
     private char[][] matrizB;*/

    boolean f;
    boolean v;
    int hojas = 0;
    int recorrido = 0;
    

    public mover() {
        this.f = false;
        this.v = true;
    }

    public Vector<Arbol> mover(int[][] MatrizJuego, boolean[][] MatrizBoolean) {

        Vector<Arbol> hijos = new Vector<Arbol>();

        int[] coordenadas = buscador(MatrizJuego);
        Array_Coordenadas[] movimientos = analizador(MatrizJuego, MatrizBoolean, buscador(MatrizJuego));

        for (int i = 0; i < movimientos.length; i++) {

            //System.out.println("Coordenadas Encontradas: " + movimientos[i].getCordenada1() + ", " + movimientos[i].getCoordenada2());
            int movimiento1 = movimientos[i].getCordenada1();
            int movimiento2 = movimientos[i].getCoordenada2();
            String respuesta = movimientos[i].getRespuesta();
            int[][] MatrizActual = new int[6][6];
            boolean[][] BooleanActual = new boolean[6][6];

            if (respuesta.equals("False")) {

               

                for (int k = 0; k < MatrizJuego.length; k++) {

                    for (int l = 0; l < MatrizJuego.length; l++) {
                        MatrizActual[k][l] = MatrizJuego[k][l];
                        BooleanActual[k][l] = MatrizBoolean[k][l];

                    }
                }

                MatrizActual[movimiento1][movimiento2] = 1;
                MatrizActual[coordenadas[0]][coordenadas[1]] = 0;
                BooleanActual[coordenadas[0]][coordenadas[1]] = v;

                Arbol hijonuevo = new Arbol(MatrizActual, BooleanActual,hojas,0);
                hijos.addElement(hijonuevo);

            } else if (respuesta.equals("True")) {
                /*System.out.println("Ganaste ");*/
                /*BooleanActual[coordenadas[0]][coordenadas[1]] = v;*/
                for(int m=0;m<BooleanActual.length;m++){
                    for(int j=0;j<BooleanActual.length;j++){
                        if(MatrizBoolean[m][j] == true){
                            recorrido = recorrido + 1;
                        }
                         /*System.out.println("Matriz Booleana : " + MatrizBoolean[m][j] + "Numero de Recorrido : " + recorrido);*/               
                    }  
                }
                
                MatrizActual[movimiento1][movimiento2] = 1;
                MatrizActual[coordenadas[0]][coordenadas[1]] = 0;
                BooleanActual[coordenadas[0]][coordenadas[1]] = v;
                BooleanActual[movimiento1][movimiento2] = v;

                Arbol hijonuevo = new Arbol(MatrizActual, BooleanActual,hojas,recorrido);
                hijos.addElement(hijonuevo);
            }/*else {
                int c_arreglo = 0;
                for(int m=0;m<movimientos.length;m++){
                    if(respuesta.equals("Vacio")){
                         
                        c_arreglo = c_arreglo + 1;
                    }
                }
                if(c_arreglo == movimientos.length){
                    System.out.println("Perdiste ");
                }
            }*/
        }
        return hijos;
    }

    public int[] buscador(int[][] matriz) {

        int[] coordenadas = new int[2];

        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz.length; x++) {
                if (matriz[x][y] == 1) {
                    /* System.out.println("Encontrado en las Coordenadas" + '\n'+ y + '\n' + x);*/
                    coordenadas[0] = x;
                    coordenadas[1] = y;

                }
            }
        }
        /* System.out.println("Resultado" + coordenadas0] + ", " + coordenadas[1] );*/
        return coordenadas;

    }

    public Array_Coordenadas[] analizador(int[][] matrizJ, boolean[][] matrizB, int[] coordenadas) {

        int coor1 = coordenadas[0];
        int coor2 = coordenadas[1];
        int movimiento = 0;
       
        Array_Coordenadas movimientos[] = new Array_Coordenadas[4];

        for (int i = 0; i < movimientos.length; i++) {
            movimientos[i] = null;
        }

        movimientos[0] = new Array_Coordenadas("Vacio", 0, 0);
        movimientos[1] = new Array_Coordenadas("Vacio", 0, 0);
        movimientos[2] = new Array_Coordenadas("Vacio", 0, 0);
        movimientos[3] = new Array_Coordenadas("Vacio", 0, 0);

        if (coor1 == 0 && coor2 == 0) {
            for (int contador = 0; contador < 2; contador++) {
                if (contador == 0 && coor1 == 0 && coor2 == 0) {
                    movimiento = coor2 + 1;

                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3
                            && matrizJ[coor1][movimiento] != 4 && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);
                    } else {
                      hojas = hojas + 1;  
                    }
                }
                if (contador == 1 && coor1 == 0 && coor2 == 0) {
                    movimiento = coor1 + 1;

                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else {
                        hojas = hojas + 1; 
                    }
                }

            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////           
        if (coor1 == 5 && coor2 == 0) {
            for (int contador = 0; contador < 2; contador++) {
                if (contador == 0 && coor1 == 5 && coor2 == 0) {
                    movimiento = coor1 - 1;

                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    } else {
                        hojas = hojas + 1; 
                    }
                } else if (contador == 1 && coor1 == 5 && coor2 == 0) {
                    movimiento = coor2 + 1;

                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else{
                        hojas = hojas + 1; 
                    }
                }
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (coor1 == 5 && coor2 == 5) {
            for (int contador = 0; contador < 2; contador++) {
                if (contador == 0 && coor1 == 5 && coor2 == 5) {
                    movimiento = coor1 - 1;

                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else {
                        hojas = hojas + 1; 
                    }
                } else if (contador == 1 && coor1 == 5 && coor2 == 5) {
                    movimiento = coor2 - 1;

                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    } else {
                        hojas = hojas + 1; 
                    }
                }
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (coor1 == 0 && coor2 == 5) {
            for (int contador = 0; contador < 2; contador++) {
                if (contador == 0 && coor1 == 0 && coor2 == 5) {
                    movimiento = coor1 + 1;

                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[0] = new Array_Coordenadas("True", movimiento, coor2);

                    } else {
                        hojas = hojas + 1; 
                    }
                } else if (contador == 1 && coor1 == 0 && coor2 == 5) {
                    movimiento = coor2 - 1;

                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    } else {
                        hojas = hojas + 1; 
                    }
                }
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        if (coor2 > 0 && coor2 < 5 && coor1 < 1) {
            for (int contador = 0; contador < 3; contador++) {
                if (contador == 0 && coor2 > 0 && coor2 < 5 && coor1 < 1) {
                    movimiento = coor2 - 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else {
                        hojas = hojas + 1; 
                    }
                }
                if (contador == 1 && coor2 > 0 && coor2 < 5 && coor1 < 1) {
                    movimiento = coor1 + 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else{
                        hojas = hojas + 1; 
                    }
                }//
                if (contador == 2 && coor2 > 0 && coor2 < 5 && coor1 < 1) {
                    movimiento = coor2 + 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor2, movimiento);

                    }else {
                        hojas = hojas + 1; 
                    }
                }

            }

        }//if
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (coor1 > 0 && coor1 < 5 && coor2 < 1) {
            for (int contador = 0; contador < 3; contador++) {
                if (contador == 0 && coor1 > 0 && coor1 < 5 && coor2 < 1) {
                    movimiento = coor1 - 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else {
                        hojas = hojas + 1; 
                    }
                }
                if (contador == 1 && coor1 > 0 && coor1 < 5 && coor2 < 1) {
                    movimiento = coor2 + 1;
                    
                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else{
                        hojas = hojas + 1; 
                    }
                }
                if (contador == 2 && coor1 > 0 && coor1 < 5 && coor2 < 1) {
                    movimiento = coor1 + 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    } else {
                        hojas = hojas + 1; 
                    }
                }//

            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (coor2 > 0 && coor2 < 5 && coor1 > 4) {
            for (int contador = 0; contador < 3; contador++) {
                if (contador == 0 && coor2 > 0 && coor2 < 5 && coor1 > 4) {
                    movimiento = coor2 - 1;

                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else{
                        hojas = hojas + 1; 
                    }
                }
                if (contador == 1 && coor2 > 0 && coor2 < 5 && coor1 > 4) {
                    movimiento = coor1 - 1;

                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else{
                        hojas = hojas + 1; 
                    }
                }
                if (contador == 2 && coor2 > 0 && coor2 < 5 && coor1 > 4) {
                    movimiento = coor2 + 1;

                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else {
                        hojas = hojas + 1; 
                    }
                }//

            }
        }//for
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (coor1 > 0 && coor1 < 5 && coor2 > 4) {

            for (int contador = 0; contador < 3; contador++) {

                if (contador == 0 && coor1 > 0 && coor1 < 5 && coor2 > 4) {
                    movimiento = coor1 - 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    } else {
                        hojas = hojas + 1; 
                    }
                }
                if (contador == 1 && coor1 > 0 && coor1 < 5 && coor2 > 4) {
                    movimiento = coor2 - 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    } else {
                        hojas = hojas + 1;
                    }
                }
                if (contador == 2 && coor1 > 0 && coor1 < 5 && coor2 > 4) {
                    movimiento = coor1 + 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else{
                        hojas = hojas + 1;
                    }
                }//

            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (coor1 > 0 && coor1 < 5 && coor2 > 0 && coor2 < 5) {
            for (int contador = 0; contador < 4; contador++) {
                if (contador == 0) {
                    movimiento = coor2 - 1;
                  
                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else {
                        hojas = hojas + 1;
                    }
                }
                if (contador == 1) {
                    movimiento = coor1 + 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    }else {
                        hojas = hojas + 1;
                    }

                }
                if (contador == 2) {
                    movimiento = coor2 + 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] != 2 && matrizJ[coor1][movimiento] != 3 && matrizJ[coor1][movimiento] != 4
                            && matrizJ[coor1][movimiento] != 5 && matrizJ[coor1][movimiento] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", coor1, movimiento);

                    } else if (matrizB[coor1][movimiento] == f && matrizJ[coor1][movimiento] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", coor1, movimiento);

                    }else {
                        hojas = hojas + 1;
                    }

                }

                if (contador == 3) {
                    movimiento = coor1 - 1;
                    /*System.out.println("Condicional 3 : " + movimiento + ", " + coor2);*/
                    if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] != 2 && matrizJ[movimiento][coor2] != 3 && matrizJ[movimiento][coor2] != 4
                            && matrizJ[movimiento][coor2] != 5 && matrizJ[movimiento][coor2] != 6) {

                        movimientos[contador] = new Array_Coordenadas("False", movimiento, coor2);

                    } else if (matrizB[movimiento][coor2] == f && matrizJ[movimiento][coor2] == 2) {
                        movimientos[contador] = new Array_Coordenadas("True", movimiento, coor2);

                    } else {
                        hojas = hojas + 1;
                    }

                }

            }
        }
        return movimientos;
    }

}
