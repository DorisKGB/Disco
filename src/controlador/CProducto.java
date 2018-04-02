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
import modelo.Empleado;
import modelo.Producto;
import vista.Login;

public class CProducto {

    private EntityManager em = Coneccion.em;
    private EntityTransaction tx = em.getTransaction();
    Calendar calen = GregorianCalendar.getInstance();
    Date fecha = calen.getTime();
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
    String inicio = formatoDeFecha.format(fecha);
//metodo gurdar producto en bodega  listo(Y)

    public int GuardarProducto(String tipo, String nombre, double precio, int cantidad, String descripcion) {
        try {
            tx.begin();
            Bodega bodega = new Bodega();
            bodega.setNombre(nombre);
            bodega.setCantidad(cantidad);
            bodega.setTipoPro(tipo);
            bodega.setPrecio(precio);
            bodega.setDescripcion(descripcion);
            bodega.setEmpleado(em.find(Empleado.class, Login.SessionId));
            em.persist(bodega);
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setbCantidad(0);
            producto.setcCantidad(0);
            producto.setTipo(tipo);
            producto.setPrecio(precio);
            producto.setFecha(fecha);
            producto.setDescripcion(descripcion);
            producto.setEmpleado(em.find(Empleado.class, Login.SessionId));
            em.persist(producto);
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

    public int GuardarPromocion(String tipo, String nombre, double precio, int cantidad, String descripcion) {
        try {
            tx.begin();
            Bodega bodega = new Bodega();
            bodega.setNombre(nombre);
            bodega.setCantidad(cantidad);
            bodega.setTipoPro(tipo);
            bodega.setPrecio(precio);
            bodega.setDescripcion(descripcion);
            bodega.setEmpleado(em.find(Empleado.class, Login.SessionId));
            em.persist(bodega);
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setbCantidad(0);
            producto.setcCantidad(cantidad);
            producto.setTipo(tipo);
            producto.setPrecio(precio);
            producto.setFecha(fecha);
            producto.setDescripcion(descripcion);
            producto.setEmpleado(em.find(Empleado.class, Login.SessionId));
            em.persist(producto);
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

//Entrega de productos, resta y suma de contidades listo(y)
    public void EntregarCantidadProducto(int cantidad, int idProducto, String tipo) {
        try {
            tx.begin();
            Producto producto = MostrarProductosId(idProducto);
            Bodega bodega = MostrarBodegaId(idProducto);
            if ("Bartman".equals(tipo)) {
                System.out.println("Entrega Bartman");
                if (cantidad > producto.getcCantidad()) {
                    JOptionPane.showMessageDialog(null, "!Stock Insuficiente!, DISPONIBLE EN CAJA: " + producto.getcCantidad());
                } else {

                    producto.setcCantidad(producto.getcCantidad() - cantidad);
                    producto.setbCantidad(cantidad);
                    em.merge(producto);
                }
            } else {
                System.out.println("Entrega Caja");
                if (cantidad > bodega.getCantidad()) {
                    JOptionPane.showMessageDialog(null, "!Stock Insuficiente!, DISPONIBLE EN BODEGA: " + bodega.getCantidad());
                } else {
                    bodega.setCantidad(bodega.getCantidad() - cantidad);
                    em.merge(bodega);
                    producto.setcCantidad(producto.getcCantidad() + cantidad);
                    producto.setFecha(new Date());
                    em.merge(producto);
                }
            }
            tx.commit();
            // }
        } catch (Exception e) {
            tx.rollback();
        }

    }

    //descuenta la cantidad del producto vendida
    public void ProductoVendido(int cantidad, int idProducto) {
        try {
            tx.begin();
            Producto producto = MostrarProductosId(idProducto);

            if ("Coctel".equals(producto.getTipo()) || "Jarra".equals(producto.getTipo())) {
                producto.setcCantidad(producto.getcCantidad());
            } else {
                producto.setcCantidad(producto.getcCantidad() - cantidad);
            }

            em.merge(producto);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            tx.rollback();
        }

    }

    public void AgregarCantidad(int cantidad, int idProducto) {
        try {
            tx.begin();
            Bodega b = MostrarBodegaId(idProducto);
            b.setCantidad(b.getCantidad() + cantidad);
            em.merge(b);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

    }

//Metod de Consultar en Bodega de todos los elemntos listo(Y)
    public List<Bodega> MostrarProductoBodega() {
        try {
            List<Bodega> lista = em.createQuery("SELECT pb FROM Bodega pb WHERE pb.tipoPro!= :tipo", Bodega.class).setParameter("tipo", "Reserva").getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Productos en Caja de todos los elemntos listo(Y)
    public List<Producto> MostrarProductoCaja() {
        try {
            List<Producto> lista = em.createQuery("SELECT p FROM Producto p WHERE p.tipo!= :tipo", Producto.class).setParameter("tipo", "Reserva").getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Bodega el producto por su codigo
    public List<Bodega> MostrarProductoBodegaCodigo(int codigo) {
        try {
            List<Bodega> lista = em.createQuery("SELECT pb FROM Bodega pb WHERE pb.idBodega= :codigo", Bodega.class).setParameter("codigo", codigo).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    public Bodega MostrarBodegaCodigo(int codigo) {
        try {
            Bodega b = em.createQuery("SELECT pb FROM Bodega pb WHERE pb.idBodega= :codigo", Bodega.class).setParameter("codigo", codigo).getSingleResult();
            return b;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Productos en Caja el producto por su codigo
    public Producto MostrarProductoCajaCodigo(int codigo) {
        System.out.println(codigo);
        try {
            Producto lista = em.createQuery("SELECT p FROM Producto p WHERE p.idProducto= :codigo", Producto.class).setParameter("codigo", codigo).getSingleResult();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Bodega el producto por su Tipo
    public List<Bodega> MostrarProductoBodegaTipo(String tipo) {
        try {
            List<Bodega> lista = em.createQuery("SELECT pb FROM Bodega pb WHERE pb.tipoPro= :tipo", Bodega.class).setParameter("tipo", tipo).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Metod de Consultar en Caja el producto por su Tipo
    public List<Producto> MostrarProductoCajaTipo(String tipo) {
        try {
            List<Producto> lista = em.createQuery("SELECT p FROM Producto p WHERE p.tipo= :tipo", Producto.class).setParameter("tipo", tipo).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

//Listo mostrar productos id 
    public Producto MostrarProductosId(int idProducto) {
        System.out.println("entress");
        try {
            Producto p = em.createQuery("SELECT p FROM Producto p WHERE p.idProducto= :idProducto", Producto.class).setParameter("idProducto", idProducto).getSingleResult();
            return p;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    //Listo mostrar productos id 
    public Producto MostrarProductosNombre(String nombre) {
        System.out.println("entress");
        try {
            Producto p = em.createQuery("SELECT p FROM Producto p WHERE p.nombre= :nombre", Producto.class).setParameter("nombre", nombre).getSingleResult();
            return p;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }
//listo mostrar productos en bodega

    public Bodega MostrarBodegaId(int idProducto) {
        try {
            Bodega p = em.createQuery("SELECT pb FROM Bodega pb WHERE pb.idBodega= :idProducto", Bodega.class).setParameter("idProducto", idProducto).getSingleResult();
            return p;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
            return null;
        }
    }

    public int ModificarProducto(int cantidad, int idProducto, String tipo, double precio, String nombre, String descripcion) {
        try {
            tx.begin();
            Producto p = MostrarProductosId(idProducto);
            Bodega bodega = MostrarBodegaId(idProducto);
            bodega.setCantidad(cantidad);
            bodega.setNombre(nombre);
            bodega.setDescripcion(descripcion);
            bodega.setPrecio(precio);
            bodega.setTipoPro(tipo);
            em.merge(bodega);

            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setTipo(tipo);

            em.merge(p);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Modificado con Exito");
            return 1;
        } catch (Exception e) {
            tx.rollback();
            return 0;
        }
    }

}
