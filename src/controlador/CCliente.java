package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Empleado;
import vista.Login;

public class CCliente {

    private EntityManager em = Coneccion.em;
    private EntityTransaction tx = em.getTransaction();
//METODO DE GUARDAR LOS CLIENTES LISTO(y)
    public int GuardarCliente(String apellido, String nombre, String correo, String rucedula, String direccion, String telefono) {
        try {
            tx.begin();
            Cliente c = new Cliente();
            c.setApellido(apellido);
            c.setCedula(rucedula);
            c.setDireccion(direccion);
            c.setCorreo(correo);
            c.setNombre(nombre);
            c.setTelefono(telefono);
            c.setEmpleado(em.find(Empleado.class, Login.SessionId));
            em.persist(c);
            em.flush();
            tx.commit();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ruc o Cedula Ya Registrados");
            tx.rollback();
            return 0;
        }
    }

    public void ModificarCliente(String nombre, String apellido, String correo, String direccion, String telefono, int idCliente) {
        try {
        tx.begin();
        Cliente c = BuscarClienteFactura(idCliente);
        c.setApellido(apellido);
        c.setDireccion(direccion);
        c.setCorreo(correo);
        c.setNombre(nombre);
        c.setTelefono(telefono);
        em.merge(c);
        tx.commit();
         JOptionPane.showMessageDialog(null, "Modificado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: Verificar Datos");
            tx.rollback();
        }
       
    }

    public List<Cliente> MostrarCliente() {
        try {
            List<Cliente> lista = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("No se encontro Elementos");
        }
        return null;
    }

    public Cliente BuscarClienteCedula(String cedula) {
        try {
            Cliente c = em.createQuery("SELECT c FROM Cliente c WHERE c.cedula= :cedula", Cliente.class).setParameter("cedula", cedula).getSingleResult();
            System.out.println(c.getNombre());
            return c;
        } catch (Exception e) {
            System.out.println("No se encontro Cliente");
        }
        return null;
    }

    public Cliente BuscarClienteFactura(int idCliente) {
        try {
            Cliente c = em.createQuery("SELECT c FROM Cliente c WHERE c.idCliente= :idCliente", Cliente.class).setParameter("idCliente", idCliente).getSingleResult();
            return c;
        } catch (Exception e) {
            System.out.println("No se encontro Cliente");
        }
        return null;
    }

    public void ConsultarCliente(String login, String contrasena) {
        List<Cliente> lista = em.createNamedQuery("Cliente.Todo", Cliente.class).getResultList();
        for (Cliente cc : lista) {
            System.out.println(cc.getApellido());
            System.out.println(cc.getCedula());
        }
    }

}
