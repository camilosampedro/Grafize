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

    
    public void InsertarNodo(String categoriaHijo,String NombreHijo){
        NodoInstancia hijo=new NodoInstancia(NombreHijo);
        
        TipoCategoria CatHijo=BuscarCategoria(categoriaHijo);
        if(CatHijo!=null){
            CatHijo.InsertarNodo(hijo);
        }

    }

    public void InsertarPadre(String categoriaHijo, String nombreHijo, String categoriaPadre, String nombrePadre,double gradoInclu) {
        NodoInstancia hijo = BuscarNodo(categoriaHijo, nombreHijo);
        NodoInstancia padre = BuscarNodo(categoriaPadre, nombrePadre);
        hijo.setPadre(padre);
        padre.getHijos().add(new Inclusion1(hijo,gradoInclu));

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
    public void MakeOnto(){
        
        int numCategorias=vector.size();
        int contHijosArtificiales = 0;
        for(TipoCategoria indiceCat: vector){
            int indice =vector.indexOf(indiceCat);
            for(NodoInstancia indiceNod: indiceCat.getInstancias()){
                if((!indiceNod.getHijos().isEmpty()&& indice<numCategorias-1)){
                    String Nombre=vector.get(indice+1).getNombreCategoria() +"_OntoArt_"+contHijosArtificiales;
                    NodoInstancia hijoArtificial = new NodoInstancia(Nombre);
                    vector.get(indice+1).InsertarNodo(hijoArtificial);
                    indiceNod.getHijos().add(new Inclusion1(hijoArtificial,1));
                    hijoArtificial.setPadre(indiceNod);
                    contHijosArtificiales++;
                }
                
            }
            
            
        }
    }
    public void MakeCovering(){
        
        int contNodosArtificiales=0;        
        
        for(TipoCategoria Actual: vector){
            int indiceActual=vector.indexOf(Actual);
            for(NodoInstancia nodoAct: Actual.getInstancias()){
                if(!nodoAct.getHijos().isEmpty()){
                    for(Inclusion1 hijo: nodoAct.getHijos()){
                        int indiceHijo=vector.indexOf(BuscarCategoria(hijo.getNodo().getNombreCategoria()));
                        if((indiceHijo-indiceActual)>1){
                            NodoInstancia intermedio= new NodoInstancia(vector.get(indiceActual+1).getNombreCategoria()+"_Cov_"+contNodosArtificiales);
                            vector.get(indiceActual+1).InsertarNodo(intermedio);
                            nodoAct.getHijos().remove(hijo);
                            nodoAct.getHijos().add(new Inclusion1(intermedio,1));
                            intermedio.setPadre(nodoAct);
                            intermedio.getHijos().add(hijo);
                            hijo.getNodo().setPadre(intermedio);
                            contNodosArtificiales++;
                        
                        }
                    }
                }
            }
            
            
        }
        
    }
}
