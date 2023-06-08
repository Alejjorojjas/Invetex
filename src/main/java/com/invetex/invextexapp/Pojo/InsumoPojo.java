package com.invetex.invextexapp.Pojo;

import com.invetex.invextexapp.models.Insumo;
import com.invetex.invextexapp.models.Usuario;

import java.util.List;

public interface InsumoPojo {

    List<Insumo> listarInsumos();

    String registrar(Insumo insumo);


}
