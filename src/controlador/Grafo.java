/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.io.Serializable;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author camilo
 */
public class Grafo extends mxGraph implements Serializable {

    /**
     * Hash en el que se guardará ( String nombre nodo -> Object vértice nodo )
     * según se vayan insertando estos al grafo.
     */
    protected HashMap hash;

    /**
     * Identificador del "style" para obtener el diseño de los nodos dimensión.
     */
    public static final String ESTILO_DIMENSION = "EstiloDimension";
    /**
     * Identificador del "style" para obtener el diseño de los nodos hecho.
     */
    public static final String ESTILO_HECHO = "EstiloHecho";

    /**
     * Variable utilizada para evitar problemas en la serialización de la clase.
     */
    public static final long serialVersionUID = 781L;

    /**
     * Constructor vacío para la clase actual. Sólo inicializa el hash.
     */
    public Grafo() {
        hash = new HashMap();
    }

    /**
     * Elimina todos los nodos que se encuentren seleccionados.
     */
    public void eliminarNodosSeleccionados() {
        for (Object celda : getSelectionCells()) {
            getModel().remove(celda);
            hash.remove(((mxCell) celda).getValue());
        }
    }

    /**
     * Agregar nodo al grafo.
     *
     * @param texto Texto que irá en el nodo del grafo.
     * @param estilo Estilo según del nodo del grafo.
     * @param x Posición en el eje x del nodo.
     * @param y Posición en el eje y del nodo.
     */
    public void agregarNodo(String texto, String estilo, int x, int y) {
        if ("".equals(texto.replaceAll("\\s", ""))) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre para el nuevo nodo", "Nombre vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (hash.containsKey(texto)) {
//            JOptionPane.showMessageDialog(this, "El nodo \"" + texto + "\" ya existe, por favor ingrese un nombre diferente", "Nombre ya existe", JOptionPane.ERROR_MESSAGE);
            agregarNodo(texto + "_copia", estilo, x, y);
            return;
        }
        getModel().beginUpdate();
        Object parent = getDefaultParent();
        Object v1 = insertVertex(parent, null, texto,
                x, y, 100, 60, estilo);
        hash.put(texto, v1);
        getModel().endUpdate();
    }

    /**
     * Retorna la variable hash.
     *
     * @return hash.
     */
    public HashMap getHash() {
        return hash;
    }

    /**
     * Reemplaza la variable hash.
     *
     * @param hash hash nuevo.
     */
    public void setHash(HashMap hash) {
        this.hash = hash;
    }

}
