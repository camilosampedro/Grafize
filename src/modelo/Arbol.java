/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import exception.NoEncontrado;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilo
 * @param <T> Tipo de datos que se almacenarán en cada nodo del árbol
 */
public class Arbol<T> {

    private Nodo<T> raiz;

    /**
     * Inicializa un árbol con un único nodo.
     *
     * @param rootData Información que irá en el nodo raíz.
     */
    public Arbol(T rootData) {
        raiz = new Nodo<>(rootData);
    }

    /**
     * Obtener la raíz del árbol actual.
     *
     * @return Nodo raíz del árbol.
     */
    public Nodo<T> getRaiz() {
        return raiz;
    }

    /**
     * Reemplaza la raíz del árbol.
     *
     * @param raiz Raíz del árbol nueva.
     */
    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Verifica si existe un nodo con la información en el árbol.
     *
     * @param dato Información que se buscará en el árbol.
     * @return true si existe al menos un nodo con el dato en el árbol, false en
     * caso contrario.
     */
    public Boolean existe(T dato) {
        return existeRecursivo(raiz, new Nodo(dato));
    }

    /**
     * Método para iterar recursivamente por todos los hijos de los nodos
     * buscando si alguno de ellos tiene el dato.
     *
     * @param nodo Nodo en el cual se está buscando actualmente.
     * @param dato Nodo con el dato que se utilizará para comparar en la
     * búsqueda.
     * @return true si alguno de los nodos contiene el dato buscado, false en
     * caso contrario.
     */
    private Boolean existeRecursivo(Nodo nodo, Nodo<T> dato) {
        for (Iterator it = nodo.hijos.iterator(); it.hasNext();) {
            Nodo<T> hijo = (Nodo<T>) it.next();
            if (hijo == dato) {
                return true;
            }
            if (!hijo.esHoja() && existeRecursivo(hijo, dato)) {
                return true;
            }
        }
        return false;
    }

    public void agregarNodo(T padre, T dato) {
        try {
            Nodo<T> nodoNuevo = new Nodo(dato);
            Nodo<T> nodoPadre = obtenerNodo(padre);
            nodoPadre.agregarHijo(nodoNuevo);
        } catch (NoEncontrado ex) {
            Logger.getLogger(Arbol.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    public Nodo<T> obtenerNodo(T dato) throws NoEncontrado {
        if (!existe(dato)) {
            throw new NoEncontrado(dato);
        }
        return buscar(raiz, new Nodo<>(dato));
    }

    protected Nodo<T> buscar(Nodo actual, Nodo<T> dato) {
        for (Iterator it = actual.hijos.iterator(); it.hasNext();) {
            Nodo<T> hijo = (Nodo<T>) it.next();
            if (hijo == dato) {
                return hijo;
            }
            if (!hijo.esHoja()) {
                Nodo busqueda = buscar(hijo, dato);
                if (busqueda != null) {
                    return busqueda;
                }
            }
        }
        return null;
    }
}
