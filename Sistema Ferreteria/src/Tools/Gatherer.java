/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import javax.swing.JOptionPane;

/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
public class Gatherer {/* clase para soportar incompatibilidad de datos*/
         protected String  t;
         protected boolean f=true;
    public int entero(String text){
         int res=0;
         int i;
         do{
             t=JOptionPane.showInputDialog(null,text);
             i=0;
             f=true;
             if(t!=null){
                 if(!t.equals("")){
                     while(i<t.length() && f==true){
                         if (t.charAt(i)<48 || t.charAt(i)>57 ){
                             JOptionPane.showMessageDialog(null,"Dato Ingresado no aceptado");
                             f=false; 
                         }
                         i++;
                     }
                     if(f==true){
                         res=Integer.parseInt(t);
                         if (res==0){JOptionPane.showMessageDialog(null,"Este campo no puede ser cero");
                             f=false;
                         }       
                     }
                 }else {JOptionPane.showMessageDialog(null,"Debe llena el campo");
                 f=false;}
             }  
         }while(f==false);   
         return res;
        }
     public float decimal(String text){
         float res=0;
         int i;
         do{
             t=JOptionPane.showInputDialog(null,text);
             i=0;
             f=true;
             if(t!=null){
                 if(!t.equals("")){
                     while(i<t.length() && f==true){
                         if ((t.charAt(i)<48 || t.charAt(i)>57) && t.charAt(i)!='.'){
                             JOptionPane.showMessageDialog(null,"Dato Ingresado no aceptado");
                             f=false; 
                         }
                         i++;
                     }
                     if(f==true){
                          res=Float.parseFloat(t);
                          if (res==0){
                              JOptionPane.showMessageDialog(null,"Este campo no puede ser cero");
                             f=false;}
                     }
                 }else {
                     JOptionPane.showMessageDialog(null,"Debe llenar el campo");
                     f=false;}
             }
         }while(f==false);
         return res;    
     }
     
     
     public String string(String text){
         do{
             f=true;
             t=JOptionPane.showInputDialog(null,text);
             if(t!=null){
                 if(t.equals("")){
                     JOptionPane.showMessageDialog(null,"Debe llenar el campo");
                     f=false;
                 }
             }
         }while(t!=null && f==false);
         return t;
     }
}
        
         

  


