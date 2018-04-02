package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.FacturaPro;
import modelo.Producto;
import modelo.Promocion;

public class CFactura {

    private EntityManager em = Coneccion.em;
    private EntityTransaction tx = em.getTransaction();
    Calendar calen = GregorianCalendar.getInstance();
    Date fecha = calen.getTime();
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");

    public int GuardarFactura(int idEmpleado, int idCliente, Double totalNeto, Double Total, List<Producto> lista) {
        try {
            tx.begin();
            Factura factura = new Factura();
            factura.setEmpleado(em.find(Empleado.class, idEmpleado));
            factura.setCliente(em.find(Cliente.class, idCliente));
            factura.setFecha(fecha);
            factura.setEstado("Activa");

            //Empieza a ingresar la lista de los productos dentro de la factura
            List produList = new ArrayList();
            FacturaPro facturaPro;
            for (Producto p : lista) {

                facturaPro = new FacturaPro();
                facturaPro.setFactura(factura);
                facturaPro.setProducto(em.find(Producto.class, p.getIdProducto()));
                facturaPro.setCantidad(p.getcCantidad());
                facturaPro.setPrecio(p.getPrecio());
                facturaPro.setPrecioTotal(Double.parseDouble(p.getTipo()));
                produList.add(facturaPro);
            }
            factura.setListaFacturaPro(produList);
            factura.setPrecioNeto(totalNeto);;
            factura.setPrecioTotal(Total);
            em.persist(factura);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: Verificar los Datos");
            tx.rollback();
            return 0;
        }

    }

    public void ModificarEstadoFactura(int num, String estado) {
        try {
            tx.begin();
            Factura f = MostrarFactura(num);
            f.setEstado(estado);
            em.merge(f);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: Verificar los Datos");
            tx.rollback();
        }

    }

    public List<Factura> MostrarFactura() {
        try {
            List<Factura> lista = em.createQuery("SELECT f FROM Factura f", Factura.class).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Facturas");
            return null;
        }

    }

    public Producto MostrarProductosEstado(String icc) {
        try {
            String estado = "Disponible";
            Producto pr = em.createQuery("SELECT p FROM Producto p WHERE p.icc= :iccs and p.estado= :estado", Producto.class).setParameter("iccs", icc).setParameter("estado", estado).getSingleResult();
            return pr;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    public List<FacturaPro> MostrarFacturasPro(int idFactura) {
        try {
            List<FacturaPro> lista = em.createQuery("SELECT f FROM FacturaPro f WHERE f.factura= :idFactura", FacturaPro.class).setParameter("idFactura", em.find(Factura.class, idFactura)).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro FacturasPro");
            return null;
        }
    }

    public Factura MostrarFactura(int numFac) {
        try {
            Factura f = em.createQuery("SELECT f FROM Factura f WHERE f.numero= :numFac", Factura.class).setParameter("numFac", numFac).getSingleResult();
            return f;
        } catch (Exception e) {
            System.out.println("No se encontro la Factura por numero");
            return null;
        }
    }

    public List<Factura> MostrarFactura(int numFac, String estado) {
        try {
            List<Factura> f = em.createQuery("SELECT f FROM Factura f WHERE f.numero= :numFac and f.estado= :estado", Factura.class).setParameter("numFac", numFac).setParameter("estado", estado).getResultList();
            return f;
        } catch (Exception e) {
            System.out.println("No se encontro la Factura por numero y estado");
            return null;
        }
    }

    public List<Factura> MostrarFacturaCaja(String fechas, String estado) {
        try {
            Date fecha = formatoDeFecha.parse(fechas);
            List<Factura> f = em.createQuery("SELECT f FROM Factura f WHERE f.fecha= :fecha and f.estado= :estado", Factura.class).setParameter("fecha", fecha).setParameter("estado", estado).getResultList();
            return f;
        } catch (Exception e) {
            System.out.println("No se encontro la Factura por fecha");
            return null;
        }
    }

    public void guardarPromocion(Date fecha, String Descripcion) throws ParseException {
        try {
            tx.begin();
            Promocion p = new Promocion();
            p.setFecha(fecha);
            p.setDescripcion(Descripcion);
            em.persist(p);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado Exitoso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: Verificar los Datos");
            tx.rollback();
        }
    }

    public void ModificarPromocion(int idPromocion, Date fecha, String Descripcion) {
        try {
            tx.begin();
            Promocion p = MostrarPromocionid(idPromocion);
            p.setFecha(fecha);
            p.setDescripcion(Descripcion);
            em.merge(p);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Intente de Nuevo");
            tx.rollback();
        }

    }

    public List<Promocion> MostrarPromocion() {
        try {
            List<Promocion> lista = em.createQuery("SELECT p FROM Promocion p WHERE p.fecha= :fecha", Promocion.class).setParameter("fecha", new Date()).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    public List<Promocion> MostrarPromocionTodas() {
        try {
            List<Promocion> lista = em.createQuery("SELECT p FROM Promocion p", Promocion.class).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Reservas por fecha listo(Y)
    public List<Promocion> MostrarPromocionFecha(Date fecha) {
        try {
            String f = formatoDeFecha.format(fecha);
            List<Promocion> lista = em.createQuery("SELECT p FROM Promocion p WHERE p.fecha= :fecha", Promocion.class).setParameter("fecha", formatoDeFecha.parse(f)).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Promocion por Fecha");
            return null;
        }
    }

    public Promocion MostrarPromocionid(int id) {
        try {

            Promocion r = em.createQuery("SELECT p FROM Promocion p WHERE p.idPromocion= :id", Promocion.class).setParameter("id", id).getSingleResult();
            return r;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }
}
