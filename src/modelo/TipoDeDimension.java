/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
 */
public class TipoDeDimension extends Arbol<TipoCategoria> {

    /**
     * Constructor que extiende la funcionalidad de Arbol.
     *
     * @param datoRaiz Dato que irá en la raíz.
     */
    public TipoDeDimension(TipoCategoria datoRaiz) {
        super(datoRaiz);
    }
}
