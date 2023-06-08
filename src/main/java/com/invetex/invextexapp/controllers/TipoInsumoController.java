package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.models.TipoInsumo;
import com.invetex.invextexapp.servicio.TipoInsumoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoInsumoController {

    @Autowired
    private TipoInsumoServicio tipoInsumoServicio;
    @RequestMapping(value = "obtenerTipoInsumos", method = RequestMethod.GET)
    public List<TipoInsumo> getTipoInsumo(){
        return tipoInsumoServicio.listarTipoInsumo();

    }

    @PostMapping (value = "guardarTipoInsumo")
    public String guardarTipoInsumo (@RequestBody TipoInsumo tipoInsumo){

        try{
            tipoInsumoServicio.guardarTipoInsumo(tipoInsumo);
            return "0";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping (value = "eliminarTipoInsumo")
    public String eliminarTipoInsumo (@RequestBody TipoInsumo tipoInsumo){
        try{
            tipoInsumoServicio.eliminarTipoInsumo(tipoInsumo);
            return "0";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @PutMapping (value = "actualizarTipoInsumo")
    public String actualizarTipoInsumo (@RequestBody TipoInsumo tipoInsumo){

        return tipoInsumoServicio.actualizarTipoInsumo(tipoInsumo);
    }

}
