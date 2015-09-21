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

    public void InsertarCategoria(String NombreCategoria) {
        vector.add(new TipoCategoria(NombreCategoria));

    }
    public void InsertarNodo(String categoriaPadre,String nombrePadre,String categoriaHijo,String NombreHijo){
        
    }

    public NodoInstancia BuscarNodo(String Categoria, String NombreNodo) {
        //primero se busca la categoria
        TipoCategoria tc=BuscarCategoria(Categoria);
        //luego se busca al nodo dentro de esa categoria.
        if(tc!=null){
            for(NodoInstancia aux:tc.getInstancias()){
                if(aux.getNombre().equals(NombreNodo)){
                    return aux;
                }
            }
        }
        return null;
        

    }

    public TipoCategoria BuscarCategoria(String Categoria) {
        for(TipoCategoria aux:vector){
            if(aux.getNombreCategoria().equals(Categoria)){
                return aux;
            }
        }
        return null;
        
    }
}
