package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class Ventana extends JFrame {

    protected static mxGraph graph = new mxGraph();
    protected static HashMap hash = new HashMap();
    private mxGraphComponent graphComponent;
    private JTextField texto;
    private JButton botaoAdd;
    private JButton botaoDel;
    private JButton botaoLigar;
    private Object cell;

    public static HashMap getHash() {
        return hash;
    }

    public static mxGraph getGraph() {
        return graph;
    }

    public Ventana() {
        super("Modelo");
        initGUI();
    }

    private void initGUI() {
        setSize(700, 500);
        setLocationRelativeTo(null);

        graphComponent = new mxGraphComponent(graph);
        graphComponent.setPreferredSize(new Dimension(670, 380));
        getContentPane().add(graphComponent);

        texto = new JTextField();
        getContentPane().add(texto);
        texto.setPreferredSize(new Dimension(420, 21));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        botaoAdd = new JButton("Agregar");
        getContentPane().add(botaoAdd);
        botaoAdd.addActionListener((ActionEvent e) -> {
            AgregarGrafo add = new AgregarGrafo(texto.getText());
            texto.setText("");
        });

        botaoDel = new JButton("Eliminar");
        getContentPane().add(botaoDel);
        botaoDel.addActionListener((ActionEvent arg0) -> {
            graph.getModel().remove(cell);
        });

        botaoLigar = new JButton("Conectar");
        getContentPane().add(botaoLigar);
        botaoLigar.addActionListener((ActionEvent e) -> {
            AgregarLinea linea = new AgregarLinea();
        });

        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                cell = graphComponent.getCellAt(e.getX(), e.getY());
//                System.out.println(mxConstants.STYLE_EDITABLE);
            }
        });
    }

}
