package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Asistencia.class)
public abstract class Asistencia_ {

	public static volatile SingularAttribute<Asistencia, Date> fecha;
	public static volatile SingularAttribute<Asistencia, Empleado> empleado;
	public static volatile SingularAttribute<Asistencia, Integer> idAsistencia;

}

