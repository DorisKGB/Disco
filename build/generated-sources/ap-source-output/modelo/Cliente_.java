package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile ListAttribute<Cliente, Factura> listaFactura;
	public static volatile SingularAttribute<Cliente, Integer> idCliente;
	public static volatile SingularAttribute<Cliente, Empleado> empleado;
	public static volatile SingularAttribute<Cliente, String> cedula;
	public static volatile SingularAttribute<Cliente, String> apellido;
	public static volatile SingularAttribute<Cliente, String> correo;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile ListAttribute<Cliente, Reserva> listaReserva;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile SingularAttribute<Cliente, String> nombre;

}

