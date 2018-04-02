package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Caja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCaja;

    @Column(name = "entradasDisco", length = 100, nullable = false)
    private String entradasDisco;

    @Column(name = "entradasKaraoke", length = 100, nullable = false)
    private String entradasKaraoke;

    @Column(name = "canciones", length = 100, nullable = false)
    private String canciones;

    @Column(name = "precioTotal", nullable = false)
    private double precioTotal;

    @Column(name = "observaciones", length = 100, nullable = false)
    private String observaciones;
    
    @Column(name = "fecha", nullable = false, unique = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getEntradasDisco() {
        return entradasDisco;
    }

    public void setEntradasDisco(String entradasDisco) {
        this.entradasDisco = entradasDisco;
    }

    public String getEntradasKaraoke() {
        return entradasKaraoke;
    }

    public void setEntradasKaraoke(String entradasKaraoke) {
        this.entradasKaraoke = entradasKaraoke;
    }

    public String getCanciones() {
        return canciones;
    }

    public void setCanciones(String canciones) {
        this.canciones = canciones;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


}
