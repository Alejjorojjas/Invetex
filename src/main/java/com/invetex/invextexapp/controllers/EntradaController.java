package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.models.Entrada;
import com.invetex.invextexapp.servicio.EntradaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EntradaController {


    @Autowired
    private EntradaServicio entradaServicio;
    @RequestMapping(value = "obtenerEntrada", method = RequestMethod.GET)
    public List<Entrada> getEntrada(){
        return entradaServicio.listarEntrada();

    }

    @PostMapping (value = "guardarEntrada")
    public String guardarEntrada (@RequestBody Entrada entrada){

        return entradaServicio.guardarEntrada(entrada);
    }

    @DeleteMapping (value = "eliminarEntrada")
    public String eliminarEntrada (@RequestBody Entrada entrada){

        return entradaServicio.eliminarEntrada(entrada);

    }

    @PutMapping (value = "actualizarEntrada")
    public String actualizarEntrada (@RequestBody Entrada entrada){

        return entradaServicio.actualizarEntrada(entrada);
    }

}
