package com.invetex.invextexapp.servicio;

import com.invetex.invextexapp.Pojo.UsuarioRepository;
import com.invetex.invextexapp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class UsuarioServicio {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuario() {
        return null;
    }


    public String registrar(Usuario usuario) {

        usuarioRepository.save(usuario);

        return "Registro exitoso.";
    }


    public String validarUsuario(Usuario usuario) {

        Optional <Usuario> usuarioOptional = usuarioRepository.findByEmailAndPassword(usuario.getEmail(),usuario.getPassword());

        if (usuarioOptional.isPresent()){

            return "0";
        }

        else {
            return "Error Autenticación";
        }
    }
}