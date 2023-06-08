package com.invetex.invextexapp.models;


import jakarta.persistence.*;

@Entity
@Table(name ="satelite")
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_satelite")
    private int idSatelite;

    @Column(name = "nombre_satelite")
    private String nombreSatelite;

    @Column(name = "correo_satelite")
    private String correoSatelite;

    @Column(name = "telefono_satelite")
    private String telefonoSatelite;

    @Column(name = "direccion_satelite")
    private String direccionSatelite;

    public int getIdSatelite() {
        return idSatelite;
    }

    public void setIdSatelite(int idSatelite) {
        this.idSatelite = idSatelite;
    }

    public String getNombreSatelite() {
        return nombreSatelite;
    }

    public void setNombreSatelite(String nombreSatelite) {
        this.nombreSatelite = nombreSatelite;
    }

    public String getCorreoSatelite() {
        return correoSatelite;
    }

    public void setCorreoSatelite(String correoSatelite) {
        this.correoSatelite = correoSatelite;
    }

    public String getTelefonoSatelite() {
        return telefonoSatelite;
    }

    public void setTelefonoSatelite(String telefonoSatelite) {
        this.telefonoSatelite = telefonoSatelite;
    }

    public String getDireccionSatelite() {
        return direccionSatelite;
    }

    public void setDireccionSatelite(String direccionSatelite) {
        this.direccionSatelite = direccionSatelite;
    }
}
