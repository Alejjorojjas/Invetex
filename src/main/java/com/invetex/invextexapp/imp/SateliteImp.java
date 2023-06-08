
package com.invetex.invextexapp.imp;

import com.invetex.invextexapp.models.Satelite;
import com.invetex.invextexapp.repository.SateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SateliteImp {

    @Autowired
    private SateliteRepository sateliteRepository;
    public List<Satelite> listarSatelites(){
        return sateliteRepository.findAll();
    }

    public String guardarSatelite(Satelite satelite){
        try {
            sateliteRepository.save(satelite);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public String eliminarSatelite(Satelite satelite) {

        try {
            sateliteRepository.deleteById(Long.valueOf(satelite.getIdSatelite()));
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    public String actualizarSatelite(Satelite satelite) {

        try {
            sateliteRepository.save(satelite);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
}
