package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, String> descripcion;
	public static volatile SingularAttribute<Producto, Date> fecha;
	public static volatile SingularAttribute<Producto, String> tipo;
	public static volatile SingularAttribute<Producto, Integer> bCantidad;
	public static volatile SingularAttribute<Producto, Double> precio;
	public static volatile SingularAttribute<Producto, Empleado> empleado;
	public static volatile SingularAttribute<Producto, Integer> idProducto;
	public static volatile SingularAttribute<Producto, String> nombre;
	public static volatile SingularAttribute<Producto, Integer> cCantidad;

}

