/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.*;
import Tools.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
 public class ContCli {
              ContPro cP=new ContPro();
         public Cliente[] base= new Cliente[1000];
         public Coder cod =new Coder();
         public int c1,clT;
     public void addCli(Cliente c){
                  
         base[clT]=new Cliente();
         base[clT].cc=c.cc;
         base[clT].nombre=c.nombre;
         base[clT].codigo=c.codigo;
         base[clT].telefono=c.telefono;
         base[clT].codigo="C-"+cod.codigo(clT);
         clT++;
     }
     public Cliente searchCli(String wanted){
         Cliente returned=new Cliente();

         c1=0;
             while (c1<clT) {
                 if(base[c1]!=null){
                 if(base[c1].cc.equalsIgnoreCase(wanted)){
                     returned.nombre=base[c1].nombre;            
                     returned.cc=base[c1].cc;
                     returned.codigo=base[c1].codigo;
                     returned.telefono=base[c1].telefono;
                     c1=clT+1;}
                 }            
                     c1++;
                     
             }
                 return returned;
     }

     public String listCli(){      
         String retu="";
         for(int i=0;i<clT;i++){
             if(base[i]!=null){
             retu=retu+"<tr><th>"+base[i].codigo+"</th><th>"+base[i].nombre+"</th><th>"+base[i].cc+"</th><th>"+base[i].telefono+"</th></tr>";
         }}
     return retu;
         
     }  
     
     public void ChangeCli(String inP,int pos){
         
         base[pos].telefono=inP;
     }      
 } 
     

