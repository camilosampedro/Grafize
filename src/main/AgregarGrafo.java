/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class AgregarGrafo extends Ventana {

    public AgregarGrafo(String nome) {
        AgregarGrafo.getGraph().getModel().beginUpdate();
        Object parent = AgregarGrafo.getGraph().getDefaultParent();
        Object v1 = AgregarGrafo.getGraph().insertVertex(parent, null, nome, 330, 30, 100, 50, mxConstants.STYLE_ROUNDED+"=true;"+mxConstants.STYLE_STROKECOLOR+"=#9E9E9E;fillColor=#9E9E9E");
        AgregarGrafo.getHash().put(nome, v1);
        AgregarGrafo.getGraph().getModel().endUpdate();
    }

}
