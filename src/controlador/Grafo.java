/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import exception.NoEncontrado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Arbol;
import modelo.Categoria;
import modelo.Nodo;
import modelo.TipoCategoria;
import modelo.TipoDeDimension;

/**
 *
 * @author Camilo Sampedro
 */
public class Grafo extends mxGraph implements Serializable {

    /**
     * Identificador del "style" para obtener el diseño de los nodos dimensión.
     */
    public static final String DIMENSION = "DIMENSION";
    /**
     * Identificador del "style" para obtener el diseño de los nodos hecho.
     */
    public static final String HECHO = "HECHO";

    /**
     * Variable utilizada para evitar problemas en la serialización de la clase.
     */
    public static final long serialVersionUID = 781L;

    private final List<Nodo> nodosSueltos;

    /**
     * Constructor vacío para la clase actual. Sólo inicializa el hash.
     */
    public Grafo() {
        this.setAutoSizeCells(true);
        this.cellsDisconnectable = false;
        this.allowLoops = false;
        //this.setAutoOrigin(true);
        //this.setHtmlLabels(true);
        this.nodosSueltos = new ArrayList();
        inicializarEstilo();
    }

    /**
     * Elimina todos los nodos que se encuentren seleccionados.
     */
    public void eliminarNodosSeleccionados() {
        for (Object celda : getSelectionCells()) {
            getModel().remove(celda);
            eliminar(((mxCell) celda).getValue());
        }
    }

    /**
     * Agregar nodo al grafo.
     *
     * @param texto Texto que irá en el nodo del grafo.
     * @param tipo Estilo según del nodo del grafo.
     * @param x Posición en el eje x del nodo.
     * @param y Posición en el eje y del nodo.
     */
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

    public void enlazarNodos(String nombreNodo1, String nombreNodo2, double inclusion) throws NoEncontrado {
        Nodo padre = buscarNodo(nombreNodo1);
        Nodo hijo = buscarNodo(nombreNodo2);
        getModel().beginUpdate();
        Object parent = getDefaultParent();
        mxCell lado = new mxCell(inclusion);

        Object e1 = insertEdge(parent, null, inclusion, padre.getInformacion(), hijo.getInformacion(), FLECHA);

        getModel().endUpdate();
    }

    public Nodo buscarNodo(String nombre) throws NoEncontrado {
        Nodo nodoEncontrado = null;
        for (Nodo nodoBusqueda : nodosSueltos) {
            if (((mxCell) nodoBusqueda.getInformacion()).getValue().equals(nombre)) {
                nodoEncontrado = nodoBusqueda;
            }
        }
        return nodoEncontrado;
    }

    public String generarHTML(String titulo, String texto) {
        return " <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">"
                //                + "  <TITLE>A study of population dynamics</TITLE>"
                + "  <BODY>"
                + "   <h1>" + titulo + "</h1>\n"
                + "   <p>" + texto + "</p>"
                + "  </BODY>";
    }

    private boolean existe(String texto) {
        return nodosSueltos.stream().anyMatch((nodo) -> (((mxCell) nodo.getInformacion()).getValue().equals(texto)));
    }

    private void eliminar(Object texto) {
        for (int i = 0; i < nodosSueltos.size(); i++) {
            Nodo nodo = nodosSueltos.get(i);
            if (((mxCell) nodo.getInformacion()).getValue().equals(texto)) {
                nodosSueltos.remove(i);
            }
        }
    }

    @Override
    public boolean isCellConnectable(Object cell) {
        return false;
    }

    /**
     * Inicializa los estilos para los nuevos nodos ingresados al grafo. (Forma,
     * colores, editabilidad, espaciado, ...). El estilo se guardará como
     * ESTILO_NODO
     */
    private void inicializarEstilo() {
        // Crear un nuevo objeto de estilos
        mxStylesheet hojaDeEstilos = getStylesheet();
        // Hash para los estilos, de la forma ("Propiedad"->Valor)
        // Las propiedades se encuentran en mxConstants.STYLE_*
        HashMap<String, Object> hashEstiloDimension = new HashMap<>();
        HashMap<String, Object> hashEstiloHecho;
        // Forma del nodo
        hashEstiloDimension.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        // El nuevo nodo no será editable 
        // (No se podrá modificar el texto por la interfaz)
//        hashEstiloDimension.put(mxConstants.STYLE_EDITABLE, 0);
        // Tamaño de la fuente
        hashEstiloDimension.put(mxConstants.STYLE_FONTSIZE, 14);
        hashEstiloDimension.put(mxConstants.STYLE_GLASS, 1);
        // Quebrar la línea al no caber en el vértice
        hashEstiloDimension.put(mxConstants.STYLE_WHITE_SPACE, "wrap");
        // Estilo hechos igual al de dimensión, peo con diferentes coloresF
        hashEstiloHecho = new HashMap<>(hashEstiloDimension);
        // Color de relleno del nodo.
        hashEstiloDimension.put(mxConstants.STYLE_FILLCOLOR, "#E0ECF8");
        hashEstiloHecho.put(mxConstants.STYLE_FILLCOLOR, "#F8E0E0");
        // Color de la línea de contorno
        hashEstiloDimension.put(mxConstants.STYLE_STROKECOLOR, "#0B3861");
        hashEstiloHecho.put(mxConstants.STYLE_STROKECOLOR, "#3B0B0B");
        // Color de la fuente
        hashEstiloDimension.put(mxConstants.STYLE_FONTCOLOR, "#084B8A");
        hashEstiloHecho.put(mxConstants.STYLE_FONTCOLOR, "#B40404");

        HashMap<String, Object> hashEstiloFlecha = new HashMap<>();
        hashEstiloFlecha.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "white");

        hojaDeEstilos.putCellStyle(DIMENSION, hashEstiloDimension);
        hojaDeEstilos.putCellStyle(HECHO, hashEstiloHecho);
        hojaDeEstilos.putCellStyle(FLECHA, hashEstiloFlecha);
    }
    public static final String FLECHA = "FLECHA";

    public TipoDeDimension construirArbol() {
        List<Object> raicesCrudas = findTreeRoots(getDefaultParent());
        if (raicesCrudas.size() > 1 || raicesCrudas.isEmpty()) {
            return null;
        }
        mxCell raiz = (mxCell) raicesCrudas.get(0);
        TipoDeDimension tipoDeDimension = new TipoDeDimension(new TipoCategoria((String) raiz.getValue()));
        return tipoDeDimension;
    }

    public void crearRaiz(String nombre, int x, int y) throws NoEncontrado {
        List<Object> raicesCrudas = findTreeRoots(getDefaultParent());
        agregarNodo(nombre, DIMENSION, x, y);
        for (Object raizCruda : raicesCrudas) {
            mxCell raiz = (mxCell) raizCruda;
            enlazarNodos(nombre, (String) raiz.getValue(), 1);
        }
    }
}
