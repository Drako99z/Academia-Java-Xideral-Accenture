package com.arturo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arturo.spring.dao.PacienteDAO;
import com.arturo.spring.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {

	// INYECCION DEL PacienteDAO
	@Autowired
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





