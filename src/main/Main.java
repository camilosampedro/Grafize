/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JOptionPane;
import modelo.Esquema;
import vista.VentanaEsquema;

/**
 *
 * @author Camilo Sampedro
 */
public class Main {

    /**
     * @param argumentos No recibe argumentos
     */
    public static void main(String[] argumentos) {
        // TODO code application logic here
        String input = JOptionPane.showInputDialog(null, "Por favor, ingrese el tipo de hechos "
                + "que se ingresarán en el modelo.\n"
                + "Por ejemplo: \"venta\" o \"siniestro\" (Sin comillas)",
                "Ingresar tipo de hechos", JOptionPane.QUESTION_MESSAGE);
        Esquema.setTipoDeHechos(input);
        VentanaEsquema ventana = new VentanaEsquema();
        ventana.setVisible(true);
    }

}
