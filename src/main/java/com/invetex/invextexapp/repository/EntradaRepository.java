package com.invetex.invextexapp.repository;

import com.invetex.invextexapp.models.Cliente;
import com.invetex.invextexapp.models.Entrada;
import com.invetex.invextexapp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {



}
