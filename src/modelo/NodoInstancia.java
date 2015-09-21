/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class NodoInstancia {
    //Nombre de la instancia ejempllo medellin, octubre, antioquia
    private String Nombre;
    private NodoInstancia Padre;
    private ArrayList<NodoInstancia> Hijos;
    //nombre de la categoria ejm ciudad, mes, departamento
    private String NombreCategoria;

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public NodoInstancia(String n) {
        this.Nombre = n;
        this.Padre = null;
        this.Hijos = new ArrayList<>();
        this.NombreCategoria = "";
    }

    public NodoInstancia() {
        this.Nombre = "";
        this.Padre = null;
        this.Hijos = new ArrayList<>();
        this.NombreCategoria = "";
    }
    

    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public NodoInstancia getPadre() {
        return Padre;
    }

    public void setPadre(NodoInstancia Padre) {
        this.Padre = Padre;
    }

    public ArrayList<NodoInstancia> getHijos() {
        return Hijos;
    }

    public void setHijos(ArrayList<NodoInstancia> Hijos) {
        this.Hijos = Hijos;
    }
    
    
}
