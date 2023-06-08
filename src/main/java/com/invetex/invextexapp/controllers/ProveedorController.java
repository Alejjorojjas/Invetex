package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.Proveedor;
import com.invetex.invextexapp.servicio.ClienteServicio;
import com.invetex.invextexapp.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProveedorController {


    @Autowired
    private ProveedorServicio proveedorServicio;
    @RequestMapping(value = "obtenerProveedor", method = RequestMethod.GET)
    public List<Proveedor> getProveedor(){
        return proveedorServicio.listarProveedores();

    }

    @PostMapping (value = "guardarProveedor")
    public String guardarProveedor (@RequestBody Proveedor proveedor){

        return proveedorServicio.guardarProveedor(proveedor);
    }

    @DeleteMapping (value = "eliminarProveedor")
    public String eliminarProveedor (@RequestBody Proveedor proveedor){

        return proveedorServicio.eliminarProveedor(proveedor);

    }

    @PutMapping (value = "actualizarProveedor")
    public String actualizarProveedor (@RequestBody Proveedor proveedor){

        return proveedorServicio.actualizarProveedor(proveedor);
    }

}
