package com.invetex.invextexapp.repository;

import com.invetex.invextexapp.models.Salida;
import com.invetex.invextexapp.models.TipoInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalidaRepository extends JpaRepository <Salida, Long> {

}
