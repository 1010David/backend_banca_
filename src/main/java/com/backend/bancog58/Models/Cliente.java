package com.backend.bancog58.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    @Id
    @Column(name="id_cliente")
    private String id_cliente;

    @Column(name="nombre_cliente")
    private String nombre_cliente;

    @Column(name="clave_cliente")
    private String clave_cliente;

    public Cliente() {
        // Constructor vacío requerido por el framework
    }

    public Cliente(String id_cliente, String nombre_cliente, String clave_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.clave_cliente = clave_cliente;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getClave_cliente() {
        return clave_cliente;
    }

    public void setClave_cliente(String clave_cliente) {
        this.clave_cliente = clave_cliente;
    }

    @Override
    public String toString() {
        return "Cliente [clave_cliente=" + clave_cliente + ", id_cliente=" + id_cliente + ", nombre_cliente="
                + nombre_cliente + "]";
    }
}
