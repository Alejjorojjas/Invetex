package com.invetex.invextexapp.imp;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.TipoInsumo;
import com.invetex.invextexapp.repository.ClienteRepository;
import com.invetex.invextexapp.repository.TipoInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoInsumoImp {

    @Autowired
    private TipoInsumoRepository tipoInsumoRepository;
    public List<TipoInsumo> listarTipoInsumo(){
        return tipoInsumoRepository.findAll();
    }

    public String guardarTipoInsumo(TipoInsumo tipoInsumo){
        try {
            tipoInsumoRepository.save(tipoInsumo);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public String eliminarTipoInsumo(TipoInsumo tipoInsumo) {

        try {
            tipoInsumoRepository.delete(tipoInsumo);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    public String actualizarTipoInsumo(TipoInsumo tipoInsumo) {

        try {
            tipoInsumoRepository.save(tipoInsumo);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
}
