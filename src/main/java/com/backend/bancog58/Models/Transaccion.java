package com.backend.bancog58.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="transaccion")
public class Transaccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_transaccion")
    private int id_transaccion;

    @Column(name="fecha_transaccion")
    private Date fecha_transaccion;

    @Column(name="valor_transaccion")
    private double valor_transaccion;

    @Column(name="tipo_transaccion")
    private String tipo_transaccion;

    @ManyToOne
    @JoinColumn(name="id_cuenta")
    private Cuenta cuenta;

    public Transaccion() {
        // Constructor vacío requerido por el framework
    }

    public Transaccion(int id_transaccion, Date fecha_transaccion, double valor_transaccion, String tipo_transaccion, Cuenta cuenta) {
        this.id_transaccion = id_transaccion;
        this.fecha_transaccion = fecha_transaccion;
        this.valor_transaccion = valor_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.cuenta = cuenta;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public double getValor_transaccion() {
        return valor_transaccion;
    }

    public void setValor_transaccion(double valor_transaccion) {
        this.valor_transaccion = valor_transaccion;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Transaccion [id_transaccion=" + id_transaccion + ", fecha_transaccion=" + fecha_transaccion
                + ", valor_transaccion=" + valor_transaccion + ", tipo_transaccion=" + tipo_transaccion + ", cuenta="
                + cuenta + "]";
    }
}
