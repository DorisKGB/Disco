package vista;

import Atxy2k.CustomTextField.RestrictedTextField;
import controlador.CProducto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Producto;

public class EntregaProducto extends javax.swing.JFrame {

    DefaultTableModel ma;

    public EntregaProducto() {
        initComponents();
        persmisos();
        llenarTablas(0);
        Restricciones();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void Restricciones() {
        RestrictedTextField restricted;

        restricted = new RestrictedTextField(txtCodigo);
        restricted.setOnlyNums(true);
        restricted.setLimit(13);
    }

    public void persmisos() {
        if ("Caja".equals(Login.rol)) {
            cbxTipo1.setSelectedItem("Bartman");
            cbxTipo1.setEnabled(false);
        }
    }

    public void llenarTablas(int opcion) {
        String titulos[] = {"Nro", "Tipo", "Nombre", "Cant en Caja", "Cant en Bartman", "Precio", "Cod"};
        List<Producto> MostrarProducto = null;
        ma = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        String fila[] = new String[7];
        int c = 1;
        try {
            if (opcion == 0) {
                MostrarProducto = new CProducto().MostrarProductoCaja();
            } else {
                if (opcion == 1) {
                    Producto p = new CProducto().MostrarProductoCajaCodigo(Integer.parseInt(txtCodigo.getText()));
                    MostrarProducto.add(p);
                } else {
                    MostrarProducto = new CProducto().MostrarProductoCajaTipo((String) cbxTipo.getSelectedItem());
                }
            }
            for (Producto p : MostrarProducto) {

                fila[0] = String.valueOf(c);
                fila[1] = p.getTipo();
                fila[2] = p.getNombre();
                fila[3] = "" + p.getcCantidad();
                fila[4] = "" + p.getbCantidad();
                fila[5] = String.valueOf(p.getPrecio());
                fila[6] = "" + p.getIdProducto();
                ma.addRow(fila);
                c++;
            }

            tbProductos.setModel(ma);
            TableColumnModel columnModel = tbProductos.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50);
            columnModel.getColumn(1).setPreferredWidth(100);
            columnModel.getColumn(2).setPreferredWidth(350);
            columnModel.getColumn(3).setPreferredWidth(100);
            columnModel.getColumn(4).setPreferredWidth(120);
            columnModel.getColumn(5).setPreferredWidth(100);
            columnModel.getColumn(6).setPreferredWidth(50);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Existen Registros");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEntregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxTipo1 = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox();
        btnAtras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ENTREGA DE PRODUCTOS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 20, 490, 44);

        btnEntregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEntregar.setForeground(new java.awt.Color(0, 102, 102));
        btnEntregar.setText("ENTREGAR PRODUCTOS");
        btnEntregar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnEntregar.setEnabled(false);
        btnEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntregar);
        btnEntregar.setBounds(480, 420, 210, 30);

        tbProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cedula", "Hora de entrada", "Fecha"
            }
        ));
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 280, 700, 110);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tipo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 150, 40, 30);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(390, 190, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Codigo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(390, 150, 60, 30);

        cbxTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caja", "Bartman" }));
        jPanel1.add(cbxTipo1);
        cbxTipo1.setBounds(400, 90, 180, 30);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 102, 102));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(590, 190, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("ENTREGAR A:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 90, 80, 30);

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Coctel", "Jarra", "Wisky", "Vodka", "Tequila", "Ron", "Vino", "Bebida", "Picar" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipo);
        cbxTipo.setBounds(140, 190, 160, 30);

        btnAtras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 102, 102));
        btnAtras.setText("ATRAS");
        btnAtras.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras);
        btnAtras.setBounds(30, 420, 100, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("LISTA DE PRODUCTOS ENTREGADOS");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 240, 280, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/fondo2.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 950);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarActionPerformed
        int cant = 1;
        try {
            cant = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la Cantidad  a Entregar de :" + (String) tbProductos.getValueAt(tbProductos.getSelectedRow(), 2)));
            new CProducto().EntregarCantidadProducto(cant, Integer.parseInt((String) tbProductos.getValueAt(tbProductos.getSelectedRow(), 6)), (String) cbxTipo1.getSelectedItem());
            llenarTablas(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Entrega Cancelada");
        }
    }//GEN-LAST:event_btnEntregarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!"".equals(txtCodigo.getText())) {
            llenarTablas(1);
        } else {
            llenarTablas(2);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        if (tbProductos.getSelectedColumn() > 0) {
            btnEntregar.setEnabled(true);
        } else {
            btnEntregar.setEnabled(false);
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        llenarTablas(2);
        btnEntregar.setEnabled(false);
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Menu().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        btnEntregar.setEnabled(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEntregar;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JComboBox cbxTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
