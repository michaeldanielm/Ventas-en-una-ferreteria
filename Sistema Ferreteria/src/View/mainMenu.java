/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;
/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
import Tools.*;
import Control.*;
import Modelo.*;





public class mainMenu {
    /**
     * @param args the command line arguments
     */
    
     /*VARIBALES AQUI*/
     
     protected    Gatherer colector=new Gatherer ();
     protected    ContPro  cp=new ContPro();
     protected    ContCli cC=new ContCli();
     protected    ContEmp cE=new ContEmp();
     protected    ContVen cV=new ContVen();
           
     
     
     
     
     /*---------------------VIEWS------------------*/
     /*_____________________VIEW PARA PRODUCTOS----*/
     private void viewAddPro(){
         Producto p=new Producto();
         
         p.nombre=colector.string("Ingrese nombre del producto");
         if(p.nombre!=null){
             if(cp.searchPro(p.nombre).nombre==null){
                 p.ubicacion=colector.string("Ingrese estante de ubicacion");
                 if (p.ubicacion!=null){
                     p.valor=colector.decimal("Ingrese precio del producto");
                     if (p.valor!=0){
                         p.cantidad=(int)colector.entero("Ingrese cantidad existente del producto");
                        if (p.cantidad!=0){
                             cp.addPro(p);    
                             JOptionPane.showMessageDialog(null,"Producto creado");
                         }
                     }
                 }
             }else{
                JOptionPane.showMessageDialog(null,cp.searchPro(p.nombre).toString()+ "\n\nEste producto ya existe");
             }
         }
     }
     
     private void viewSearchPro(){
         String find;
         find=colector.string("Ingrese nombre del producto");
         if(find!=null){
             if(cp.searchPro(find).nombre!=null){
                 JOptionPane.showMessageDialog(null,cp.searchPro(find).toString());
             }else{
                 JOptionPane.showMessageDialog(null,"Producto no registrado");
             }
         }
     }
     
     private void viewList(){
         String Tabla="<html><Table border=1>";
         Tabla=Tabla+"<tr><th>Codigo</th><th>Nombre</th><th>Valor</th><th>Cantidad</th><th>ubicacion</th></tr>";
          Tabla=Tabla+cp.list();
          Tabla=Tabla+"</Table></html>";
          JOptionPane.showMessageDialog(null, Tabla);
     }     
     
     private void viewChange(){
          Producto producto=new Producto ();
         String temp,OP;
         int conf;
         temp=colector.string("Ingrese nombre del producto");
         if(temp!=null){
             producto=cp.searchPro(temp);
                 if(producto.nombre!=null){
                  conf=JOptionPane.showConfirmDialog(null,"Es lo que busca?\n\n"+producto.toString());
                     switch (conf){
                         case 0:
                             do{
                                 OP=JOptionPane.showInputDialog(null,"Que desea modificar?\n\n1. Nombre\n2. Valor\n3. Cantidad\n4. Ubicacion\n5. Guardar y salir");
                                     if(OP!=null){
                             switch(OP){
                                 case "1":
                                     temp=colector.string("Ingrese nuevo nombre");
                                         if(cp.searchPro(temp).nombre==null){
                                                producto.nombre=temp ;}
                                         else {
                                             JOptionPane.showMessageDialog(null,"Ya existe un producto con este nombre");
                                         }
                                     break;
                                 case "2":
                                     producto.valor=colector.decimal("Ingrese nuevo valor");
                                     break;
                                 case "3":
                                     producto.cantidad=producto.cantidad+(int)colector.entero("Ingrese cantidad a agragar");
                                     break; 
                                 case "4":
                                     producto.ubicacion=colector.string("Ingrese nueva ubicacion");
                                     break;
                                 case "5":
                                     int c=JOptionPane.showConfirmDialog(null,"\nDesea guardar los cambios?");
                                     switch (c) {
                                         case 0:
                                             JOptionPane.showMessageDialog(null,"Guardado");
                                             cp.Change(producto,Integer.parseInt(producto.codigo.substring(2)));
                                             OP=null;
                                             break;
                                         case 1:
                                             JOptionPane.showMessageDialog(null,"No guardado");      
                                             break;
                                         default:
                                             break;
                                     }
                                     break;
                                 default:
                                     JOptionPane.showMessageDialog(null,"Opcion no valida");                         
                                 }
                                 }
                             }while(OP!=null);             
                             break;
                      }
                 }else{
             JOptionPane.showMessageDialog(null,"Producto no registrado");
                }        
         }                
     }
     
