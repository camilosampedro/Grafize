/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Camilo Sampedro
 */
public class MouseEventInstancia extends MouseAdapter {

    private final Grafo grafo;

    /**
     * Constructor.
     *
     * @param grafo Grafo al que se le agregará el controlador.
     */
    public MouseEventInstancia(Grafo grafo) {
        this.grafo = grafo;
    }

    /**
     * Controlador para cuando se hace clic sobre el grafo.
     *
     * @param e Evento.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Si es un doble clic.
        if (e.getClickCount() == 2) {
            // Solicita el nombre que irá en el nodo.
            if (SwingUtilities.isLeftMouseButton(e)) {
                String nombre = JOptionPane.showInputDialog(null, "Por favor ingrese el nombre", "Ingresar nombre", JOptionPane.QUESTION_MESSAGE);
                if (nombre != null) {
                    grafo.agregarNodo(nombre, Grafo.CATEGORIA, e.getX(), e.getY());
                }
            } //else {
//                grafo.agregarNodo(nombre, Grafo.DIMENSION, e.getX(), e.getY());
//            }

        }
    }
}
