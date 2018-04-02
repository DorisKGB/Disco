package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empleado.class)
public abstract class Empleado_ {

	public static volatile SingularAttribute<Empleado, String> tipo;
	public static volatile SingularAttribute<Empleado, String> cedula;
	public static volatile SingularAttribute<Empleado, String> direccion;
	public static volatile ListAttribute<Empleado, Cliente> listaClientes;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile ListAttribute<Empleado, Bodega> listaProductoB;
	public static volatile ListAttribute<Empleado, Factura> listaFacturas;
	public static volatile ListAttribute<Empleado, Reserva> listaReservas;
	public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
	public static volatile SingularAttribute<Empleado, String> apellido;
	public static volatile SingularAttribute<Empleado, String> correo;
	public static volatile ListAttribute<Empleado, Producto> listaProducto;
	public static volatile SingularAttribute<Empleado, String> contrasena;
	public static volatile SingularAttribute<Empleado, String> telefono;
	public static volatile ListAttribute<Empleado, Asistencia> listaAsistencias;

}

