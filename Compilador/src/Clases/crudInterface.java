/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import modelo.conexion;

/**
 *
 * @author elearning02
 */
public interface crudInterface {
    
    public int imCrate();   // 1-Correcto, 0-Error
    public int imRead();    // 1-Si encontró, 0-No se encontró  
    public int imUpdate(); // 1-Correcto, 0-Error
    public int imDelete(); // 1-Correcto, 0-Error
    
    public void imFind();
    public int imFirst();  // 1-Si encontró, 0-No se encontró
    public int imNext(); // 1-Si encontró, 0-No se encontró
    public int imPrior(); // 1-Si encontró, 0-No se encontró
    public int imLast(); // 1-Si encontró, 0-No se encontró
    
    public void imPrint();
    public void imInsDet();
    public void imDelDet();
    public void imClose();
    /*
    * Habrá que controlar el tipo de dato del atributo ya que el método
    * recibe el valor como un string y se deberá cambiar en caso necesario
    */
    public void setItem(String attibute, String value);
    /*
    * Habrá que controlar el tipo de dato de la variable destino ya que el método
    * devuelve el valor como un string y se deberá cambiar en caso necesario
    */
    public String getItem(String attibute);

    public void imConect(conexion coneccion);
    
    public Object[][] imList(String condicion);
}
