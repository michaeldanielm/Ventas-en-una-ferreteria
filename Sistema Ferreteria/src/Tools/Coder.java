/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author MichaelDaniel Murillo Lopez  
 * Corporación Universitaria Minuto de Dios - UNIMINUTO 
 */
public class Coder {
    public String codigo(int cont){
            String code="0000";
            code = code.substring(0,code.length()-String.valueOf(cont).length())+cont;
            
    return code;
    }
    
    
}
