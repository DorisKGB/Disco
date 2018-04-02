/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Doris
 */
@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmpleado;
    @Column(name = "nombre", length = 25,nullable = false)
    private String nombre;
        @Column(name="apellido", length = 30,nullable=false)
    private String apellido;
    @Column(name="tipo", length = 30,nullable=false)
    private String tipo;
    @Column(name="contrasena", length = 15,nullable = true)
    private String contrasena;
    @Column(name = "telefono",length = 10,nullable = false)
    private String telefono;
    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;
    @Column(name="correo",length = 50,nullable = true)
    private String correo;
    @Column(name = "cedula",length = 11,nullable = false, unique = true)
    private String cedula;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Producto> listaProducto= new ArrayList<Producto>();

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

 

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Asistencia> getListaAsistencias() {
        return listaAsistencias;
    }

    public void setListaAsistencias(List<Asistencia> listaAsistencias) {
        this.listaAsistencias = listaAsistencias;
    }

    public List<Bodega> getListaProductoB() {
        return listaProductoB;
    }

    public void setListaProductoB(List<Bodega> listaProductoB) {
        this.listaProductoB = listaProductoB;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Cliente> listaClientes= new ArrayList<Cliente>();
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Asistencia> listaAsistencias= new ArrayList<Asistencia>();
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Bodega> listaProductoB= new ArrayList<Bodega>();
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Factura> listaFacturas= new ArrayList<Factura>();
    
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reserva> listaReservas= new ArrayList<Reserva>();
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}
