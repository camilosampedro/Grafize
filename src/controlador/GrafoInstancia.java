/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mxgraph.model.mxCell;
import static controlador.Grafo.FLECHA_PARCIAL;
import static controlador.Grafo.FLECHA_TOTAL;
import exception.NoEncontrado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Nodo;

/**
 *
 * @author CamiloAndrés
 */
public class GrafoInstancia extends Grafo {

    public GrafoInstancia() {
        super();
        this.nodosSueltos = new ArrayList<>();
        this.setHtmlLabels(true);
    }

    /**
     * Agregar nodo al grafo.
     *
     * @param texto Texto que irá en el nodo del grafo.
     * @param tipo Estilo según del nodo del grafo.
     * @param x Posición en el eje x del nodo.
     * @param y Posición en el eje y del nodo.
     */
    @Override
    public void agregarNodo(String texto, String tipo, int x, int y) {
        if ("".equals(texto.replaceAll("\\s", ""))) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre para el nuevo nodo", "Nombre vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (existe(texto)) {
            JOptionPane.showMessageDialog(null, "El nodo ya existe, por favor ingrese un nombre único", "Ya existe", JOptionPane.ERROR_MESSAGE);
            return;
        }
        getModel().beginUpdate();
        Object parent = getDefaultParent();
        Object v1 = insertVertex(parent, texto, texto,
                x, y, 100, 60, tipo);
        getModel().endUpdate();
        nodosSueltos.add(new Nodo(v1));
    }

    /**
     * Enlaza dos nodos de forma gráfica agregando un grado de inclusión.
     *
     * @param nombrePadre Nombre del nodo padre.
     * @param nombreHijo Nombre del nodo hijo.
     * @param inclusion Grado de inclusión.
     * @throws NoEncontrado No se encontró uno de los dos nodos.
     */
    @Override
    public void enlazarNodos(String nombrePadre, String nombreHijo, double inclusion) throws NoEncontrado {
        Nodo padre = buscarNodo(nombrePadre);
        Nodo hijo = buscarNodo(nombreHijo);
        getModel().beginUpdate();
        Object parent = getDefaultParent();
        //mxCell lado = new mxCell(inclusion);
        Object e1;
        if (inclusion == 1) {
            e1 = insertEdge(parent, null, inclusion, padre.getInformacion(), hijo.getInformacion(), FLECHA_TOTAL);
        } else {
            e1 = insertEdge(parent, null, inclusion, padre.getInformacion(), hijo.getInformacion(), FLECHA_PARCIAL);
        }
        padre.agregarHijo(hijo, inclusion);
        lados.add((mxCell) e1);
        getModel().endUpdate();
    }
}
