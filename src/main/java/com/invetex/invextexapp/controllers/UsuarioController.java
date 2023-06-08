package com.invetex.invextexapp.controllers;


import com.invetex.invextexapp.servicio.UsuarioServicio;
import com.invetex.invextexapp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioPojoImp;
    @RequestMapping (value = "usuario", method = RequestMethod.POST)
    public String getUsuario(@RequestBody Usuario usuario){
         return usuarioPojoImp.validarUsuario(usuario);

    }

    @PostMapping (value = "registrar")
    public String registrarUsuario(@RequestBody Usuario usuario) throws SQLException {
        System.out.println("Si llegó");
        return usuarioPojoImp.registrar(usuario);
    }

}
