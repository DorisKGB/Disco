package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Double> precioNeto;
	public static volatile SingularAttribute<Factura, Date> fecha;
	public static volatile SingularAttribute<Factura, Cliente> cliente;
	public static volatile SingularAttribute<Factura, String> estado;
	public static volatile SingularAttribute<Factura, Empleado> empleado;
	public static volatile SingularAttribute<Factura, Integer> idFactura;
	public static volatile ListAttribute<Factura, FacturaPro> listaFacturaPro;
	public static volatile SingularAttribute<Factura, Double> precioTotal;

}

