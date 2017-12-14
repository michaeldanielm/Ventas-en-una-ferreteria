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
 public class ContPro {
         public Producto[] base= new Producto[1000];
         public Coder cod =new Coder();
         public int c1,nP,prT;
     public void addPro(Producto p){
         prT++;
         while(base[nP]!=null){
              nP++;
         }
         base[nP]=new Producto();
         base[nP]=p;
         base[nP].codigo="P-"+cod.codigo(nP);
         nP=0;
     }
     public Producto give(int pos){
       Producto retur=new Producto();
       retur=base[pos];
     return retur;
     }
     public Producto searchPro(String wanted){
         Producto returned=new Producto();
         c1=0;
             while (c1<prT) {
                 if(base[c1]!=null){
                 if(base[c1].nombre.equalsIgnoreCase(wanted)){
                     returned.nombre=base[c1].nombre;            
                     returned.cantidad=base[c1].cantidad;
                     returned.codigo=base[c1].codigo;
                     returned.valor=base[c1].valor;
                     returned.ubicacion=base[c1].ubicacion;
                     c1=prT+1;}
                 }            
                     c1++;
             }
                 return returned;
     }
 
     public String list(){
         String retu="";
         for(int i=0;i<prT;i++){
             if(base[i]!=null){
             retu=retu+"<tr><th>"+base[i].codigo+"</th><th>"+base[i].nombre+"</th><th>"+" $ "+base[i].valor+"</th><th>"+base[i].cantidad+"</th><th>"+base[i].ubicacion+"</th></tr>";
         }}
     return retu;
         
     }  
     
     public void Change(Producto inP,int pos){
           base[pos]=new Producto();
           base[pos]=inP;
     }
     
     public String buscarEscasos(){
          int nE=0;
          String retu="";
          for(int i=0;i<prT;i++){
              if(base[i]!=null){
             if(base[i].cantidad<=5){
                  retu=retu+"<tr><th>"+base[i].codigo+"</th><th>"+base[i].nombre+"</th><th>"+" $ "+base[i].valor+"</th><th>"+base[i].cantidad+"</th><th>"+base[i].ubicacion+"</th></tr>";    
             }
          }}
          return retu;
     }
     public void supr(int p){
        base[p]=null;  
     }    
        
 } 
     

