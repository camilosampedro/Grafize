/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import gui.VentanaEsquema;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author camilo
 */
public class Grafo extends mxGraph {

    /**
     * Hash en el que se guardará ( String nombre nodo -> Object vértice nodo )
     * según se vayan insertando estos al grafo.
     */
    protected HashMap hash;

    /**
     * Ventana que controlará este grafo.
     */
    protected VentanaEsquema padre;

    public Grafo() {
        hash = new HashMap();
    }

    public void eliminarNodosSeleccionados() {
        for (Object celda : getSelectionCells()) {
            getModel().remove(celda);
            hash.remove(((mxCell) celda).getValue());
        }
    }

    /**
     * Agregar nodo al grafo. Este método sólo invoca al método agregarNodo con
     * x e y generados aleatoriamente.
     *
     * @param texto Texto que irá en el nodo del grafo.
     * @param estilo Estilo según del nodo del grafo.
     */
    public void agregarNodo(String texto, String estilo) {
        agregarNodo(texto, estilo, randX(), randY());
    }

    public void agregarNodo(String estilo, int x, int y) {
        String nombre = JOptionPane.showInputDialog(padre, "Por favor ingrese el nombre", "Ingresar nombre", JOptionPane.QUESTION_MESSAGE);
        agregarNodo(nombre, estilo, x, y);
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
            JOptionPane.showMessageDialog(padre, "Por favor ingrese un nombre para el nuevo nodo", "Nombre vacío", JOptionPane.ERROR_MESSAGE);
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
        padre.getTFIngresadorNombre().setText("");
    }

    /**
     * Obtiene un valor aleatorio para insertar en X un nodo.
     *
     * @return Número aleatorio entre 0 y ancho - 150
     */
    public int randX() {
        return (int) (Math.random() * (padre.getPanelGrafo().getSize().width - 150));
    }

    public int randY() {
        return (int) (Math.random() * (padre.getPanelGrafo().getSize().height - 150));
    }

    public HashMap getHash() {
        return hash;
    }

    public void setHash(HashMap hash) {
        this.hash = hash;
    }

    public VentanaEsquema getPadre() {
        return padre;
    }

    public void setPadre(VentanaEsquema padre) {
        this.padre = padre;
    }

}
