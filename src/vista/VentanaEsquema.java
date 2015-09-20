/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import controlador.Grafo;
import controlador.MouseEventEsquema;
import exception.NoEncontrado;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Esquema;
import modelo.TipoDeDimension;

/**
 *
 * @author Camilo Sampedro
 */
public class VentanaEsquema extends javax.swing.JFrame {

    /**
     * Objeto con la información del grafo.
     */
    protected Grafo grafo;

    /**
     * Componente gráfico del grafo. Aquí se hacen las actualizaciones gráficas
     * y se puede obtener información gráfica del grafo y de los nodos.
     */
    private mxGraphComponent graphComponent;

    /**
     * Última celda (Vértice o lado) a la que se le hizo clic. Usado para
     * verificar qué celda eliminar, sabiendo que fue la última a la que se le
     * hizo clic. Si no hay ninguna celda seleccionada, este valor será nulo y
     * ninguna será eliminada.
     */
    private mxCell celda;

    private static Object[] opciones = {
        "Parcial",
        "Total"
    };

    /**
     * Crea una nueva ventana de grafo vacío.
     */
    public VentanaEsquema() {
        grafo = new Grafo();
        initComponents();
        graphComponent.getGraphControl().addMouseListener(new MouseEventEsquema(grafo));
    }

    /**
     * Ventana con un grafo resultado.
     *
     * @param grafo Grafo a imprimir.
     */
    public VentanaEsquema(Grafo grafo) {
        this.grafo = grafo;
        initComponents();
        graphComponent.getGraphControl().addMouseListener(new MouseEventEsquema(grafo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGrafo = new javax.swing.JPanel();
        btnAgregarCategoria = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jlNombre = new javax.swing.JLabel();
        tfIngresadorNombre = new javax.swing.JTextField();
        btnAgregarTipoDimension = new javax.swing.JButton();
        btnConectar = new javax.swing.JToggleButton();
        btnFinalizarEsquema = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGrafo = new javax.swing.JMenu();
        btnMenuMakeOnto = new javax.swing.JMenuItem();
        btnMenuMakeCovering = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuEdicion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafize - Ingresar esquema");

        panelGrafo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGrafo.setLayout(new java.awt.GridLayout(1, 0));
        graphComponent = new mxGraphComponent(grafo);
        //graphComponent.setPreferredSize(new Dimension(500,500));
        //panelGrafo.setLayout(new FlowLayout(FlowLayout.LEFT));
        //System.out.println("Size:" + panelGrafo.getSize());
        panelGrafo.add(graphComponent);

        btnAgregarCategoria.setText("Agregar tipo cagegoría");
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jlNombre.setText("Nombre:");

        btnAgregarTipoDimension.setText("Agregar nuevo tipo dimensión");
        btnAgregarTipoDimension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoDimensionActionPerformed(evt);
            }
        });

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnFinalizarEsquema.setText("Finalizar esquema");
        btnFinalizarEsquema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarEsquemaActionPerformed(evt);
            }
        });

        menuGrafo.setText("Grafo");

        btnMenuMakeOnto.setText("Make onto");
        btnMenuMakeOnto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuMakeOntoActionPerformed(evt);
            }
        });
        menuGrafo.add(btnMenuMakeOnto);

        btnMenuMakeCovering.setText("Make covering");
        menuGrafo.add(btnMenuMakeCovering);
        menuGrafo.add(jSeparator1);

        jMenuItem1.setText("Cerrar");
        menuGrafo.add(jMenuItem1);

        jMenuBar1.add(menuGrafo);

        menuEdicion.setText("Edición");
        jMenuBar1.add(menuEdicion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarTipoDimension)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIngresadorNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinalizarEsquema)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIngresadorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCategoria)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregarTipoDimension))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(btnFinalizarEsquema))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        // TODO add your handling code here:
        grafo.agregarNodo(tfIngresadorNombre.getText(), Grafo.CATEGORIA, randX(), randY());
        tfIngresadorNombre.setText("");
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        grafo.eliminarNodosSeleccionados();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMenuMakeOntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuMakeOntoActionPerformed
        // TODO add your handling code here:
        VentanaEsquema ventana = new VentanaEsquema(grafo);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnMenuMakeOntoActionPerformed

    private void btnAgregarTipoDimensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoDimensionActionPerformed
        // TODO add your handling code here:
//        grafo.agregarNodo(tfIngresadorNombre.getText(), Grafo.HECHO, randX(), randY());
//        tfIngresadorNombre.setText("");
        if (guardarTipoDeDimension()) {
            VentanaEsquema ventanaNueva = new VentanaEsquema();
            ventanaNueva.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAgregarTipoDimensionActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        // TODO add your handling code here:
        if (btnConectar.isSelected()) {
            celda = (mxCell) grafo.getSelectionCell();
            if (celda == null) {
                btnConectar.setSelected(false);
            }
        } else {
            if (celda.equals((mxCell) grafo.getSelectionCell())) {
                return;
            }
            int insercion = JOptionPane.showOptionDialog(this,
                    "Ingrese el nombre del tipo de categoría nuevo",
                    "Nombre",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            try {
                double gradoInclusion = insercion;
                if (gradoInclusion < 0 || gradoInclusion > 1) {
//                    JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entre 0 y 1", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                grafo.enlazarNodos((String) celda.getValue(), (String) ((mxCell) grafo.getSelectionCell()).getValue(), gradoInclusion);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el formato #.##", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (NoEncontrado ex) {
                Logger.getLogger(VentanaEsquema.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnFinalizarEsquemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarEsquemaActionPerformed
        // TODO add your handling code here:
        if (guardarTipoDeDimension()) {
            controlador.ControladorInstancias.iniciarInstancias();
            this.dispose();
        }
    }//GEN-LAST:event_btnFinalizarEsquemaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEsquema.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaEsquema().setVisible(true);
        });
    }

    /**
     * Obtiene un valor aleatorio para insertar en X un nodo.
     *
     * @return Número aleatorio entre 0 y ancho - 150
     */
    public int randX() {
        return (int) (Math.random() * (panelGrafo.getSize().width - 150));
    }

    /**
     * Obtiene un valor aleatorio para insertar en Y un nodo.
     *
     * @return Número aleatorio entre 0 y alto - 150
     */
    public int randY() {
        return (int) (Math.random() * (panelGrafo.getSize().height - 150));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarTipoDimension;
    private javax.swing.JToggleButton btnConectar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFinalizarEsquema;
    private javax.swing.JMenuItem btnMenuMakeCovering;
    private javax.swing.JMenuItem btnMenuMakeOnto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JMenu menuGrafo;
    private javax.swing.JPanel panelGrafo;
    private javax.swing.JTextField tfIngresadorNombre;
    // End of variables declaration//GEN-END:variables

    private boolean guardarTipoDeDimension() {
        TipoDeDimension tipoDeDimension = grafo.construirArbol();
        if (tipoDeDimension == null) {
            int input = JOptionPane.showConfirmDialog(this, "Se necesita que haya una sola raíz. ¿Crear nuevo nodo raíz?", "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == JOptionPane.OK_OPTION) {
                String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre para la nueva raíz");
                grafo.crearRaiz(nombre, randX(), randY());
            }
            return false;
        }
        Esquema.agregarTipoDimension(tipoDeDimension);
        return true;
    }

}
