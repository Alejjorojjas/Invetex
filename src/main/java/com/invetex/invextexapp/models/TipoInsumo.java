package com.invetex.invextexapp.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name ="tipo_insumo")
public class TipoInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_insumo")
    private int idTipo;

    @Column(name = "nombre_tipo_insumo")
    private String nombreTipo;

    @Column(name = "descripcion_tipo_insumo")
    private String descripcionTipo;

    @Column(name = "codigo_tipo_insumo")
    private String codigoTipo;

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoInsumo that)) return false;
        return Objects.equals(nombreTipo, that.nombreTipo) && Objects.equals(descripcionTipo, that.descripcionTipo) && Objects.equals(codigoTipo, that.codigoTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreTipo, descripcionTipo, codigoTipo);
    }
}
