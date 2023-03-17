package com.arturo.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arturo.springrest.entity.Becario;

@Repository
public class BecarioDAOJpa implements BecarioDAO {
	
	// DEFINICION DE LA VARIABLE PARA EntityManager
    private EntityManager entityManager;
    
    // INYECCION POR CONSTRUCTOR PARA EL EntityManager
    @Autowired
    public BecarioDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Becario> getBecarios() {
		// CREAR LA CONSULTA
        TypedQuery<Becario> query = entityManager.createQuery("from Becario", Becario.class);

        // EJECUTAR EL QUERY Y GUARDAR EL RESULTADO
        List<Becario> becarios = query.getResultList();

		// RETORNAR EL RESULTADO
        return becarios;
	}

	@Override
	public Becario saveBecario(Becario becario) {
		// GUARDAR O ACTUALIZAR AL BECARIO
		Becario bec = entityManager.merge(becario);
		return bec;
	}

	@Override
	public Becario getBecario(int theId) {
		// OBTENER UNA INSTANCIA DE BECARIO CON LOS DATOS
		Becario becario = entityManager.find(Becario.class, theId);
		return becario;
	}

	@Override
	public void deleteBecario(int theId) {
		// OBTENER UNA INSTANCIA DE BECARIO CON LOS DATOS
		Becario becario = entityManager.find(Becario.class, theId);
		// ELIMINAR EL BECARIO OBTENIDO
        entityManager.remove(becario);
		
	}

}
