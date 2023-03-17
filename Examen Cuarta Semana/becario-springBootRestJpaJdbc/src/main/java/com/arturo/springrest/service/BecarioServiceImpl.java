package com.arturo.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arturo.springrest.dao.BecarioDAO;
import com.arturo.springrest.entity.Becario;

@Service
public class BecarioServiceImpl implements BecarioService {

	// INYECCION DE LA IMPLEMENTACION CON JDBC O CON JPA, SEGUN LA ELECCION
	// QUALIFIER
	// NOMBRE DE LA CLASE QUE IMPLEMENTA BecarioDAO CON PRIMER LETRA MINUSCULA
	@Autowired
	@Qualifier("becarioDAOJdbc")
	private BecarioDAO becarioDAO;

	@Override
	@Transactional
	public List<Becario> getBecarios() {
		// RETORNAR LA LISTA DE BECARIOS DESDE EL DAO
		return becarioDAO.getBecarios();
	}

	@Override
	@Transactional
	public Becario saveBecario(Becario becario) {
		// GUARDAR AL BECARIO DESDE EL DAO GUARDAR O ACTUALIZAR
		return becarioDAO.saveBecario(becario);
	}

	@Override
	@Transactional
	public Becario getBecario(int theId) {
		// OBTENER UN SOLO BECARIO DESDE EL DAO
		return becarioDAO.getBecario(theId);
	}

	@Override
	@Transactional
	public void deleteBecario(int theId) {
		//ELIMINAR UN BECARIO DESDE EL DAO
		becarioDAO.deleteBecario(theId);
	}

}
