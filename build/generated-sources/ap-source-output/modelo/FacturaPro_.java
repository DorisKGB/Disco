package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacturaPro.class)
public abstract class FacturaPro_ {

	public static volatile SingularAttribute<FacturaPro, Double> precio;
	public static volatile SingularAttribute<FacturaPro, Factura> factura;
	public static volatile SingularAttribute<FacturaPro, Integer> idFacturaPro;
	public static volatile SingularAttribute<FacturaPro, Integer> cantidad;
	public static volatile SingularAttribute<FacturaPro, Producto> producto;
	public static volatile SingularAttribute<FacturaPro, Double> precioTotal;

}

