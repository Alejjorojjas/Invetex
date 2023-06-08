package com.invetex.invextexapp.controllers;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {


    @Autowired
    private ClienteServicio clienteServicio;
    @RequestMapping(value = "obtenerClientes", method = RequestMethod.GET)
    public List<Cliente> getCliente(){
        return clienteServicio.listarClientes();

    }

    @PostMapping (value = "guardarCliente")
    public String guardarClientes (@RequestBody Cliente cliente){

        return clienteServicio.guardarCliente(cliente);
    }

    @DeleteMapping (value = "eliminarCliente")
    public String eliminarCliente (@RequestBody Cliente cliente){

        return clienteServicio.eliminarCliente(cliente);

    }

    @PutMapping (value = "actualizarCliente")
    public String actualizarCliente (@RequestBody Cliente cliente){

        return clienteServicio.actualizarCliente(cliente);
    }

}
