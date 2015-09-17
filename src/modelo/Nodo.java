/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author camilo
 * @param <T> Tipo de informacion almacenada en el nodo
 */
public class Nodo<T> {

    /**
     * Información que almacenará el nodo.
     */
    protected T informacion;

    /**
     * Padre del nodo dentro del árbol.
     *
     */
    protected Nodo<T> padre;

    /**
     * Hijos del nodo. Otros nodos que estarán un nivel más arriba del nodo.
     */
    protected List<Inclusion<T>> hijos;

    /**
     * Constructor para nodos vacíos. Inicializa la lista de hijos vacía y padre
     * e información serán nulos.
     */
    public Nodo() {
        this.informacion = null;
        //this.padre = null;
        this.hijos = new ArrayList<>();
    }

    /**
     * Constructor para nodos con sólo el dato. Inicializa la lista de hijos
     * vacía y el padre será nulo.
     *
     * @param dato Información que se almacenará en en nodo.
     */
    public Nodo(T dato) {
        this.informacion = dato;
        this.hijos = new ArrayList<>();
    }

    /**
     * Constructor que crea un nodo asignándole directamente el padre.
     *
     * @param padre Padre del nodo a crear.
     * @param dato Información que tendrá el nuevo nodo.
     */
    public Nodo(Nodo padre, T dato) {
        this.padre = padre;
        this.informacion = dato;
        this.hijos = new ArrayList<>();
    }

    /**
     * Retorna si el nodo actual es una hoja del árbol.
     *
     * @return true si el nodo no tiene hijos, false si tiene al menos un hijo.
     */
    public Boolean esHoja() {
        return hijos == null || hijos.isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.getInformacion());
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
        final Nodo<?> other = (Nodo<?>) obj;
        return Objects.equals(this.getInformacion(), other.getInformacion());
    }

    /**
     * Información que almacenará el nodo.
     *
     * @return the informacion
     */
    public T getInformacion() {
        return informacion;
    }

    /**
     * Información que almacenará el nodo.
     *
     * @param informacion the informacion to set
     */
    public void setInformacion(T informacion) {
        this.informacion = informacion;
    }

    /**
     * Padre del nodo dentro del árbol.
     *
     * @return the padre
     */
    public Nodo<T> getPadre() {
        return padre;
    }

    /**
     * Padre del nodo dentro del árbol.
     *
     * @param padre the padre to set
     */
    public void setPadre(Nodo<T> padre) {
        this.padre = padre;
    }

    /**
     * Agrega un nuevo nodo a la lista de hijos.
     *
     * @param hijo Hijo nuevo a agregar
     */
    public void agregarHijo(Nodo<T> hijo, double inclusion) {
        this.hijos.add(new Inclusion<>(hijo, inclusion));
    }
}
