package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.Pojo.InsumoPojo;
import com.invetex.invextexapp.Pojo.InsumoPojoImp;
import com.invetex.invextexapp.models.Insumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InsumoController{
    @Autowired
    private InsumoPojo insumoPojo;
    @RequestMapping(value = "obtenerInsumos", method = RequestMethod.GET)
    public List<Insumo> getInsumos(){
        return insumoPojo.listarInsumos();

    }

    /*@RequestMapping (value = "registrarInsumo", method = RequestMethod.POST)
    public String registrarInsumo(@RequestBody Insumo insumo) throws SQLException {
        return InsumoPojo.registrar(insumo);
    }*/

}
