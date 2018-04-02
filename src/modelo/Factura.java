
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFactura;
    @Column(name = "precioNeto", nullable = false)
    private double precioNeto;
    @Column(name = "precioTotal", nullable = false)
    private double precioTotal;
    @Column(name = "estado", length = 15, nullable = false)
    private String estado;
    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
        
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="idEmpleado", nullable = true, referencedColumnName = "idEmpleado")
    private Empleado empleado;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable = false, referencedColumnName = "idCliente")
    private Cliente cliente;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(double precioNeto) {
        this.precioNeto = precioNeto;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public List<FacturaPro> getListaFacturaPro() {
        return listaFacturaPro;
    }

    public void setListaFacturaPro(List<FacturaPro> listaFacturaPro) {
        this.listaFacturaPro = listaFacturaPro;
    }
    
     @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FacturaPro> listaFacturaPro= new ArrayList<FacturaPro>();
}
