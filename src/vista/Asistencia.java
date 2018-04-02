package vista;

import Atxy2k.CustomTextField.RestrictedTextField;
import controlador.CControlD;
import controlador.CEmpleado;
import javax.swing.JOptionPane;
import modelo.Empleado;

public class Asistencia extends javax.swing.JFrame {

    int idCliente = 0;

    public Asistencia() {
        initComponents();
        Restricciones();
        this.setLocationRelativeTo(null);
        this.setResizable(false);   
    }
 public void Restricciones() {
        RestrictedTextField restricted;
        //Restricciones para Icc
        restricted = new RestrictedTextField(txtCedula);
        restricted.setLimit(10);
        restricted.setOnlyNums(true);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(590, 287));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 102, 102));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(90, 200, 150, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CONTROL DE ASISTENCIA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 40, 330, 29);

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
        btnAtras.setBounds(340, 200, 170, 40);

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtCliente);
        txtCliente.setBounds(410, 110, 150, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Empleado");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(330, 110, 68, 17);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
        });
        getContentPane().add(txtCedula);
        txtCedula.setBounds(180, 110, 139, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cédula:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(110, 110, 60, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Dirección:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(110, 150, 70, 17);

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(180, 150, 190, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/general.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 680, 495);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!"".equals(txtCliente.getText())){
        new CControlD().GuardarAsistencia(idCliente);
        txtCedula.setText("");
        txtCliente.setText("");
        txtDireccion.setText("");
        }else
        JOptionPane.showMessageDialog(null, "Ingrese Empleado");    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            String cedula = txtCedula.getText();
            try {
                Empleado e = new CEmpleado().ConsultarEmpleadoCedula(cedula);
                txtCliente.setText(e.getNombre() + " " + e.getApellido());
                txtDireccion.setText(e.getDireccion());
                idCliente = e.getIdEmpleado();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No Existe");
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        new MenuCD().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new MenuCD().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
