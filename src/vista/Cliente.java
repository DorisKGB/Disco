package vista;

import Atxy2k.CustomTextField.RestrictedTextField;
import controlador.CCliente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Cliente extends javax.swing.JFrame {

    public Cliente() {
        initComponents();
        Restricciones();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public void Restricciones() {
        RestrictedTextField restricted;
        //Restricciones para Apellidos
        restricted = new RestrictedTextField(txtApellido);
        restricted.setOnlyText(true);
        restricted.setAcceptSpace(true);
//Restricciones para Nombre
        restricted = new RestrictedTextField(txtNombre);
        restricted.setOnlyText(true);
        restricted.setAcceptSpace(true);
        //Restricciones para RucCedula
        restricted = new RestrictedTextField(txtCedulaRuc);
        restricted.setOnlyNums(true);
        restricted.setLimit(13);

        //Restricciones para Telefono
        restricted = new RestrictedTextField(txtTelefono);
        restricted.setOnlyNums(true);
        restricted.setLimit(10);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtCedulaRuc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDireccion = new javax.swing.JTextArea();
        txtTelefono = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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
        jLabel2.setText("NUEVO CLIENTE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 30, 320, 44);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ruc/Cedula:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(80, 110, 90, 15);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombres:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(80, 140, 80, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Apellidos:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(80, 170, 80, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Direccion:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(80, 200, 80, 15);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Correo/Email:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(80, 310, 100, 15);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Telefono/celular:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(80, 340, 110, 15);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 102, 102));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(370, 320, 100, 40);

        txtCedulaRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaRucKeyReleased(evt);
            }
        });
        jPanel1.add(txtCedulaRuc);
        txtCedulaRuc.setBounds(190, 110, 170, 20);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(190, 140, 170, 20);
        jPanel1.add(txtApellido);
        txtApellido.setBounds(190, 170, 170, 20);

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(190, 310, 170, 20);

        txaDireccion.setColumns(20);
        txaDireccion.setRows(5);
        jScrollPane1.setViewportView(txaDireccion);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(190, 200, 170, 96);

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(190, 340, 170, 20);

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
        btnAtras.setBounds(480, 320, 100, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/empleados.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(370, 110, 210, 190);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/general.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!txtTelefono.getText().equals("") && !txtApellido.getText().equals("") && !txtNombre.getText().equals("") && !txtCedulaRuc.getText().equals("") && !"".equals(txaDireccion.getText())) {
            int i = new CCliente().GuardarCliente(txtApellido.getText(), txtNombre.getText(), txtCorreo.getText(), txtCedulaRuc.getText(), txaDireccion.getText(), txtTelefono.getText());

            if (i == 1) {
                this.dispose();
   
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los Campos son Requiridos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (isEmail(txtCorreo.getText())) {
            System.out.println("Correo Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Correo invalido");
            txtCorreo.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCedulaRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaRucKeyReleased
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            btnGuardarActionPerformed(null);
        }
    }//GEN-LAST:event_txtCedulaRucKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            btnGuardarActionPerformed(null);
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
    }//GEN-LAST:event_formWindowClosing
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public void limpiar() {
        txtApellido.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtCedulaRuc.setText("");
        txtTelefono.setText("");
        txaDireccion.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaDireccion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedulaRuc;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
