package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.imp.SateliteImp;
import com.invetex.invextexapp.models.Satelite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SateliteServicio {

    @Autowired
    private SateliteImp sateliteImp;
    public List <Satelite> listarSatelites(){
        return sateliteImp.listarSatelites();
    }

    public String guardarSatelite(Satelite satelite){

        return sateliteImp.guardarSatelite(satelite);
    }

    public String eliminarSatelite(Satelite satelite) {

        return sateliteImp.eliminarSatelite(satelite);
    }

    public String actualizarSatelite(Satelite satelite) {

        return sateliteImp.actualizarSatelite(satelite);

    }
}
