/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author camilo
 */
public class NoEncontrado extends Exception {

    Object dato;

    /**
     * Arroja una nueva excepción con el dato no encontrado. Excepción de la
     * clase Arbol y Nodo
     *
     * @param dato Dato no encontrado.
     */
    public NoEncontrado(Object dato) {
        super("No encontrado" + dato);
        this.dato = dato;
    }
}
