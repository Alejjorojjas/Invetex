package com.invetex.invextexapp.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name ="salida")
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida")
    private int idSalida;

    @Column(name = "fecha_salida")
    private String fechaSalida;

    @Column(name = "valor_salida")
    private String valorSalida;

    @Column(name = "cantidad_salida")
    private String cantidadSalida;

    @Column(name = "descripcion_salida")
    private String descripcionSalida;

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(String valorSalida) {
        this.valorSalida = valorSalida;
    }

    public String getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(String cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public String getDescripcionSalida() {
        return descripcionSalida;
    }

    public void setDescripcionSalida(String descripcionSalida) {
        this.descripcionSalida = descripcionSalida;
    }
}