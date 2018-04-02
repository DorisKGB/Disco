package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bodega.class)
public abstract class Bodega_ {

	public static volatile SingularAttribute<Bodega, String> descripcion;
	public static volatile SingularAttribute<Bodega, Double> precio;
	public static volatile SingularAttribute<Bodega, String> tipoPro;
	public static volatile SingularAttribute<Bodega, Empleado> empleado;
	public static volatile SingularAttribute<Bodega, Integer> idBodega;
	public static volatile SingularAttribute<Bodega, Integer> cantidad;
	public static volatile SingularAttribute<Bodega, String> nombre;

}

