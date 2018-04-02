package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Caja.class)
public abstract class Caja_ {

	public static volatile SingularAttribute<Caja, Date> fecha;
	public static volatile SingularAttribute<Caja, String> canciones;
	public static volatile SingularAttribute<Caja, String> entradasDisco;
	public static volatile SingularAttribute<Caja, String> observaciones;
	public static volatile SingularAttribute<Caja, String> entradasKaraoke;
	public static volatile SingularAttribute<Caja, Double> precioTotal;
	public static volatile SingularAttribute<Caja, Integer> idCaja;

}