     private void viewSupr(){
         String temp=colector.string("Nombre del articulo a eliminar");
         if(temp!=null){
             Producto p=new Producto();
             p=cp.searchPro(temp);
             if(p.nombre!=null){
                 cp.supr(Integer.parseInt(p.codigo.substring(2)));
                 JOptionPane.showMessageDialog(null,"Producto elimindado");
             }else{JOptionPane.showMessageDialog(null,"Este producto no existe");}
         }         
         }
     private void viewEscasos(){
         String Tabla="<html><Table border=1>";
         Tabla=Tabla+"<tr><th>Codigo</th><th>Nombre</th><th>Valor</th><th>Cantidad</th><th>ubicacion</th></tr>";
          Tabla=Tabla+cp.buscarEscasos();
          Tabla=Tabla+"</Table></html>";
          JOptionPane.showMessageDialog(null, Tabla);
     }
     
     
     /*_____________________VIEW PARA Clientes----*/
     
     private void viewAddCli(){
         Cliente cli=new Cliente();
         cli.cc=colector.string("Ingrese numero de cedula del cliente");
         if(cli.cc!=null){
             if(cC.searchCli(cli.cc).cc==null){
                 cli.nombre=colector.string("Ingrese nombre del cliente");
                 if (cli.nombre!=null){
                     cli.telefono=colector.string("Ingrese telefono del cliente");
                     if (cli.telefono!=null){
                         cC.addCli(cli);    
                         JOptionPane.showMessageDialog(null,"Cliente creado");
                     }
                 }                     
             }else{
                JOptionPane.showMessageDialog(null,cC.searchCli(cli.cc).toString()+ "\n\nEste cliente ya existe");
             }
         }
     }
     
     private void viewSearchCli(){
         String find;
         find=colector.string("Ingrese cedula del cliente");
         if(find!=null){
             if(cC.searchCli(find).cc!=null){
                 JOptionPane.showMessageDialog(null,cC.searchCli(find).toString());
             }else{
                 JOptionPane.showMessageDialog(null,"Cliente no registrado");
             }
         }
     }
     
     private void viewCliList(){
         String Tabla="<html><Table border=1>";
         Tabla=Tabla+"<tr><th>Codigo</th><th>Nombre</th><th>Cedula</th><th>Telefono</th></tr>";
          Tabla=Tabla+cC.listCli();
          Tabla=Tabla+"</Table></html>";
          JOptionPane.showMessageDialog(null, Tabla);
     }
     
     private void viewChangeCli(){
          Cliente cliente=new Cliente ();
         String temp,OP;
         int conf;
         
         temp=colector.string("Ingrese numero de cedula");
         if(temp!=null){
         cliente=cC.searchCli(temp);
         if(cliente.cc!=null){
             
             conf=JOptionPane.showConfirmDialog(null,"Es lo que busca?\n\n"+cliente.toString());
             do{
             switch (conf){
                 case 0:
                     cliente.telefono=colector.string("Introduca nuevo numero de telefono ");
                     if(cliente.telefono!=null){
                         int c=JOptionPane.showConfirmDialog(null,"\nDesea guardar los cambios?");
                         switch (c) {
                             case 0:
                                  JOptionPane.showMessageDialog(null,"Guardado");
                                  cC.ChangeCli(cliente.telefono,Integer.parseInt(cliente.codigo.substring(2)));
                                  cliente.telefono=null;
                                  break;
                             case 1:
                             JOptionPane.showMessageDialog(null,"No guardado");
                             cliente.telefono=null;
                                 break;
                             default:
                                 break;
                             }                            
                         break;                 
                     }
                 default:
                     cliente.telefono=null;
                     break;
             }
        
         }while(cliente.telefono!=null);  
         }else{
             JOptionPane.showMessageDialog(null,"Cliente no registrado");
         }
         }
     }
   
     
      /*----------------view para empleados-----------*/

