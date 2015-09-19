package modelo;

import exception.NoEncontrado;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Camilo Sampedro
 * @param <T> Tipo de datos que se almacenarán en cada nodo del árbol.
 */
public class Arbol<T> {

    /**
     * Raiz del arbol.
     */
    private Nodo<T> raiz;

    /**
     * Inicializa un árbol con un único nodo.
     *
     * @param datoRaiz Información que irá en el nodo raíz.
     */
    public Arbol(T datoRaiz) {
        raiz = new Nodo<>(datoRaiz);
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
    public Boolean existe(Object dato) {
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
        if (dato.equals(nodo)) {
            return true;
        }
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

    /**
     * Agrega un nuevo nodo al árbol.
     *
     * @param padre Dato padre del nodo a agregar.
     * @param dato Dato a insertar en el nuevo nodo.
     * @param inclusion Grado de inclusión del padre hacia el hijo.
     * @throws NoEncontrado El nodo padre no ha sido encontrado.
     */
    public void agregarNodo(T padre, T dato, double inclusion) throws NoEncontrado {
        Nodo<T> nodoPadre;
        if (padre == null) {
            nodoPadre = raiz;
        } else {
            nodoPadre = obtenerNodo(padre);
        }
        Nodo<T> nodoNuevo = new Nodo(dato);
        nodoPadre.agregarHijo(nodoNuevo, inclusion);
    }

    /**
     * Obtiene el nodo con el dato igual a dato.
     *
     * @param dato Dato a buscar.
     * @return Nodo encontrado.
     * @throws NoEncontrado El nodo no ha sido encontraod.
     */
    public Nodo<T> obtenerNodo(Object dato) throws NoEncontrado {
        if (!existe(dato)) {
            throw new NoEncontrado(dato);
        }
        return obtenerNodoRecursivo(raiz, dato);
    }

    /**
     * Busca recursivamente el nodo dato en el árbol.
     *
     * @param actual Nodo que actualmente se está recorriendo.
     * @param dato Nodo con el dato que se está buscando.
     * @return Nodo encontrado o null en caso contrario.
     */
    protected Nodo<T> obtenerNodoRecursivo(Nodo actual, Object dato) {
        if (actual.getInformacion().equals(dato)) {
            return actual;
        }
        for (Iterator it = actual.hijos.iterator(); it.hasNext();) {
            Nodo<T> hijo = (Nodo<T>) it.next();
            if (hijo.equals(dato)) {
                return hijo;
            }
            if (!hijo.esHoja()) {
                Nodo busqueda = obtenerNodoRecursivo(hijo, dato);
                if (busqueda != null) {
                    return busqueda;
                }
            }
        }
        return null;
    }

    /**
     * Obtiene todas las hojas
     *
     * @return No implementado!
     */
    public List<Nodo<T>> getHojas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param dato
     * @throws exception.NoEncontrado
     */
    public void eliminar(T dato) throws NoEncontrado {
        throw new UnsupportedOperationException();
    }
}
