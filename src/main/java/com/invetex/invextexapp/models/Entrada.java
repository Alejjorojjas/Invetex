package com.invetex.invextexapp.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name ="entrada")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private int idEntrada;

    @Column(name = "fecha_entrada")
    private String fechaEntrada;

    @Column(name = "valor_entrada")
    private String valorEntrada;

    @Column(name = "cantidad_entrada")
    private String cantidadEntrada;

    @Column(name = "descripcion_entrada")
    private String descripcionEntrada;

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(String valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(String cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public String getDescripcionEntrada() {
        return descripcionEntrada;
    }

    public void setDescripcionEntrada(String descripcionEntrada) {
        this.descripcionEntrada = descripcionEntrada;
    }
}