package vista;

import Atxy2k.CustomTextField.RestrictedTextField;
import controlador.CCliente;
import controlador.CFactura;
import controlador.CProducto;
import controlador.Ticket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Producto;
import java.awt.print.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumnModel;

public class Factura extends javax.swing.JFrame implements Printable {
    public static double iva=0.12;
    public static String iva_presentar="";
    String titulos[] = {"Cant", "Cod", "Descripcion", "V/Unit", "V/Total"};
    DefaultTableModel ma = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    Double ValorNeto = 0.0;
    Double ValorIva = 0.0;
    Double Total = 0.00;
    int idCliente = 1;
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
    DecimalFormat df = new DecimalFormat("#.##");

    Calendar calen = GregorianCalendar.getInstance();
    Date fechac = calen.getTime();

     public static void muestraContenido(String archivo){
        try{
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            iva_presentar=cadena;
            iva=(Double.parseDouble(cadena))/100;
            
            
        }
        b.close();
        System.out.println("el iva es "+ iva);
        }catch(Exception e){
            System.out.println(""+ e.getMessage());    
        }
        
    };
   
    public Factura() throws ParseException, IOException {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        muestraContenido("src\\vista\\iva.txt");
        lbNombreE.setText(Login.nombre);
        lbfecha.setText("" + formatoDeFecha.format(fechac));
        lbDescuento.setText("0.00");
        lbSubtotal.setText("0.00");
        lbValorn.setText("0.00");
        lbIva.setText("0.00");
        lbtotal.setText("0.00");
        jLabel14.setText("Iva "+ iva_presentar +" %");
        Restricciones();
    }

    public double redondear(double numero, int decimales) {
        return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
    }

    public void Restricciones() {
        RestrictedTextField restricted;
        //Restricciones para RucCedula
        restricted = new RestrictedTextField(txtRucCedula);
        restricted.setOnlyNums(true);
        restricted.setLimit(13);
    }
    
    
    public double CalcularPrecioIva(double precio, int accion){
        double precioactual=0;
        //Con iva
        if(accion==1){
            precioactual=precio+(precio*iva);
        //Sin iva
        }else{
            precioactual=precio-(precio*iva);        
        }        
        return precioactual;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombreE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PFactura = new javax.swing.JPanel();
        Ptabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbIva = new javax.swing.JLabel();
        lbtotal = new javax.swing.JLabel();
        lbDescuento = new javax.swing.JLabel();
        lbSubtotal = new javax.swing.JLabel();
        lbValorn = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbEfectivo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JTextField();
        lbfecha = new javax.swing.JLabel();
        txtRucCedula = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(565, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lbNombreE.setText("Nombre del Empleado");
        getContentPane().add(lbNombreE);
        lbNombreE.setBounds(100, 10, 166, 14);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Bienvenido: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 80, 14);

        PFactura.setBackground(new java.awt.Color(255, 255, 255));
        PFactura.setMinimumSize(new java.awt.Dimension(590, 520));
        PFactura.setLayout(null);

        Ptabla.setBackground(new java.awt.Color(255, 255, 255));
        Ptabla.setLayout(null);

        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Descripcion", "Valor/Unitario", "Valor/Total"
            }
        ));
        tbFactura.setToolTipText("Clik para Agregar Productos");
        tbFactura.setGridColor(new java.awt.Color(255, 255, 255));
        tbFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFactura);

        Ptabla.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 600, 250);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        lbIva.setText("xxxxxxxxxx");
        jPanel3.add(lbIva);
        lbIva.setBounds(171, 100, 70, 14);

        lbtotal.setText("xxxxxxxxxx");
        jPanel3.add(lbtotal);
        lbtotal.setBounds(171, 132, 60, 14);

        lbDescuento.setText("xxxxxxxxxx");
        jPanel3.add(lbDescuento);
        lbDescuento.setBounds(171, 57, 60, 14);

        lbSubtotal.setText("xxxxxxxxxx");
        jPanel3.add(lbSubtotal);
        lbSubtotal.setBounds(171, 80, 60, 14);

        lbValorn.setText("xxxxxxxxxx");
        jPanel3.add(lbValorn);
        lbValorn.setBounds(171, 32, 60, 14);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Total $");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(40, 130, 80, 14);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Iva 14 $");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(40, 100, 80, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Subtotal $");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(40, 80, 70, 14);

        lbEfectivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEfectivo.setText("Descuento $");
        jPanel3.add(lbEfectivo);
        lbEfectivo.setBounds(40, 60, 70, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Valor Neto:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(40, 30, 80, 14);

        Ptabla.add(jPanel3);
        jPanel3.setBounds(340, 230, 260, 160);

        PFactura.add(Ptabla);
        Ptabla.setBounds(0, 130, 600, 390);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(105, 56, 300, 20);

        lbfecha.setText("xxxxxxxxxxxxxxx");
        jPanel1.add(lbfecha);
        lbfecha.setBounds(448, 59, 140, 14);

        txtRucCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucCedulaActionPerformed(evt);
            }
        });
        txtRucCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucCedulaKeyPressed(evt);
            }
        });
        jPanel1.add(txtRucCedula);
        txtRucCedula.setBounds(105, 10, 139, 20);

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCliente);
        txtCliente.setBounds(318, 10, 270, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RUC/Cédula:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 10, 80, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(270, 10, 42, 14);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dirección:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 59, 70, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(409, 59, 36, 14);

        PFactura.add(jPanel1);
        jPanel1.setBounds(0, 30, 620, 90);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 102, 102));
        btnAgregar.setText("Agregar Cliente");
        btnAgregar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        PFactura.add(btnAgregar);
        btnAgregar.setBounds(450, 0, 140, 30);

        getContentPane().add(PFactura);
        PFactura.setBounds(0, 0, 600, 520);

        btnEjecutar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEjecutar.setForeground(new java.awt.Color(0, 102, 102));
        btnEjecutar.setText("EJECUTAR VENTA");
        btnEjecutar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEjecutar);
        btnEjecutar.setBounds(70, 550, 200, 40);

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
        btnAtras.setBounds(380, 550, 130, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/fondo2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 160, 600, 460);

        setBounds(0, 0, 616, 651);
    }// </editor-fold>//GEN-END:initComponents

    public void ingresoProductos(Producto p, int cantidad) {
        double temp=0;
        String fila[] = new String[5];

        if (cantidad > p.getcCantidad()) {
            JOptionPane.showMessageDialog(null, "Stock Insuficiente");

        } else {

            fila[0] = String.valueOf(cantidad);
            fila[1] = String.valueOf(p.getIdProducto());
            fila[2] = p.getNombre();
            //Modificacion del precion de lo productos aki 
           // fila[3] = String.valueOf(p.getPrecio());
            temp=CalcularPrecioIva(p.getPrecio(), 0);
             fila[3] = String.valueOf(temp);
            double pt = temp * cantidad;
            pt = redondear(pt, 4);
            fila[4] = "" + pt;
            ValorNeto = ValorNeto + Double.valueOf(fila[4]);
            //ValorNeto = redondear(ValorNeto, 2);
            lbValorn.setText(""+df.format(ValorNeto));
            ma.addRow(fila);
            tbFactura.setModel(ma);
            TableColumnModel columnModel = tbFactura.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(400);
            columnModel.getColumn(3).setPreferredWidth(100);
            columnModel.getColumn(4).setPreferredWidth(100);

            //ValorIva = ValorNeto * 0.12;
            ValorIva =ValorIva+ ((p.getPrecio()*cantidad) * iva);
                //ValorIva = redondear(ValorIva, 2);
            lbIva.setText("" + df.format(ValorIva));
            Total = ValorIva + ValorNeto;
            Total = redondear(Total, 2);
            lbtotal.setText("" + Total);
        }
    }
    private void tbFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFacturaMouseClicked
        if (evt.isMetaDown()) {
            int i = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar Producto Seleccionado?", "Confirmar acción", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                ma = (DefaultTableModel) tbFactura.getModel();
                try {
                    ValorNeto = ValorNeto - Double.parseDouble((String) tbFactura.getValueAt(tbFactura.getSelectedRow(), 4));
                    //ValorNeto = redondear(ValorNeto, 2);
                    lbValorn.setText(""+df.format(ValorNeto));
                    int idpro= Integer.parseInt((String) tbFactura.getValueAt(tbFactura.getSelectedRow(), 1));
                    int cant= Integer.parseInt((String) tbFactura.getValueAt(tbFactura.getSelectedRow(), 0));
                    ma.removeRow(tbFactura.getSelectedRow());
                    tbFactura.setModel(ma);
                    //Revisar esto                    
                    System.out.println("el id actual es: "+idpro);
                    Producto p= new CProducto().MostrarProductoCajaCodigo(idpro);
                    ValorIva = ValorIva-((p.getPrecio()*cant)*iva);
                    System.out.println("el valor actual del iva es: "+ValorIva);
                    //ValorIva =ValorIva+ (p.getPrecio() * iva);
                    //ValorIva = ValorIva;
                    lbIva.setText("" + df.format(ValorIva));
                    Total = ValorIva + ValorNeto;
                    Total = redondear(Total, 2);
                    lbtotal.setText("" + Total);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error seleccione nuevamente el Producto");
                }
            }
        }
    }//GEN-LAST:event_tbFacturaMouseClicked

    private void txtRucCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucCedulaKeyPressed
        char caracter = evt.getKeyChar();
        if (caracter == java.awt.event.KeyEvent.VK_ENTER) {
            String cedula = txtRucCedula.getText();
            try {
                Cliente c = new CCliente().BuscarClienteCedula(cedula);
                txtCliente.setText(c.getNombre() + " " + c.getApellido());
                txtDireccion.setText(c.getDireccion());
                idCliente = c.getIdCliente();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No Existe");
            }
        }
    }//GEN-LAST:event_txtRucCedulaKeyPressed
    public int Imprimir(int idCliente, List<Producto> lista) {
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss aa");
        Cliente c = new CCliente().BuscarClienteFactura(idCliente);
        Ticket ticket = new Ticket();
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("LE ATENDIO: " + Login.nombre);
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("" + fecha.format(date) + " " + hora.format(date));
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("Cedula/Ruc: " + c.getCedula());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("Nombre: " + c.getNombre() + " " + c.getApellido());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("Direccion: " + c.getDireccion());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("Telefono: " + c.getTelefono());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("Cant" + "Descripcion      " + "P/Unitario" + " P/Total");
        ticket.AddSubCabecera(ticket.DarEspacio());
        //Agregar de Productos
        for (Producto p : lista) {
            ticket.AddItem("" + p.getcCantidad(), "" + p.getNombre(), "" + p.getPrecio(), "" + p.getTipo());
            ticket.AddItem("", "", " ", ticket.DarEspacio());
        }
        ticket.AddTotal("", ticket.DibujarLinea(29));
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("SUBTOTAL", lbValorn.getText());
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("Descuento", "0.00");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("IVA 0%", "0.00");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("IVA "+ iva_presentar +" %", lbIva.getText());
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("TOTAL", lbtotal.getText());
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DibujarLinea(29));
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea("Gracias por su Compra ");
        ticket.AddPieLinea(ticket.DarEspacio());;
        return ticket.ImprimirDocumento();

    }
    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        int op = 0;
        int n = 0;
        List<Producto> lista = new ArrayList<Producto>();
        int cantidad = 0;
        int opc = 0;
        if (tbFactura.getRowCount() > 0) {
            for (int i = 0; i < tbFactura.getRowCount(); i++) {
                Producto p = new Producto();
                p.setcCantidad(Integer.parseInt((String) tbFactura.getValueAt(i, 0)));
                p.setIdProducto(Integer.parseInt((String) tbFactura.getValueAt(i, 1)));
                p.setNombre((String) tbFactura.getValueAt(i, 2));
                p.setPrecio(Double.parseDouble((String) tbFactura.getValueAt(i, 3)));
                p.setTipo((String) tbFactura.getValueAt(i, 4));
                lista.add(p);
            }
        }
        if (!lista.isEmpty()) {
            //Escribir el Ruc o Cedula de la discoteca
            if ("0703147215".equals(txtRucCedula.getText())) {
                op = 1;
                lbSubtotal.setText("0.00");
                lbValorn.setText("0.00");
                lbtotal.setText("0.00");
                lbIva.setText("0.00");
            }
            if (op != 1) {
                n = Imprimir(idCliente, lista);
                if (n == 1) {
                    opc = new CFactura().GuardarFactura(Login.SessionId, idCliente, ValorNeto, Total, lista);
                }
            }
        }
        if (opc == 1) {
            for (Producto pd : lista) {
                new CProducto().ProductoVendido(pd.getcCantidad(), pd.getIdProducto());
                ListaProductosFactura.recargar();

            }
            try {
                cantidad = Integer.valueOf(JOptionPane.showInputDialog("Ingrese Valor Total Entregado"));
                Double cambio = cantidad - Total;
                cambio = (double) Math.round(cambio * 100) / 100;
                JOptionPane.showMessageDialog(null, "EL CAMBIO ES: " + cambio);
            } catch (Exception e) {

            }
            if (n == 1) {
                txtRucCedula.setText("");
                txtCliente.setText("");
                txtDireccion.setText("");
                ma = new DefaultTableModel(null, titulos);
                tbFactura.setModel(ma);
                ValorNeto = 0.0;
                ValorIva = 0.0;
                Total = 0.0;
                lbSubtotal.setText("0.00");
                lbValorn.setText("0.00");
                lbtotal.setText("0.00");
                lbIva.setText("0.00");
                idCliente = 1;
            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        new vista.Cliente().setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        new Menu().setVisible(true);
        ListaProductosFactura.cerrar();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Menu().setVisible(true);
        ListaProductosFactura.cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void txtRucCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucCedulaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PFactura;
    private javax.swing.JPanel Ptabla;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDescuento;
    private javax.swing.JLabel lbEfectivo;
    private javax.swing.JLabel lbIva;
    private javax.swing.JLabel lbNombreE;
    private javax.swing.JLabel lbSubtotal;
    private javax.swing.JLabel lbValorn;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbtotal;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtRucCedula;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pageF, int index) throws PrinterException {
        if (index > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pageF.getImageableX() + 20, pageF.getImageableY() + 60);
        hub.scale(0.6, 0.6);
        PFactura.printAll(graf);
        return PAGE_EXISTS;
    }
}
