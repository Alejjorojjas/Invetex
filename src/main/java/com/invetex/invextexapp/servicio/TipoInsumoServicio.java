package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.imp.ClienteImp;
import com.invetex.invextexapp.imp.TipoInsumoImp;
import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.TipoInsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoInsumoServicio {

    @Autowired
    private TipoInsumoImp tipoInsumoImp;
    public List<TipoInsumo> listarTipoInsumo(){
        return tipoInsumoImp.listarTipoInsumo();
    }

    public String guardarTipoInsumo(TipoInsumo tipoInsumo){

        return tipoInsumoImp.guardarTipoInsumo(tipoInsumo);
    }

    public String eliminarTipoInsumo(TipoInsumo tipoInsumo) {

        return tipoInsumoImp.eliminarTipoInsumo(tipoInsumo);
    }

    public String actualizarTipoInsumo(TipoInsumo tipoInsumo) {

        return tipoInsumoImp.actualizarTipoInsumo(tipoInsumo);

    }
}
