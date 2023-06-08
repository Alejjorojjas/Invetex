package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.imp.ClienteImp;
import com.invetex.invextexapp.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServicio {

    @Autowired
    private ClienteImp clienteImp;
    public List <Cliente> listarClientes(){
        return clienteImp.listarClientes();
    }

    public String guardarCliente(Cliente cliente){

        return clienteImp.guardarCliente(cliente);
    }

    public String eliminarCliente(Cliente cliente) {

        return clienteImp.eliminarCliente(cliente);
    }

    public String actualizarCliente(Cliente cliente) {

        return clienteImp.actualizarCliente(cliente);

    }
}
