package com.arturo.springpaciente.service;

import java.util.List;

import com.arturo.springpaciente.entity.Paciente;

public interface PacienteService {

	public List<Paciente> getPacientes();

	public void savePaciente(Paciente paciente);

	public Paciente getPaciente(int theId);

	public void deletePaciente(int theId);
	
}
