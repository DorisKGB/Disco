package controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import modelo.Bodega;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Reserva;
import vista.Login;

public class CReserva {

    private EntityManager em = Coneccion.em;
    private EntityTransaction tx = em.getTransaction();
    Calendar calen = GregorianCalendar.getInstance();
    Date fecha = calen.getTime();
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
    String inicio = formatoDeFecha.format(fecha);
//metodo gurdar reserva  listo

    public int GuardarReserva(int idCliente, String tipo, String fechaReserva, double precio, String descripcion, String nombre) {
        try {
            tx.begin();
            Reserva re = new Reserva();
            re.setDescripcion(descripcion);
            re.setFechaReserva(formatoDeFecha.parse(fechaReserva));
            re.setInicioReserva(formatoDeFecha.parse(inicio));
            re.setTipo(tipo);
            re.setPrecio(precio);
            re.setEmpleado(em.find(Empleado.class, Login.SessionId));
            re.setCliente(em.find(Cliente.class, idCliente));
            em.persist(re);
            Producto producto = new CProducto().MostrarProductosNombre(nombre);
            producto.setcCantidad(producto.getcCantidad() + 1);
            producto.setPrecio(precio);
            em.merge(producto);
            em.flush();
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Verificar Datos");
            tx.rollback();
            return 0;
        }
    }

    public void ModifcarReserva(int idReserva, Date fecha, double precio, String tipo) {
        try {
             tx.begin();
        Reserva r = MostrarReservasid(idReserva);
        r.setFechaReserva(fecha);
        r.setPrecio(precio);
        Producto producto = new CProducto().MostrarProductosNombre(r.getTipo());
        producto.setcCantidad(producto.getcCantidad() - 1);
        em.merge(producto);
        r.setTipo(tipo);
        Producto p = new CProducto().MostrarProductosNombre(tipo);
        p.setcCantidad(producto.getcCantidad() + 1);
        p.setPrecio(precio);
        em.merge(p);
        em.merge(r);
        em.flush();
        JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            tx.rollback();
        }
       

    }

//Metod de Consultar en Reservas de todos los elemntos listo(Y)
    public List<Reserva> MostrarReservas() {
        try {
            List<Reserva> lista = em.createQuery("SELECT r FROM Reserva r WHERE r.fechaReserva> :fecha", Reserva.class).setParameter("fecha", new Date()).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Reservas por fecha listo(Y)
    public List<Reserva> MostrarReservasFecha(String fecha) {
        try {
            Date fechas = formatoDeFecha.parse(fecha);
            List<Reserva> lista = em.createQuery("SELECT r FROM Reserva r WHERE r.fechaReserva= :fecha", Reserva.class).setParameter("fecha", fechas).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Reserva por Fecha");
            return null;
        }
    }

    //Metod de Consultar en Reservas por cedula listo(Y)
    public List<Reserva> MostrarReservasCedula(String cedula) {
        try {
            Cliente c = new CCliente().BuscarClienteCedula(cedula);
            List<Reserva> lista = em.createQuery("SELECT r FROM Reserva r WHERE r.cliente= :idCliente", Reserva.class).setParameter("idCliente", em.find(Cliente.class, c.getIdCliente())).getResultList();
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique su Cedula");
            return null;
        }
    }

    //Metod de Consultar en Reservas por cedula listo(Y)
    public Reserva MostrarReservasid(int id) {
        try {

            Reserva r = em.createQuery("SELECT r FROM Reserva r WHERE r.idReserva= :id", Reserva.class).setParameter("id", id).getSingleResult();
            return r;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }

}
