package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.models.Satelite;
import com.invetex.invextexapp.servicio.SateliteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SateliteController {


    @Autowired
    private SateliteServicio sateliteServicio;
    @RequestMapping(value = "obtenerSatelites", method = RequestMethod.GET)
    public List<Satelite> getSatelite(){
        return sateliteServicio.listarSatelites();

    }

    @PostMapping (value = "guardarSatelite")
    public String guardarSatelites (@RequestBody Satelite satelite){

        return sateliteServicio.guardarSatelite(satelite);
    }

    @DeleteMapping (value = "eliminarSatelite")
    public String eliminarSatelite (@RequestBody Satelite satelite){

        return sateliteServicio.eliminarSatelite(satelite);

    }

    @PutMapping (value = "actualizarSatelite")
    public String actualizarSatelite (@RequestBody Satelite satelite){

        return sateliteServicio.actualizarSatelite(satelite);
    }

}
