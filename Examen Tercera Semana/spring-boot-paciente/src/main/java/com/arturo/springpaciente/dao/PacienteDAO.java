package com.arturo.springpaciente.dao;

import java.util.List;

import com.arturo.springpaciente.entity.Paciente;

public interface PacienteDAO {

	public List<Paciente> getPaciente();

	public void savePaciente(Paciente paciente);

	public Paciente getPaciente(int theId);

	public void deletePaciente(int theId);
	
}
