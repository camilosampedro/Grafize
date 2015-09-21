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
public class Instancia {
    //vector que contiene todos los tipos de categorias, es importante que las categorias se inserten de mayor a menor
    private ArrayList<TipoCategoria> vector;

    public Instancia() {
        this.vector = new ArrayList<>();
    }
    public void InsertarCategoria(String NombreCategoria){
        vector.add(new TipoCategoria(NombreCategoria));
        
        
    }
    
}
