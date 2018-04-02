

package vista;


public class Bodega extends javax.swing.JFrame {


    public Bodega() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);           
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnListaProductos = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnListasCaja = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnIngresarEmpleados2 = new javax.swing.JButton();
        btnPromocion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(585, 502));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 0, 0);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMINISTRACION");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 30, 350, 40);

        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/IngresarP.png"))); // NOI18N
        btnIngresar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(120, 100, 210, 90);

        btnListaProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnListaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/LPorductosE.png"))); // NOI18N
        btnListaProductos.setText("b");
        btnListaProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaProductos);
        btnListaProductos.setBounds(120, 210, 210, 90);

        btnAsistencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/ListaAsistencia.png"))); // NOI18N
        btnAsistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsistencia);
        btnAsistencia.setBounds(120, 320, 210, 90);

        btnListasCaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnListasCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/LICA.png"))); // NOI18N
        btnListasCaja.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnListasCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListasCajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnListasCaja);
        btnListasCaja.setBounds(350, 210, 210, 90);

        btnAtras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 102, 102));
        btnAtras.setText("ATRAS");
        btnAtras.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras);
        btnAtras.setBounds(460, 430, 100, 40);

        btnIngresarEmpleados2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresarEmpleados2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/ingresarE.png"))); // NOI18N
        btnIngresarEmpleados2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnIngresarEmpleados2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarEmpleados2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresarEmpleados2);
        btnIngresarEmpleados2.setBounds(350, 100, 210, 90);

        btnPromocion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/agrPromociones.png"))); // NOI18N
        btnPromocion.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromocionActionPerformed(evt);
            }
        });
        getContentPane().add(btnPromocion);
        btnPromocion.setBounds(350, 320, 210, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/general.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaProductosActionPerformed
       new ListaProductoBodega().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnListaProductosActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        new ListaAsistencias().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        new NuevoProducto().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnListasCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListasCajaActionPerformed
        new ListaCajas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnListasCajaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
      this.dispose();
      new Menu().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Menu().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnIngresarEmpleados2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarEmpleados2ActionPerformed
        this.dispose();
        new NuevoEmpleado().setVisible(true);
        
    }//GEN-LAST:event_btnIngresarEmpleados2ActionPerformed

    private void btnPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromocionActionPerformed
       this.dispose();
        new nuevaPromocion().setVisible(true);
    }//GEN-LAST:event_btnPromocionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresarEmpleados2;
    private javax.swing.JButton btnListaProductos;
    private javax.swing.JButton btnListasCaja;
    private javax.swing.JButton btnPromocion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
