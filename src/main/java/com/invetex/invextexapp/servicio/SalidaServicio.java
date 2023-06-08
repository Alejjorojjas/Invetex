package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.imp.SalidaImp;
import com.invetex.invextexapp.models.Salida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalidaServicio {

    @Autowired
    private SalidaImp salidaImp;
    public List<Salida> listarSalida(){
        return salidaImp.listarSalida();
    }

    public String guardarSalida(Salida salida){

        return salidaImp.guardarSalida(salida);
    }

    public String eliminarSalida(Salida salida) {

        return salidaImp.eliminarSalida(salida);
    }

    public String actualizarSalida(Salida salida) {

        return salidaImp.actualizarSalida(salida);

    }
}
