package com.backend.bancog58.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {
    @Id
    @Column(name = "id_administrador")
    private String id_administrador;

    @Column(name = "nombre_administrador")
    private String nombre_administrador;

    @Column(name = "clave_administrador")
    private String clave_administrador;

    public Administrador() {
        // Constructor vacío requerido por JPA
    }

    public Administrador(String id_administrador, String nombre_administrador, String clave_administrador) {
        this.id_administrador = id_administrador;
        this.nombre_administrador = nombre_administrador;
        this.clave_administrador = clave_administrador;
    }

    // Getters y setters
    public String getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(String id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    public String getClave_administrador() {
        return clave_administrador;
    }

    public void setClave_administrador(String clave_administrador) {
        this.clave_administrador = clave_administrador;
    }

    @Override
    public String toString() {
        return "Administrador [id_administrador=" + id_administrador + ", nombre_administrador=" + nombre_administrador
                + ", clave_administrador=" + clave_administrador + "]";
    }
}
