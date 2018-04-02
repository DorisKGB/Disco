package vista;

import Atxy2k.CustomTextField.RestrictedTextField;
import controlador.CControlD;
import controlador.CFactura;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Asistencia;
import modelo.FacturaPro;
import modelo.Factura;

public class CierreCaja extends javax.swing.JFrame {

    List<Factura> listaFacturas = new ArrayList<Factura>();
    Calendar calen = GregorianCalendar.getInstance();
    Date fecha = calen.getTime();
    DefaultTableModel m;
    DefaultTableModel me;
    DefaultTableModel ma;
    SimpleDateFormat formatoDeFecha1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
    double precioDisco = 0.0;
    double precioKaraoke = 0.0;
    double precioCanciones = 0.0;
    double precioTotal = 0.0;
    double PrecioCaja = 0.0;
    double TotalVentas = 0.0;
    Date fechaCierre = Login.fechaOpen;

    DecimalFormat df = new DecimalFormat("#.##");

    public CierreCaja() {

        initComponents();
        datecierre.setDate(fechaCierre);
        llenarTablaAsistencia();
        llenarTablaVentas();
        Restricciones();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public void Restricciones() {
        RestrictedTextField restricted;

        restricted = new RestrictedTextField(txtCanciones);
        restricted.setLimit(4);
        restricted.setOnlyNums(true);

        restricted = new RestrictedTextField(txtEntradasDisco);
        restricted.setLimit(4);
        restricted.setOnlyNums(true);
        restricted = new RestrictedTextField(txtEntradasKaraoke);
        restricted.setLimit(4);
        restricted.setOnlyNums(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAsistencia = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEntradasDisco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEntradasKaraoke = new javax.swing.JTextField();
        txtPrecio1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCanciones = new javax.swing.JTextField();
        txtPrecio2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioTotalVentas = new javax.swing.JTextField();
        btnCerrarCaja = new javax.swing.JButton();
        txtPrecioD = new javax.swing.JTextField();
        txtPrecioK = new javax.swing.JTextField();
        txtPrecioC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        datecierre = new com.toedter.calendar.JDateChooser();
        btnDarFecha = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductosV = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(955, 624));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("LISTA DEL PERSONAL");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 440, 170, 20);

        tbAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbAsistencia);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 460, 570, 100);

        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbVentas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 190, 570, 230);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("LISTA DE VENTAS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 170, 150, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Numero de Entradas Disco:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 60, 170, 14);
        getContentPane().add(txtEntradasDisco);
        txtEntradasDisco.setBounds(380, 60, 50, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Precio Total:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(570, 60, 70, 20);

        txtPrecio.setEnabled(false);
        getContentPane().add(txtPrecio);
        txtPrecio.setBounds(660, 60, 70, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Numero de Entradas Karaoke:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 90, 170, 14);
        getContentPane().add(txtEntradasKaraoke);
        txtEntradasKaraoke.setBounds(380, 90, 50, 20);

        txtPrecio1.setEnabled(false);
        getContentPane().add(txtPrecio1);
        txtPrecio1.setBounds(660, 90, 70, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Precio Total:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 90, 70, 14);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Numero de Canciones:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(200, 120, 170, 14);
        getContentPane().add(txtCanciones);
        txtCanciones.setBounds(380, 120, 50, 20);

        txtPrecio2.setEnabled(false);
        getContentPane().add(txtPrecio2);
        txtPrecio2.setBounds(660, 120, 70, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Precio Total:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(570, 120, 70, 20);

        txtPrecioTotalVentas.setEditable(false);
        txtPrecioTotalVentas.setBackground(new java.awt.Color(204, 204, 255));
        txtPrecioTotalVentas.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txtPrecioTotalVentas.setForeground(new java.awt.Color(0, 102, 102));
        txtPrecioTotalVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioTotalVentas.setText("0.00");
        txtPrecioTotalVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioTotalVentasActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecioTotalVentas);
        txtPrecioTotalVentas.setBounds(710, 500, 160, 30);

        btnCerrarCaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrarCaja.setForeground(new java.awt.Color(0, 102, 102));
        btnCerrarCaja.setText("CERRAR CAJA");
        btnCerrarCaja.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarCaja);
        btnCerrarCaja.setBounds(710, 540, 160, 30);

        txtPrecioD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioDKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioDKeyPressed(evt);
            }
        });
        getContentPane().add(txtPrecioD);
        txtPrecioD.setBounds(480, 60, 60, 20);

        txtPrecioK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKKeyPressed(evt);
            }
        });
        getContentPane().add(txtPrecioK);
        txtPrecioK.setBounds(480, 90, 60, 20);

        txtPrecioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCActionPerformed(evt);
            }
        });
        txtPrecioC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioCKeyPressed(evt);
            }
        });
        getContentPane().add(txtPrecioC);
        txtPrecioC.setBounds(480, 120, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CIERRE DE CAJA");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(300, 0, 330, 44);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("$");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(650, 60, 10, 20);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("$");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(470, 60, 10, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("$");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(470, 90, 10, 20);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("$");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(470, 120, 10, 20);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setText("$");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(690, 500, 30, 30);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("$");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(650, 90, 10, 20);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("$");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(650, 120, 10, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("FECHA DE CIERRE");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(780, 10, 140, 20);

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        txaDescripcion.setText("Observaciones");
        txaDescripcion.setToolTipText("Observaciones");
        jScrollPane3.setViewportView(txaDescripcion);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(670, 420, 230, 70);
        getContentPane().add(datecierre);
        datecierre.setBounds(780, 30, 140, 20);

        btnDarFecha.setText("Dar Fecha");
        btnDarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarFechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDarFecha);
        btnDarFecha.setBounds(800, 60, 100, 23);

        tbProductosV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane4.setViewportView(tbProductosV);
        if (tbProductosV.getColumnModel().getColumnCount() > 0) {
            tbProductosV.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(670, 220, 230, 150);

        jLabel19.setText("LISTA DE PRODUCTOS VENDIDOS");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(710, 160, 190, 14);

        jLabel20.setText("Codigo");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(670, 190, 40, 14);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(710, 190, 70, 20);

        jButton1.setText("OBTENER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(810, 190, 90, 23);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtTotal);
        txtTotal.setBounds(820, 380, 80, 20);

        jLabel21.setText("Total Vendidos: ");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(730, 380, 100, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/fondo2.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(580, 446));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 940, 930);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioTotalVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioTotalVentasActionPerformed

    }//GEN-LAST:event_txtPrecioTotalVentasActionPerformed

    private void txtPrecioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCActionPerformed

    }//GEN-LAST:event_txtPrecioCActionPerformed

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        String DescripcionDisco = "Nro: " + txtEntradasDisco.getText() + " PU:" + txtPrecioD.getText() + " PT:" + txtPrecio.getText();
        String DescripcionKaraoke = "Nro: " + txtEntradasKaraoke.getText() + " PU:" + txtPrecioK.getText() + " PT:" + txtPrecio1.getText();
        String DescripcionCanciones = "Nro: " + txtCanciones.getText() + " PU:" + txtPrecioC.getText() + " PT:" + txtPrecio2.getText();
        PrecioCaja = Double.parseDouble(txtPrecioTotalVentas.getText());
        PrecioCaja = (double) Math.round(PrecioCaja * 100) / 100;
        if (!"".equals(txtPrecio.getText()) && !"".equals(txtPrecio1.getText()) && !"".equals(txtPrecio.getText())) {
            if (JOptionPane.showConfirmDialog(null, "¿Desea realmente Cerrar Caja <RECUERDE SOLO DEBE EFECTUARSE AL TERMINAR LA JORNADA DE VENTAS>", "CERRAR CAJA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                new CControlD().CierreCaja(DescripcionDisco, DescripcionKaraoke, DescripcionCanciones, PrecioCaja, datecierre.getDate(), txaDescripcion.getText());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todo los Campos");
        }

    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void txtPrecioDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioDKeyPressed
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            if (!"".equals(txtEntradasDisco.getText()) && !"".equals(txtPrecioD.getText())) {
                precioDisco = Double.parseDouble(txtEntradasDisco.getText()) * Double.parseDouble(txtPrecioD.getText());
                precioDisco = (double) Math.round(precioDisco * 100) / 100;
                txtPrecio.setText("" + precioDisco);
                TotalVentas = (precioDisco + precioTotal + precioKaraoke + precioCanciones);
                TotalVentas = (double) Math.round(TotalVentas * 100) / 100;
                txtPrecioTotalVentas.setText("" + TotalVentas);
//txtPrecioTotalVentas.setText("" + (precioDisco + precioTotal + precioKaraoke + precioCanciones));
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad de Entradas/Precio");
            }
        }
    }//GEN-LAST:event_txtPrecioDKeyPressed

    private void txtPrecioKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKKeyPressed
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            if (!"".equals(txtEntradasKaraoke.getText()) && !"".equals(txtPrecioK.getText())) {
                precioKaraoke = Double.parseDouble(txtEntradasKaraoke.getText()) * Double.parseDouble(txtPrecioK.getText());
                precioKaraoke = (double) Math.round(precioKaraoke * 100) / 100;
                txtPrecio1.setText("" + precioKaraoke);
                TotalVentas = (precioDisco + precioTotal + precioKaraoke + precioCanciones);
                TotalVentas = (double) Math.round(TotalVentas * 100) / 100;
                txtPrecioTotalVentas.setText("" + TotalVentas);
                //txtPrecioTotalVentas.setText("" + (precioDisco + precioTotal + precioKaraoke + precioCanciones));
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad de Entradas/Precio");
            }
        }


    }//GEN-LAST:event_txtPrecioKKeyPressed

    private void txtPrecioCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCKeyPressed
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            if (!"".equals(txtCanciones.getText()) && !"".equals(txtPrecioC.getText())) {
                precioCanciones = Double.parseDouble(txtCanciones.getText()) * Double.parseDouble(txtPrecioC.getText());
                precioCanciones = (double) Math.round(precioCanciones * 100) / 100;
                txtPrecio2.setText("" + precioCanciones);
                TotalVentas = (precioDisco + precioTotal + precioKaraoke + precioCanciones);
                TotalVentas = (double) Math.round(TotalVentas * 100) / 100;
                txtPrecioTotalVentas.setText("" + TotalVentas);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad de Entradas/Precio");
            }
        }


    }//GEN-LAST:event_txtPrecioCKeyPressed

    private void txtPrecioDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioDKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' != car > '9') && txtPrecioD.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' != car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtPrecioDKeyTyped

    private void txtPrecioKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' != car > '9') && txtPrecioK.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' != car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtPrecioKKeyTyped

    private void txtPrecioCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' != car > '9') && txtPrecioC.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' != car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtPrecioCKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new MenuCD().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void btnDarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarFechaActionPerformed
        if (datecierre.getDate() != null) {
            llenarTablaAsistencia();
            llenarTablaVentas();
        }
    }//GEN-LAST:event_btnDarFechaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        llenarTablaProductos(Integer.parseInt(txtCodigo.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed
    public void llenarTablaAsistencia() {
        String titulos[] = {"Cedula", "Nombres", "Apellidos", "Tipo"};
        m = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        String fila[] = new String[4];
        List<Asistencia> lista = new ArrayList<Asistencia>();
        lista = new CControlD().MostrarAsistenciasFecha(datecierre.getDate());
        try {
            for (Asistencia e : lista) {
                fila[0] = e.getEmpleado().getCedula();
                fila[1] = e.getEmpleado().getNombre();
                fila[2] = e.getEmpleado().getApellido();
                fila[3] = e.getEmpleado().getTipo();
                m.addRow(fila);
            }
            tbAsistencia.setModel(m);
            TableColumnModel columnModel = tbAsistencia.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(150);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(150);;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Existen Registros");
        }
    }

    public void llenarTablaProductos(int codigo) {
        int total = 0;
        String titulos[] = {"Nombre", "cant","Cod.Fac"};
        me = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tbProductosV.setModel(me);
        String fila[] = new String[3];
        List<FacturaPro> lista;
        try {
            for (Factura e : listaFacturas) {
                lista = new ArrayList<FacturaPro>();
                lista = e.getListaFacturaPro();
                for (FacturaPro p : lista) {
                    if (codigo == p.getProducto().getIdProducto()) {
                        fila[0] = p.getProducto().getNombre();
                        fila[1] = "" + p.getCantidad();
                        fila[2] =""+p.getFactura().getIdFactura();
                        total = total + p.getCantidad();
                        me.addRow(fila);
                    }
                }

            }
            tbProductosV.setModel(me);
            txtTotal.setText("" + total);
            TableColumnModel columnModel = tbProductosV.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(200);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(1).setPreferredWidth(80);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Existen Registros");
        }
    }

    public void llenarTablaVentas() {
        listaFacturas = new ArrayList<Factura>();
        String titulos[] = {"Cod", "Fecha", "Total", "Emitida Por"};

        FacturaPro fp;
        ma = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        String fila[] = new String[4];

        //Verificar la busqueda de facturas para la caja 
        listaFacturas = new CControlD().MostrarFacturasCaja(datecierre.getDate());
        try {
            for (Factura f : listaFacturas) {
                fila[0] = "" + f.getIdFactura();
                fila[1] = "" + formatoDeFecha1.format(f.getFecha());
                precioTotal = precioTotal + f.getPrecioTotal();
                precioTotal = (double) Math.round(precioTotal * 100) / 100;
                fila[2] = String.valueOf(f.getPrecioTotal());
                fila[3] = f.getEmpleado().getNombre() + " " + f.getEmpleado().getApellido();
                ma.addRow(fila);
            }
            tbVentas.setModel(ma);
            TableColumnModel columnModel = tbVentas.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50);
            columnModel.getColumn(1).setPreferredWidth(120);
            columnModel.getColumn(2).setPreferredWidth(100);
            columnModel.getColumn(3).setPreferredWidth(300);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Existe Facturas");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton btnDarFecha;
    private com.toedter.calendar.JDateChooser datecierre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbAsistencia;
    private javax.swing.JTable tbProductosV;
    private javax.swing.JTable tbVentas;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextField txtCanciones;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEntradasDisco;
    private javax.swing.JTextField txtEntradasKaraoke;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecio1;
    private javax.swing.JTextField txtPrecio2;
    private javax.swing.JTextField txtPrecioC;
    private javax.swing.JTextField txtPrecioD;
    private javax.swing.JTextField txtPrecioK;
    private javax.swing.JTextField txtPrecioTotalVentas;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