     private void viewAddEmp(){
         Empleado emp=new Empleado();
         emp.nombre=colector.string("Ingrese nombre del empleado ");
         if(emp.nombre!=null){
             if(cE.searchEmp(emp.nombre).nombre==null){
                 emp.cc=colector.string("Ingrese numero de cedula del empleado");
                 if (emp.cc!=null){
                     emp.telefono=colector.string("Ingrese telefono del empleado");
                     if (emp.telefono!=null){
                         emp.adress=colector.string("Ingrese direccion del empleado");
                         if (emp.adress!=null){
                             cE.addEmp(emp);    
                             JOptionPane.showMessageDialog(null,"Empleado creado");
                         } 
                     }
                 }                     
             }else{
                JOptionPane.showMessageDialog(null,cE.searchEmp(emp.nombre).toString()+ "\n\nEste empleado ya existe");
             }
         }
     }
     
     private void viewSearchEmp(){
         String find;
         find=colector.string("Ingrese nombre del empleado");
         if(find!=null){
             if(cE.searchEmp(find).nombre!=null){
                 JOptionPane.showMessageDialog(null,cE.searchEmp(find).toString());
             }else{
                 JOptionPane.showMessageDialog(null,"Empleado no registrado");
             }
         }
     }
     
     private void viewEmpList(){
         String Tabla="<html><Table border=1>";
         Tabla=Tabla+"<tr><th>Codigo</th><th>Nombre</th><th>Cedula</th><th>Telefono</th><th>Direccion</th></tr>";
          Tabla=Tabla+cE.listEmp();
          Tabla=Tabla+"</Table></html>";
          JOptionPane.showMessageDialog(null, Tabla);
     }
     
