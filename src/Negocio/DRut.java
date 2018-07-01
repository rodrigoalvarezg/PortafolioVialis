/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author detha
 */

public class DRut {
    
    public String Rut(String rut) 
    { 
        
        int cantidad = rut.length(); 
        int factor = 2; 
        int suma = 0; 
        String verificador = ""; 

        for(int i = cantidad; i > 0; i--) 
        { 
            if(factor > 7) 
            { 
                factor = 2; 
            } 
            suma += (Integer.parseInt(rut.substring((i-1), i)))*factor; 
            factor++; 

        } 
        verificador = String.valueOf(11 - suma%11); 
        
        if((verificador.equals("10"))) 
            { 
                verificador = "k"; 
            } 
            else 
            { 
                if((verificador.equals("11"))) 
                { 
                    verificador = "0"; 
                } 

            } 
        rut = rut+"-"+verificador;
        
        System.out.println(rut);
        
        return rut;         
    }  
}
