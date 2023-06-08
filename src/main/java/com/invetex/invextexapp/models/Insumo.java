package com.invetex.invextexapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name ="insumo")
public class Insumo {

    @Id
    @Column(name = "id_insumo")
    private int idInsumo;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "nombre_insumo")
    private String nombreInsumo;

    @Column(name = "descripcion_insumo")
    private String descripcionInsumo;

    @Column(name = "precio_unitario_insumo")
    private float precioUnitario;

    @Column(name = "cantidad_insumo")
    private int cantidadInsumo ;

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insumo insumo)) return false;
        return idInsumo == insumo.idInsumo && Float.compare(insumo.precioUnitario, precioUnitario) == 0 && cantidadInsumo == insumo.cantidadInsumo && Objects.equals(referencia, insumo.referencia) && Objects.equals(nombreInsumo, insumo.nombreInsumo) && Objects.equals(descripcionInsumo, insumo.descripcionInsumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInsumo, referencia, nombreInsumo, descripcionInsumo, precioUnitario, cantidadInsumo);
    }
}

