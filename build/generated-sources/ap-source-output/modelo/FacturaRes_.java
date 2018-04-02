package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacturaRes.class)
public abstract class FacturaRes_ {

	public static volatile SingularAttribute<FacturaRes, Double> precio;
	public static volatile SingularAttribute<FacturaRes, Factura> factura;
	public static volatile SingularAttribute<FacturaRes, Integer> idFacturaRes;
	public static volatile SingularAttribute<FacturaRes, Integer> cantidad;
	public static volatile SingularAttribute<FacturaRes, Double> precioTotal;
	public static volatile SingularAttribute<FacturaRes, Reserva> reserva;

}

