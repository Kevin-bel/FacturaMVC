/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo;

/**
 *
 * @author Usuario
 */
public class producto {
    
    //El metodo para calcualr el precio y el producto
    public double total(double cantidad, double precio){
            
         return cantidad*precio;   
    }
    public double iva(double subtotal){
            
         return (subtotal*0.12)/100;
    }
    public double totalpagar(double subtotal, double iva){
            
         return (subtotal+iva);
    }
}
