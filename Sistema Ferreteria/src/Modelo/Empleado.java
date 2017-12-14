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
public class Empleado {
    public String nombre,telefono,adress,codigo,cc;
    public String toString(){  
         String res;
         res="\nNombre: "+nombre+"\nCodigo: "+codigo+"\nC.c: "+cc+"\nTelefono: "+telefono+"\nDireccion: "+adress;
         return res;
    }
}
