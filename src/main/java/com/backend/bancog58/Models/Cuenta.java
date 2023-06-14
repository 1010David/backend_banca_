package com.backend.bancog58.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable {
    @Id
    @Column(name="id_cuenta")
    private String id_cuenta;

    @Column(name="fecha_apertura")
    private Date fecha_apertura;

    @Column(name="saldo_cuenta")
    private double saldo_cuenta;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Cuenta() {
        // Constructor vacío requerido por el framework
    }

    public Cuenta(String id_cuenta, Date fecha_apertura, double saldo_cuenta, Cliente cliente) {
        this.id_cuenta = id_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo_cuenta = saldo_cuenta;
        this.cliente = cliente;
    }

    public String getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(String id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public double getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cuenta [cliente=" + cliente + ", fecha_apertura=" + fecha_apertura + ", id_cuenta=" + id_cuenta
                + ", saldo_cuenta=" + saldo_cuenta + "]";
    }
}
