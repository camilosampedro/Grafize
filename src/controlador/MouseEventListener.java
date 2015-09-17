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
public class MouseEventListener extends MouseAdapter {

    private final Grafo grafo;

    /**
     * Constructor.
     * @param grafo Grafo al que se le agregará el controlador.
     */
    public MouseEventListener(Grafo grafo) {
        this.grafo = grafo;
    }

    /**
     * Controlador para cuando se hace clic sobre el grafo.
     * @param e Evento.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Si es un doble clic.
        if (e.getClickCount() == 2) {
            // Solicita el nombre que irá en el nodo.
            String nombre = JOptionPane.showInputDialog(null, "Por favor ingrese el nombre", "Ingresar nombre", JOptionPane.QUESTION_MESSAGE);
            if (SwingUtilities.isRightMouseButton(e)) {
                grafo.agregarNodo(nombre, Grafo.ESTILO_HECHO, e.getX(), e.getY());
            } else {
                grafo.agregarNodo(nombre, Grafo.ESTILO_DIMENSION, e.getX(), e.getY());
            }

        }
    }
}
