package com.arturo.springpaciente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arturo.springpaciente.dao.PacienteDAO;
import com.arturo.springpaciente.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {

	// INYECCION DE LA IMPLEMENTACION CON JDBC O CON HIBERNATE, SEGUN LA ELECCION QUALIFIER
	// NOMBRE DE LA CLASE QUE IMPLEMENTA PacienteDAO CON PRIMER LETRA MINUSCULA
	@Autowired
	@Qualifier("pacienteDAOJdbc") 
	private PacienteDAO pacienteDAO;
	
	@Override
	@Transactional
	public List<Paciente> getPacientes() {
		// RETORNAR LA LISTA DE PACIENTES DESDE EL DAO
		return pacienteDAO.getPaciente();
	}

	@Override
	@Transactional
	public void savePaciente(Paciente paciente) {
		// GUARDAR AL PACIENTE DESDE EL DAO GUARDAR O ACTUALIZAR
		pacienteDAO.savePaciente(paciente);
	}

	@Override
	@Transactional
	public Paciente getPaciente(int theId) {
		// OBTENER UN SOLO PACIENTE DESDE EL DAO
		return pacienteDAO.getPaciente(theId);
	}

	@Override
	@Transactional
	public void deletePaciente(int theId) {
		//ELIMINAR UN PACIENTE DESDE EL DAO
		pacienteDAO.deletePaciente(theId);
	}
}





