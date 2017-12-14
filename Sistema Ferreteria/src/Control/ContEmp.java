/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.*;
import Tools.*;

/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
 public class ContEmp {
         public Empleado [] base= new Empleado[1000];
         public Coder cod =new Coder();
         public int c1,emT;
         ContPro p=new ContPro();
     public void addEmp(Empleado e){
         
        
         base[emT]=new Empleado();
         base[emT]=e;
         base[emT].codigo="E-"+cod.codigo(emT);
         emT++;
     }
     public Empleado searchEmp(String wanted){
         Empleado returned=new Empleado();
         c1=0;
             while (c1<emT) {
                 if(base[c1]!=null){
                 if(base[c1].nombre.equalsIgnoreCase(wanted)){
                     returned.nombre=base[c1].nombre;            
                     returned.cc=base[c1].cc;
                     returned.codigo=base[c1].codigo;
                     returned.telefono=base[c1].telefono;
                     returned.adress=base[c1].adress;
                     c1=emT+1;}
                 }            
                     c1++;
             }
                 return returned;
     }

     public String listEmp(){
         String retu="";
         for(int i=0;i<emT;i++){
             if(base[i]!=null){
             retu=retu+"<tr><th>"+base[i].codigo+"</th><th>"+base[i].nombre+"</th><th>"+base[i].cc+"</th><th>"+base[i].telefono+"</th><th>"+base[i].adress+"</th></tr>";
         }}
     return retu; 
     }  
     
     public void ChangeEmp(Empleado inE,int pos){
         base[pos]=inE;
     }     
 } 
     

