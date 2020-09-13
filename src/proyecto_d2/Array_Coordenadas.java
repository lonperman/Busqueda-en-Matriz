/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_d2;

/**
 *
 * @author Usuario
 */
public class Array_Coordenadas {
    
    private String respuesta;
    private int coordenada1;
    private int coordenada2;
    private int hojas;
    
    public Array_Coordenadas(String r,int c_1,int c_2){
        respuesta = r;
        coordenada1 = c_1;
        coordenada2 = c_2;
       
        
    }
    
    public String getRespuesta(){
        return respuesta;
    }
    
    public void setRespuesta(String respuesta){
        this.respuesta = respuesta;
    }
    
    public int getCordenada1(){
        return coordenada1;
    }
    
    public void setCoordenada1(int coordenada1){
        this.coordenada1 = coordenada1;
    }
    
    public int getCoordenada2(){
        return coordenada2;
    }
    
    public void setCoordenada2(int coordenada2){
        this.coordenada2 = coordenada2;
    }
    
    public int getHojas(){
        return hojas;
    }
    
    public void setHojas(int hojas){
        this.hojas = hojas;
    }
}