     private void viewChangeEmp(){
         Empleado emp=new Empleado ();
         String temp,OP;
         int conf;
         temp=colector.string("Ingrese nombre del empleado");
         if(temp!=null){
         emp=cE.searchEmp(temp);
         if(emp.nombre!=null){
             conf=JOptionPane.showConfirmDialog(null,"Es lo que busca?\n"+emp.toString());
             switch (conf){
                 case 0:
                     do{
                         OP=JOptionPane.showInputDialog(null,"Que desea modificar?\n\n1. Telefono\n2. Direccion\n3. Guardar y salir");
                         if(OP!=null){
                             switch(OP){
                                 case "1":
                                     emp.telefono=colector.string("Ingrese nuevo telefono ");                                         
                                     break;
                                 case "2":
                                     emp.adress=colector.string("Ingrese nueva direcion");
                                     break;
                                 case "3":
                                     int c=JOptionPane.showConfirmDialog(null,"\nDesea guardar los cambios?");
                                     switch (c) {
                                         case 0:
                                             JOptionPane.showMessageDialog(null,"Guardado");
                                             cE.ChangeEmp(emp,Integer.parseInt(emp.codigo.substring(2)));
                                             OP=null;
                                             break;
                                         case 1:
                                             JOptionPane.showMessageDialog(null,"No guardado");      
                                             break;
                                             
                                         default:
                                             OP=null;
                                             break;
                                     }
                                     break;
                                 default:
                                     JOptionPane.showMessageDialog(null,"Opcion no valida");                         
                             }
                         }
                     }while(OP!=null);             
                     break;
                 }
            
          }else{
             JOptionPane.showMessageDialog(null,"Empleado no registrado");
         }        
         }                
     }     
     ///*/////////////////Menu Principal//////////////*
     public static void main(String[] args) {
         mainMenu manager=new mainMenu();
         String op="0";
         String op1="0";
         do{
             op=JOptionPane.showInputDialog(null,"      - Menu Principal -\n\n1. Gestionar Productos\n2. Gestionar Clientes\n3. Gestionar Empleados\n4. Gestionar Ventas");
                 if (op!=null){             
             switch(op){
                 case "1":
                     do{
                     op1=JOptionPane.showInputDialog(null,"      - Productos-\n\n1. Crear Producto\n2. Buscar Producto\n3. Listar\n4. Modificar\n5. Eliminar un producto\n6. Listar escasos");
                         if (op1!=null){                                          
                             switch(op1){
                                 case "1":
                                     manager.viewAddPro();
                                     break;
                                 case "2":
                                     manager.viewSearchPro();                                 
                                     break;
                                 case "3":
                                     manager.viewList();
                                    break;
                                 case "4":
                                     manager.viewChange();
                                     break;
                                 case "5":
                                     manager.viewSupr();
                                     break;     
                                 case "6":
                                     manager.viewEscasos();
                                     break;
                                 default:
                                      JOptionPane.showMessageDialog(null,"Opcion no valida");
                                      break;
                            }
                         }                    
                     }while(op1!=null);
                     break;
                 case "2":
                     op1="";
                     do{
                         op1=JOptionPane.showInputDialog(null,"     - Clientes-\n\n1. Registrar Cliente\n2. Consultar cliente\n3. Listar clientes\n4. Actualizar telefono");
                         if(op1!=null){
                             switch(op1){
                                 case "1":
                                     manager.viewAddCli();
                                     break;                
                                 case "2":
                                     manager.viewSearchCli();
                                     break;
                                 case "3":
                                     manager.viewCliList();
                                     break;
                                 case "4":
                                     manager.viewChangeCli();
                                     break;                            
                                 default:
                                     JOptionPane.showMessageDialog(null,"Opcion no valida");
                                     break;     
                             }
                         }
                     }while(op1!=null);                     
                     break;    
                 case "3":
                     op1="";
                     do{ 
                         op1=JOptionPane.showInputDialog(null,"     - Empleados-\n\n1. Registrar Empleado\n2. Consultar Empleado\n3. Listar Empleado\n4. Actualizar inf");
                         if(op1!=null){
                             switch(op1){
                                 case "1":
                                     manager.viewAddEmp();
                                     break;
                                 case "2":
                                     manager.viewSearchEmp();
                                     break;
                                 case "3":
                                     
                                     manager.viewEmpList();
                                     break;
                                 case "4":
                                     manager.viewChangeEmp();
                                     break;
                                 default:
                                     JOptionPane.showMessageDialog(null,"Opcion no valida");
                                     break;             
                             }
                         }
                     }while(op1!=null);
                     break;   
                 case "4":
                     op1="";
                     do{
                         op1=JOptionPane.showInputDialog(null,"     - Ventas-\n\n1. Vender\n2. Consultar Venta\n3. Listar Venta");
                         if(op1!=null){
                             switch(op1){
                                 case "1":
                                      manager.viewVender();
                                      break;
                                 case "2":
                                     manager.viewDetalle();
                                     break;
                                 case "3":
                                     manager.viewVenList();
                             }
                         }
                     }while(op1!=null);
                     break;
                 default:
                     JOptionPane.showMessageDialog(null,"Opcion no valida");
                     break;      
             }  
             }                 
         }while(op!=null);
         JOptionPane.showMessageDialog(null,"ByE ByE");
    }         

