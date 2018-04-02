package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, String> descripcion;
	public static volatile SingularAttribute<Reserva, Cliente> cliente;
	public static volatile SingularAttribute<Reserva, String> tipo;
	public static volatile SingularAttribute<Reserva, Double> precio;
	public static volatile SingularAttribute<Reserva, Date> inicioReserva;
	public static volatile SingularAttribute<Reserva, Empleado> empleado;
	public static volatile SingularAttribute<Reserva, Integer> idReserva;
	public static volatile SingularAttribute<Reserva, Date> fechaReserva;

}

