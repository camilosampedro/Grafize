package javaapplication2;


import javax.swing.JOptionPane;


public class AgregarLinea extends Ventana {

    public AgregarLinea() {
        Object parent = this.getGraph().getDefaultParent();
        Object v1 = this.getHash().get(JOptionPane.showInputDialog("Digite o grafo 1:"));
        Object v2 = this.getHash().get(JOptionPane.showInputDialog("Digite o grafo 2:"));
        String nome = JOptionPane.showInputDialog("Digite o nome da linha:");
        this.getGraph().insertEdge(parent, null, nome, v1, v2);

    }

}
