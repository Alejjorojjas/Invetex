package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.imp.EntradaImp;
import com.invetex.invextexapp.models.Entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntradaServicio {

    @Autowired
    private EntradaImp entradaImp;
    public List <Entrada> listarEntrada(){
       return entradaImp.listarEntrada();
    }

    public String guardarEntrada(Entrada entrada){

        return entradaImp.guardarEntrada(entrada);
    }

    public String eliminarEntrada(Entrada entrada) {

        return entradaImp.eliminarEntrada(entrada);
    }

    public String actualizarEntrada(Entrada entrada) {

        return entradaImp.actualizarEntrada(entrada);

    }
}
