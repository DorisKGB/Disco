
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
@Table(name = "reserva")
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReserva;
    @Column(name ="inicioReserva",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioReserva;
    @Column(name ="fechaReserva",nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaReserva;
    @Column(name = "tipo",length = 40,nullable = false)
    private String tipo;
    @Column(name = "precio",nullable = false)
    private double precio;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="idEmpleado", nullable = false, referencedColumnName = "idEmpleado")
    private Empleado empleado;   
    
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable = false, referencedColumnName = "idCliente")
    private Cliente cliente;     

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public Date getInicioReserva() {
        return inicioReserva;
    }

    public void setInicioReserva(Date inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
