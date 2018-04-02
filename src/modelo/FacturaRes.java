/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
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
import modelo.Factura;
import modelo.Reserva;

/**
 *
 * @author Victorjs
 */
@Entity
@Table(name = "facturaRes")
public class FacturaRes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFacturaRes;
    
    @Column(name = "cantidad",nullable = false)
    private int cantidad;
    @Column(name = "precioUnitario",nullable = false)
    private double precio;
    @Column(name = "precioTotal",nullable = false)
    private double precioTotal;

     @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFactura", nullable = false, referencedColumnName = "idFactura")
    private Factura factura;

     @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "idReserva", nullable =false, referencedColumnName = "idReserva")
    private  Reserva reserva;

    public int getIdFacturaRes() {
        return idFacturaRes;
    }

    public void setIdFacturaRes(int idFacturaRes) {
        this.idFacturaRes = idFacturaRes;
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

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
     
}



  
