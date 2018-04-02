package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import modelo.Asistencia;
import modelo.Caja;

import modelo.Empleado;
import modelo.Factura;

import vista.Login;

public class CControlD {

    private EntityManager em = Coneccion.em;
    private EntityTransaction tx = em.getTransaction();
    Calendar calen = GregorianCalendar.getInstance();
    Date fecha = calen.getTime();
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoDeFecha1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//metodo gurdar asistencia  listo
    public int GuardarAsistencia(int idCliente) {
        try {
            tx.begin();
            Asistencia a = new Asistencia();
            a.setFecha(fecha);
            a.setEmpleado(em.find(Empleado.class, idCliente));
            em.persist(a);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Verificar Datos");
            tx.rollback();
            return 0;
        }

    }
    
    public int CierreCaja(String disco,String karaoke,String canciones,double total,Date cierre,String descripcion) {
        try {
            tx.begin();
            Caja a = new Caja();
            a.setFecha(cierre);
            a.setCanciones(canciones);
            a.setEntradasDisco(disco);
            a.setEntradasKaraoke(karaoke);
            a.setObservaciones(descripcion);
            a.setPrecioTotal(total);
            em.persist(a);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Solo se Permite un Cierre de Caja Diario");
            tx.rollback();
            return 0;
        }

    }
    
  
    //Metod de Consultar en Asistencias por fecha listo(Y)
    public List<Asistencia> MostrarAsistenciasFecha(Date fecha) {
        String f=formatoDeFecha.format(fecha)+" 11:00:00";
        try {
            List<Asistencia> lista = em.createQuery("SELECT a FROM Asistencia a WHERE a.fecha> :fecha", Asistencia.class).setParameter("fecha", formatoDeFecha1.parse(f)).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Asistencias por Fecha");
            return null;
        }
    }
    
    public List<Asistencia> MostrarAsistencias() {
        try {
            List<Asistencia> lista = em.createQuery("SELECT a FROM Asistencia a", Asistencia.class).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro");
            return null;
        }
    }
    
      public List<Factura> MostrarFacturasCaja(Date fecha) {
          System.out.println(fecha);
       String f=formatoDeFecha.format(fecha)+" 11:00:00";
        try {
            List<Factura> lista = em.createQuery("SELECT f FROM Factura f WHERE f.fecha>:fecha", Factura.class).setParameter("fecha",formatoDeFecha1.parse(f)).getResultList();

            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro");
            return null;
        }
    }
    
 public List<Caja> MostrarCajaFecha(Date fecha) {
        String f=formatoDeFecha.format(fecha);
        try {
            List<Caja> lista = em.createQuery("SELECT c FROM Caja c WHERE c.fecha= :fecha", Caja.class).setParameter("fecha", formatoDeFecha.parse(f)).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Cajas por Fecha");
            return null;
        }
    }
    
    public List<Caja> MostrarCaja() {
        try {
            List<Caja> lista = em.createQuery("SELECT c FROM Caja c", Caja.class).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro");
            return null;
        }
    }
}
