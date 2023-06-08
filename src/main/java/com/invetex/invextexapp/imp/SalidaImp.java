package com.invetex.invextexapp.imp;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.Salida;
import com.invetex.invextexapp.models.TipoInsumo;
import com.invetex.invextexapp.repository.ClienteRepository;
import com.invetex.invextexapp.repository.SalidaRepository;
import com.invetex.invextexapp.repository.TipoInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalidaImp {

    @Autowired
    private SalidaRepository salidaRepository;
    public List<Salida> listarSalida(){
        return salidaRepository.findAll();
    }

    public String guardarSalida(Salida salida){
        try {
            salidaRepository.save(salida);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public String eliminarSalida(Salida salida) {

        try {
            salidaRepository.delete(salida);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    public String actualizarSalida(Salida salida) {

        try {
            salidaRepository.save(salida);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
}
