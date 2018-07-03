/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rodrigo
 */
public class ComboTrabajador {
    private String rut;
    private String nombre;

    public ComboTrabajador(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public ComboTrabajador() {
    }
    
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }   
}
