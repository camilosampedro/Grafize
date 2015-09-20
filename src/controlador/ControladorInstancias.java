/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Esquema;
import vista.VentanaInstancia;

/**
 * Clase encargada de controlar que todos los tipos de dimensión tengan su
 * propia instancia.
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class ControladorInstancias {

    public static void iniciarInstancias() {
        Esquema.getTiposDeDimensiones().stream().map((tipoDeDimensionActual) -> new VentanaInstancia(tipoDeDimensionActual)).forEach((ventanaInstancia) -> {
            ventanaInstancia.setVisible(true);
        });
    }
}
