package com.invetex.invextexapp.imp;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteImp {

    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public String guardarCliente(Cliente cliente){
        try {
            clienteRepository.save(cliente);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public String eliminarCliente(Cliente cliente) {

        try {
            clienteRepository.deleteById(Long.valueOf(cliente.getIdCliente()));
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    public String actualizarCliente(Cliente cliente) {

        try {
            clienteRepository.save(cliente);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
}
