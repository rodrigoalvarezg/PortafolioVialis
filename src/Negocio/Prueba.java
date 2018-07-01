/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import java.util.Scanner;

/**
 *
 * @author detha
 */
public class Prueba {
    
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);
        String rut = "";
        System.out.println("Ingrese un rut: ");
        rut = entrada.nextLine();
        
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
        
    }
    
}
