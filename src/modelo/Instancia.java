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

    public void InsertarNodo(String categoriaHijo, String NombreHijo, int GradoInclusion) {
        NodoInstancia hijo = new NodoInstancia(NombreHijo);
        hijo.setGradoInclusion(GradoInclusion);
        TipoCategoria CatHijo = BuscarCategoria(categoriaHijo);
        if (CatHijo != null) {
            CatHijo.InsertarNodo(hijo);
        }

    }

    public void InsertarPadre(String categoriaHijo, String nombreHijo, String categoriaPadre, String nombrePadre) {
        NodoInstancia hijo = BuscarNodo(categoriaHijo, nombreHijo);
        NodoInstancia padre = BuscarNodo(categoriaPadre, nombrePadre);
        hijo.setPadre(padre);
        padre.getHijos().add(hijo);

    }

    public NodoInstancia BuscarNodo(String Categoria, String NombreNodo) {
        //primero se busca la categoria
        TipoCategoria tc = BuscarCategoria(Categoria);
        //luego se busca al nodo dentro de esa categoria.
        if (tc != null) {
            for (NodoInstancia aux : tc.getInstancias()) {
                if (aux.getNombre().equals(NombreNodo)) {
                    return aux;
                }
            }
        }
        return null;

    }

    public TipoCategoria BuscarCategoria(String Categoria) {
        for (TipoCategoria aux : vector) {
            if (aux.getNombreCategoria().equals(Categoria)) {
                return aux;
            }
        }
        return null;

    }
}
