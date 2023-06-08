package com.invetex.invextexapp.Pojo;

import com.invetex.invextexapp.models.Insumo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class InsumoPojoImp implements InsumoPojo{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Insumo> listarInsumos() {

        String query = "FROM Insumo ";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public String registrar(Insumo insumo) {
        Query query = entityManager.createQuery("SELECT COUNT(i) FROM Insumo i WHERE i.referencia = :referencia");
        query.setParameter("referencia", insumo.getReferencia());
        Long count = (Long) query.getSingleResult();
        if (count > 0) {
            return "Referencia ya existe";
        } else {
            entityManager.merge(insumo);
            return "Insumo Adicionado";
        }
    }
}
