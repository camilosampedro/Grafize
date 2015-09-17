/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mxgraph.model.mxCell;

/**
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class Vertice {

    private String nombre;

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private mxCell verticeGrafo;

    /**
     * Get the value of verticeGrafo
     *
     * @return the value of verticeGrafo
     */
    public mxCell getVerticeGrafo() {
        return verticeGrafo;
    }

    /**
     * Set the value of verticeGrafo
     *
     * @param verticeGrafo new value of verticeGrafo
     */
    public void setVerticeGrafo(mxCell verticeGrafo) {
        this.verticeGrafo = verticeGrafo;
    }

}
