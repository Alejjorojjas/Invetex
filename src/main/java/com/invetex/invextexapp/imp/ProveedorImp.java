package com.invetex.invextexapp.imp;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.Proveedor;
import com.invetex.invextexapp.repository.ClienteRepository;
import com.invetex.invextexapp.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedorImp {

    @Autowired
    private ProveedorRepository proveedorRepository;
    public List<Proveedor> listarProveedores(){
        return proveedorRepository.findAll();
    }

    public String guardarProveedor(Proveedor proveedor){
        try {
            proveedorRepository.save(proveedor);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public String eliminarProveedor(Proveedor proveedor) {

        try {
            proveedorRepository.deleteById(Long.valueOf(proveedor.getIdProveedor()));
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    public String actualizarProveedor(Proveedor proveedor) {

        try {
            proveedorRepository.save(proveedor);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
}
