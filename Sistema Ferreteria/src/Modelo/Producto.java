package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
public class Producto {
     public String nombre,codigo,ubicacion;
     public int cantidad; 
     public float valor;
     public String toString(){
         
          String pro;
          pro="Nombre: "+nombre+"\nCodigo: "+codigo+"\nUbicacion: "+ubicacion+"\nCantidad: "+cantidad+"\nPrecio: "+" $ "+valor;
     return pro;
     }
    
}