    private void viewVender() {
        Producto p=new Producto();
        Cliente c=new Cliente();
        Empleado e=new Empleado();
        Venta v=new Venta();
        int O=0;
         String temp;
         boolean fl=false,ex=false;
        int c3=0;
         do{
             ex=false;
              temp=colector.string("Ingrece numero de cedula del cliente");
              if(temp!=null){
                  if(cC.searchCli(temp).cc!=null){
                     O=JOptionPane.showConfirmDialog(null,"Es lo que busca\n"+cC.searchCli(temp).toString());
                     switch(O){
                         case 0:
                             v.cli=cC.searchCli(temp);
                             fl=true;
                             break;
                         case 1:
                             JOptionPane.showMessageDialog(null,"Vulva a intentar");
                             break;
                         default:
                             temp=null;
                             break;
                     }
                 }else{JOptionPane.showMessageDialog(null,"Debe crear cliente");
                     v.cli.cc=temp;
                     v.cli.nombre=colector.string("Ingrece nombre del cliente");
                     if (v.cli.nombre!=null){
                         v.cli.telefono=colector.string("Ingrece telefono del cliente");
                         if (v.cli.telefono!=null){
                             cC.addCli(v.cli);
                             JOptionPane.showMessageDialog(null,"Cliente creado");
                             fl=true;
                         }
                     }                     
                  }
              }
         }while(v.cli.cc==null  && temp!=null );
         int inten=3;
         temp=null;
         if (fl==true){
             do{
                 temp=colector.string("Ingrese nombre de empleado - "+inten+" intento(s)");
                 if(temp!=null){
                     if(cE.searchEmp(temp).nombre!=null){
                         v.emp=cE.searchEmp(temp);
                           
                     }else{JOptionPane.showMessageDialog(null,"Empleado no registrado");
                         inten--;
                         if(inten==0){
                             JOptionPane.showMessageDialog(null,"Operacion cancelada");             
                         }
                     }
             
                 }            
             }while(v.emp.nombre==null && inten>0 && temp!=null);
             ex=false;
             int P=0;
             if(v.emp.nombre!=null && inten>0 ){             
                 do{
                     int ca;
                     temp=colector.string("Ingrece nombre del producto para añadir al carrito\n\nCancel para terminar");
                     if(temp!=null){
                         if(cp.searchPro(temp).nombre!=null){
                             p=cp.searchPro(temp);
                             do{
                                 ca=(int)colector.entero("Cantida?");  
                                 if(ca>0){
                                     if(p.cantidad>=ca){
                                         if(cV.sarchCar(temp).nombre!=null){          
                                         cV.llenarCarrito(p, ca,cV.sarchCar(temp).pos);
                                         ex=true;
                                         }else{cV.llenarCarrito(p, ca,P);
                                         ex=true;
                                         P++;                         
                                         }
                                     }else{
                                         JOptionPane.showMessageDialog(null,"Solo tenemos "+p.cantidad+" de "+p.nombre);
                                         ex=false;
                                     }
                                 }                                                 
                             }while(p.cantidad<ca && ca>0);                  
                         }else {JOptionPane.showMessageDialog(null,"Producto no existe");}               
                     }             
                 }while(temp!=null);
                 if(ex==true){   
                     v=cV.vender(v);
                     int x=0;
                     while(v.c[x]!=null){
                         cp.base[v.c[x].ad].cantidad=cp.base[v.c[x].ad].cantidad-v.c[x].cantidad;
                         x++;
                     }
                 String Tabla="<html><Table border=1>";
                 Tabla=Tabla+cV.detalleVen(v.codigo);
                 Tabla=Tabla+"</Table></html>";
                 JOptionPane.showMessageDialog(null, Tabla,"Su Factura",1);
                 } 
            }             
         }               
    }

     Producto p=new Producto();
              
     private void viewDetalle() {
         Venta v =new Venta();
         String temp=colector.string("Ingrese codigo de venta");
         if(temp!=null){
             if(!cV.detalleVen(temp).equals("")){
                 String Tabla="<html><Table border=1>";
                 Tabla=Tabla+cV.detalleVen(temp);
                 Tabla=Tabla+"</Table></html>";
                 JOptionPane.showMessageDialog(null, Tabla);
           }else{JOptionPane.showMessageDialog(null,"Venta no registrada");   
             }
         }
    }
    private void viewVenList() {

         String Tabla="<html><Table border=1>";
         Tabla=Tabla+"<tr><th>Codigo</th><th>Cliente</th><th>Vendeor</th><th>Valor</th></tr>";
          Tabla=Tabla+cV.listVen();
          Tabla=Tabla+"</Table></html>";
          JOptionPane.showMessageDialog(null, Tabla);
    }

}



