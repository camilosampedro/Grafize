/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 * Clase donde se almacenará una relación con un nodo a cierto grado de
 * inclusión.
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 * @param <T> Dato que irá en el nodo.
 */
public class Inclusion<T> {

    private Nodo<T> nodo;

    private double gradoDeInclusion;

    /**
     * Crea un nuevo objeto inclusión. Define una relación con el nodo a un
     * grado de inclusión gradoDeInclusion.
     *
     * @param nodo Nodo a asignar.
     * @param gradoDeInclusion Grado de inclusión (Porcentaje), entre 0 y 1.
     */
    public Inclusion(Nodo<T> nodo, double gradoDeInclusion) {
        this.nodo = nodo;
        this.gradoDeInclusion = gradoDeInclusion;
    }

    /**
     * Get the value of gradoDeInclusion
     *
     * @return the value of gradoDeInclusion
     */
    public double getGradoDeInclusion() {
        return gradoDeInclusion;
    }

    /**
     * Set the value of gradoDeInclusion
     *
     * @param gradoDeInclusion new value of gradoDeInclusion
     */
    public void setGradoDeInclusion(double gradoDeInclusion) {
        this.gradoDeInclusion = gradoDeInclusion;
    }

    /**
     * Get the value of nodo
     *
     * @return the value of nodo
     */
    public Nodo<T> getNodo() {
        return nodo;
    }

    /**
     * Set the value of nodo
     *
     * @param nodo new value of nodo
     */
    public void setNodo(Nodo<T> nodo) {
        this.nodo = nodo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inclusion<?> other = (Inclusion<?>) obj;
        if (!Objects.equals(this.nodo, other.nodo)) {
            return false;
        }
        return true;
    }

}
