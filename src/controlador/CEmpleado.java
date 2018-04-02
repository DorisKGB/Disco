package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import modelo.Empleado;

public class CEmpleado {

    private EntityManager em = Coneccion.em;
    private EntityTransaction tx = em.getTransaction();

    //Metodo de Guardar Empledo listo
    public void GuardarEmpleado(String apellido, String nombre, String contrasena, String email, String cedulaRuc, String direccion, String tipo, String telefono) {
        try {
            tx.begin();
            Empleado e = new Empleado();
            e.setApellido(apellido);
            e.setCedula(cedulaRuc);
            e.setDireccion(direccion);
            e.setCorreo(email);
            e.setNombre(nombre);
            e.setContrasena(contrasena);
            e.setTipo(tipo);
            e.setTelefono(telefono);
            em.persist(e);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cedula o Ruc Ya Se encuentra Ingresado");
            tx.rollback();
        }

    }

    //Metodo de Modificar Empleado(Cajero) Listo
    public void ModificarEmpleado(String contrasena, String correo, String direccion, String telefono, int idEmpleado) {
        try {
            tx.begin();
            Empleado e = ConsultarEmpleado(idEmpleado);
            e.setDireccion(direccion);
            e.setCorreo(correo);
            e.setContrasena(contrasena);
            e.setTelefono(telefono);
            em.merge(e);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Modificado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Verfique sus Datos");
            tx.rollback();
        }

    }

    //Metodo de Modificar Empleado(Admin) Listo
    public void ModificarEmpleado(String tipo, String nombre, String apellido, String cedula, String contrasena, String correo, String direccion, String telefono, int idEmpleado) {
        try {
            tx.begin();
            Empleado e = ConsultarEmpleado(idEmpleado);
            e.setDireccion(direccion);
            e.setCorreo(correo);
            e.setContrasena(contrasena);
            e.setTelefono(telefono);
            e.setApellido(apellido);
            e.setNombre(nombre);
            e.setTipo(tipo);
            em.merge(e);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Modificado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Verfique sus Datos");
            tx.rollback();
        }

    }

    public List<Empleado> MostrarEmpleado() {
        try {
            List<Empleado> lista = em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
        }
        return null;
    }
//Metodo de inciar sesion listo(Y)

    public Empleado ConsultarEmpleado(String login, String contrasena) {
        try {
            Empleado ee = em.createQuery("SELECT e FROM Empleado e WHERE e.cedula= :login and e.contrasena= :contra", Empleado.class).setParameter("login", login).setParameter("contra", contrasena).getSingleResult();
            return ee;
        } catch (Exception e) {
            System.out.println("No se encontro empleado");
        }
        return null;
    }

    public Empleado ConsultarEmpleadoCedula(String cedula) {
        try {
            Empleado ee = em.createQuery("SELECT e FROM Empleado e WHERE e.cedula= :cedula", Empleado.class).setParameter("cedula", cedula).getSingleResult();
            return ee;
        } catch (Exception e) {
            System.out.println("No se encontro empleado");
        }
        return null;
    }

    public Empleado ConsultarEmpleado(int idEmpleado) {
        try {
            Empleado ee = em.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado= :idEmpleado", Empleado.class).setParameter("idEmpleado", idEmpleado).getSingleResult();
            return ee;
        } catch (Exception e) {
            System.out.println("No se encontro Empleado");
        }
        return new Empleado();
    }

    public Empleado ConsultarEmpleado(String cedula) {
        try {
            Empleado ee = em.createQuery("SELECT e FROM Empleado e WHERE e.cedula= :cedula", Empleado.class).setParameter("cedula", cedula).getSingleResult();
            return ee;
        } catch (Exception e) {
            System.out.println("No se encontro Empleado");
        }
        return new Empleado();
    }

}
