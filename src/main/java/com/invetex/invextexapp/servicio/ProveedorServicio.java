package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.imp.ClienteImp;
import com.invetex.invextexapp.imp.ProveedorImp;
import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedorServicio {

    @Autowired
    private ProveedorImp proveedorImp;
    public List <Proveedor> listarProveedores(){
        return proveedorImp.listarProveedores();
    }

    public String guardarProveedor(Proveedor proveedor){

        return proveedorImp.guardarProveedor(proveedor);
    }

    public String eliminarProveedor(Proveedor proveedor) {

        return proveedorImp.eliminarProveedor(proveedor);
    }

    public String actualizarProveedor(Proveedor proveedor) {

        return proveedorImp.actualizarProveedor(proveedor);

    }
}
