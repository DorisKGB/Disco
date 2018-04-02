

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    @Column(name = "tipo",length = 40,nullable = false)
    private String tipo;
    @Column(name = "cCantidad",nullable = true)
    private int cCantidad;
    @Column(name = "bCantidad",nullable = true)
    private int bCantidad;
    
    @Column(name = "precio",nullable = false)
    private double precio;
    @Column(name = "nombre",length = 30,nullable = false)
    private String nombre;  
    
    @Column(name ="fecha",nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name="descripcion",length = 50,nullable = false)
    private String descripcion; 
    
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="idEmpleado", nullable = false, referencedColumnName = "idEmpleado")
    private Empleado empleado;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
 

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getcCantidad() {
        return cCantidad;
    }

    public void setcCantidad(int cCantidad) {
        this.cCantidad = cCantidad;
    }

    public int getbCantidad() {
        return bCantidad;
    }

    public void setbCantidad(int bCantidad) {
        this.bCantidad = bCantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}