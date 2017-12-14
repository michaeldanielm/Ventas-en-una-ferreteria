/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
public class Cliente {
     public String nombre,codigo,cc,telefono;
     public String toString(){
         String re;
         re="Nombre: "+nombre+"\nCodigo: "+codigo+"\nC.c: "+cc+"\nTelefono: "+telefono;
         return re;
     }
}
