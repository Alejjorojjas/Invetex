package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.models.Salida;
import com.invetex.invextexapp.servicio.SalidaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalidaController {


    @Autowired
    private SalidaServicio salidaServicio;
    @RequestMapping(value = "obtenerSalida", method = RequestMethod.GET)
    public List<Salida> getSalida(){
        return salidaServicio.listarSalida();

    }

    @PostMapping (value = "guardarSalida")
    public String guardarSalida (@RequestBody Salida salida){

        return salidaServicio.guardarSalida(salida);
    }

    @DeleteMapping (value = "eliminarSalida")
    public String eliminarSalida (@RequestBody Salida salida){

        return salidaServicio.eliminarSalida(salida);

    }

    @PutMapping (value = "actualizarSalida")
    public String actualizarSalida (@RequestBody Salida salida){

        return salidaServicio.actualizarSalida(salida);
    }

}
