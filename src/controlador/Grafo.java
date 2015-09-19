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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    public static final String CATEGORIA = "CATEGORIA";
    /**
     * Identificador del "style" para obtener el diseño de los nodos hecho.
     */
    public static final String HECHO = "HECHO";
    /**
     * Identificador del "style" para obtener el diseño de las flechas no
     * punteadas.
     */
    public static final String FLECHA_TOTAL = "FLECHAPARCIAL";
    /**
     * Identificador del "style" para obtener el diseño de las flechas
     * discontinuas.
     */
    public static final String FLECHA_PARCIAL = "FLECHATOTAL";

    /**
     * Variable utilizada para evitar problemas en la serialización de la clase.
     */
    public static final long serialVersionUID = 781L;

    private final ArrayList<Nodo<mxCell>> nodosSueltos;
    private final ArrayList<mxCell> lados;

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
        this.lados = new ArrayList<>();
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

    /**
     * Enlaza dos nodos de forma gráfica agregando un grado de inclusión.
     *
     * @param nombrePadre Nombre del nodo padre.
     * @param nombreHijo Nombre del nodo hijo.
     * @param inclusion Grado de inclusión.
     * @throws NoEncontrado No se encontró uno de los dos nodos.
     */
    public void enlazarNodos(String nombrePadre, String nombreHijo, double inclusion) throws NoEncontrado {
        Nodo padre = buscarNodo(nombrePadre);
        Nodo hijo = buscarNodo(nombreHijo);
        getModel().beginUpdate();
        Object parent = getDefaultParent();
        //mxCell lado = new mxCell(inclusion);
        Object e1;
        if (inclusion == 1) {
            e1 = insertEdge(parent, null, "", padre.getInformacion(), hijo.getInformacion(), FLECHA_TOTAL);
        } else {
            e1 = insertEdge(parent, null, "", padre.getInformacion(), hijo.getInformacion(), FLECHA_PARCIAL);
        }
        lados.add((mxCell) e1);
        getModel().endUpdate();
    }

    /**
     * Busca el nodo con el String solicitado.
     *
     * @param stringABuscar String que se buscará en el grafo.
     * @return Nodo encontraod.
     * @throws NoEncontrado Lanzada cuando no hay nodos con el string.
     */
    public Nodo buscarNodo(String stringABuscar) throws NoEncontrado {
        Nodo nodoEncontrado = null;
        for (Nodo nodoBusqueda : nodosSueltos) {
            if (((mxCell) nodoBusqueda.getInformacion()).getValue().equals(stringABuscar)) {
                nodoEncontrado = nodoBusqueda;
            }
        }
        return nodoEncontrado;
    }

    /**
     * Genera un HTML mínimo con un título y texto. Título lo encierra entre h1
     * y texto lo encierra entre p.
     *
     * @param titulo Título del HTML
     * @param texto Texto en el HTML
     * @return String generado con formato HTML
     */
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

    @Override
    public boolean isCellEditable(Object cell) {
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

        HashMap<String, Object> hashEstiloFlechaTotal = new HashMap<>();

        hashEstiloFlechaTotal.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "white");

        HashMap<String, Object> hashEstiloFlechaParcial = new HashMap<>(hashEstiloFlechaTotal);

        hashEstiloFlechaParcial.put(mxConstants.STYLE_DASHED, true);

        hojaDeEstilos.putCellStyle(CATEGORIA, hashEstiloDimension);
        hojaDeEstilos.putCellStyle(HECHO, hashEstiloHecho);
        hojaDeEstilos.putCellStyle(FLECHA_TOTAL, hashEstiloFlechaTotal);
        hojaDeEstilos.putCellStyle(FLECHA_PARCIAL, hashEstiloFlechaParcial);
    }

    /**
     * Construye un árbol desde el grafo actual. Se cerciora de que únicamente
     * hay una raíz y construye recursivamente vértice a vértice cada uno de los
     * nodos.
     *
     * @return Árbol construido.
     */
    public TipoDeDimension construirArbol() {
        List<mxCell> raices = obtenerRaices();
        if (raices.size() != 1) {
            return null;
        }
        mxCell raiz = (mxCell) raices.get(0);
        TipoCategoria tipoRaiz = new TipoCategoria((String) raiz.getValue());
        TipoDeDimension tipoDeDimension = new TipoDeDimension(tipoRaiz);

        try {
            construirRecursivo(tipoDeDimension, tipoRaiz, raiz);
        } catch (NoEncontrado ex) {
            Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoDeDimension;
    }

    /**
     * Crea una raíz que tendrá como hijos todos los nodos raíces actuales.
     *
     * @param nombre Nombre de la nueva raíz
     * @param x Posición en X de la nueva raíz.
     * @param y Posición en Y de la nueva raíz.
     */
    public void crearRaiz(String nombre, int x, int y) {
        List<mxCell> raicesCrudas = obtenerRaices();
        agregarNodo(nombre, CATEGORIA, x, y);
        raicesCrudas.stream().map((raizCruda) -> (mxCell) raizCruda).forEach((raiz) -> {
            try {
                enlazarNodos(nombre, (String) raiz.getValue(), 1);
            } catch (NoEncontrado ex) {
                Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * Costruye recursivamente los hijos para el nodo raíz.
     *
     * @param tipoDeDimension Árbol donde se está creando el nodo.
     * @param tipoRaiz Tipo de dato dentro de raíz.
     * @param raiz Vértice dónde se buscarán hijos.
     * @throws NoEncontrado El elemento tipoRaiz no ha sido .
     */
    private void construirRecursivo(TipoDeDimension tipoDeDimension, TipoCategoria tipoRaiz, mxCell raiz) throws NoEncontrado {
        for (int i = 0; i < raiz.getEdgeCount(); i++) {
            mxCell celda = (mxCell) raiz.getEdgeAt(i);
            if (celda.getSource().equals(raiz)) {
                tipoDeDimension.agregarNodo(tipoRaiz, new TipoCategoria((String) celda.getValue()), 1);
            }
        }
    }

    /**
     * Obtiene todos los nodos que no tengan padres en el grafo actual.
     *
     * @return Lista de todas las raíces.
     */
    private List<mxCell> obtenerRaices() {
        List<mxCell> raices = new ArrayList<>();
        for (Nodo nodo : nodosSueltos) {
            mxCell celda = (mxCell) nodo.getInformacion();
            int cantidadHijos = celda.getEdgeCount();
            if (cantidadHijos == 0) {
                raices.add(celda);
            } else {
                boolean esRaiz = true;
                for (int i = 0; i < cantidadHijos; i++) {
                    mxCell lado = (mxCell) celda.getEdgeAt(i);
                    if (lado.getTarget().equals(celda)) {
                        esRaiz = false;
                        break;
                    }
                }
                if (esRaiz) {
                    raices.add(celda);
                }
            }
        }
        return raices;
    }
}
