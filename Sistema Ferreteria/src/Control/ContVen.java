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
 public class ContVen {
        
        ContPro cP=new ContPro();
        
     
        public  Venta[] base=new Venta[1000];
         
         public Venta ve=new Venta();
         public Coder cod =new Coder(); 
         public int c1,pC,veT,c2;
     public Venta vender(Venta v){
         base[veT]=new Venta();
         base[veT].cli.nombre=v.cli.nombre;
         base[veT].cli.cc=v.cli.cc;
         base[veT].emp.nombre=v.emp.nombre;
         
         c1=0;
 
         while(ve.c[c1]!=null){
             base[veT].c[c1]=new carrito();
             base[veT].c[c1].ad=ve.c[c1].ad;
             base[veT].c[c1].cantidad=ve.c[c1].cantidad;
             base[veT].c[c1].nombre=ve.c[c1].nombre;
             base[veT].c[c1].pos=ve.c[c1].pos;
             base[veT].c[c1].subTotal=ve.c[c1].subTotal;

             c1++;
          }
         
         base[veT].codigo="V-"+cod.codigo(veT);
         int i=0;
         while(base[veT].c[i]!=null){
         base[veT].valor=base[veT].valor+base[veT].c[i].subTotal;
         i++;}
         veT++;
         
                 return base[veT-1];
                  }
     
   public void llenarCarrito(Producto p,int can,int pos){   
          ve.c[pos]=new carrito();
          ve.c[pos].nombre=p.nombre;
          ve.c[pos].cantidad=can;
          ve.c[pos].subTotal=p.valor*can;
          ve.c[pos].pos=pos+1;
          ve.c[pos].ad=Integer.parseInt(p.codigo.substring(2));       
     }
   public carrito sarchCar(String name){
          carrito car=new carrito();
         int i=0;
         boolean f=false;
         while(ve.c[i]!=null && f==false){
             if(ve.c[i].nombre.equals(name)){
                 f=true;
                 car.nombre =ve.c[i].nombre;
                 car.pos =i;
                 car.cantidad =ve.c[i].cantidad;                 
             }     
             i++;
        }
    return car;
   }

  
     public String detalleVen(String wanted){
         c1=0;
         
         String T="";
         boolean fi=false;
             while (c1<veT && fi==false) {
                 if(base[c1]!=null){
                     
                 if(base[c1].codigo.equalsIgnoreCase(wanted)){
                     fi=true;
                 
                 
                  T=T+"<tr><th>Item</th><th>Producto</th><th>Valor unitario</th><th>Cantidad</th><th>Subtotal</th></tr>";
                  c2=0;
                  while(base[c1].c[c2]!=null){
                      
                      T=T+"<tr><th>"+base[c1].c[c2].pos+"</th><th>"+base[c1].c[c2].nombre+"</th><th>"+((float)(base[c1].c[c2].subTotal/base[c1].c[c2].cantidad))+"</th><th>"+base[c1].c[c2].cantidad+"</th><th>"+base[c1].c[c2].subTotal+"</th></tr>";
                  c2++;
                  }
                   T=T+"<tr><th>Codigo de venta</th><th>Ciente</th><th>No CC del cliente</th><th>Empleado</th><th>Total a pagar</th></tr>";
                  T=T+"<tr><th>"+base[c1].codigo+"</th><th>"+base[c1].cli.nombre+"</th><th>"+base[c1].cli.cc+"</th><th>"+base[c1].emp.nombre+"</th><th>"+base[c1].valor+"</th></tr>";

                 }
                 }            
                     c1++;
             }
                 return T;
     }   
     public String listVen(){
         String retu="";
         for(int i=0;i<veT;i++){
             if(base[i]!=null){
             retu=retu+"<tr><th>"+base[i].codigo+"</th><th>"+base[i].cli.nombre+"</th><th>"+base[i].emp.nombre+"</th><th>"+base[i].valor+"</th></tr>";
         }}
     return retu;
         
     }  
          
 } 
     

