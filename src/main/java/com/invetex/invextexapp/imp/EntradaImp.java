package com.invetex.invextexapp.imp;

import com.invetex.invextexapp.models.Entrada;
import com.invetex.invextexapp.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntradaImp {

    @Autowired
    private EntradaRepository entradaRepository;
    public List<Entrada> listarEntrada(){
        return entradaRepository.findAll();
    }

    public String guardarEntrada(Entrada entrada){
        try {
            entradaRepository.save(entrada);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public String eliminarEntrada(Entrada entrada) {

        try {
            entradaRepository.deleteById(Long.valueOf(entrada.getIdEntrada()));
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }

    public String actualizarEntrada(Entrada entrada) {

        try {
            entradaRepository.save(entrada);
            return "0";
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }
}
