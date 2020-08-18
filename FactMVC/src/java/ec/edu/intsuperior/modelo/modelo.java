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
public class modelo {
    
    public String nombre;
    public int cantidad;
    public double pecio;
    public double Totalpagar;

    public modelo(String nombre, int cantidad, double pecio, double Totapagarl) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.pecio = pecio;
        this.Totalpagar = Totalpagar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPecio() {
        return pecio;
    }

    public void setPecio(double pecio) {
        this.pecio = pecio;
    }

    public double getTotalpaga() {
        return Totalpagar;
    }

    public void setTotalpaga(double Total) {
        this.Totalpagar = Total;
    }
    
    
}
