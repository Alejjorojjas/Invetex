package com.invetex.invextexapp.Pojo;

import com.invetex.invextexapp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional <Usuario> findByEmailAndPassword (String email, String password);

}

