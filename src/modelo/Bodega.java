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

/**
 *
 * @author Doris
 */
@Entity
@Table(name ="bodega" )
public class Bodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBodega;
    @Column(name = "tipoPro",length = 30,nullable = false)
    private String tipoPro;
    @Column(name = "cantidad",nullable = false)
    private int cantidad;
    @Column(name = "precio",nullable = false)
    private double precio;
    @Column(name = "nombre",length = 30,nullable = false)
    private String nombre;
    
    @Column(name = "descripcion",length = 255,nullable = false)
    private String descripcion;

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="idEmpleado", nullable = false, referencedColumnName = "idEmpleado")
    private Empleado empleado;



    public String getTipoPro() {
        return tipoPro;
    }

    public void setTipoPro(String tipoPro) {
        this.tipoPro = tipoPro;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
}
