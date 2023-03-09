package com.arturo.spring.service;

import java.util.List;

import com.arturo.spring.entity.Paciente;

public interface PacienteService {

	public List<Paciente> getPacientes();

	public void savePaciente(Paciente paciente);

	public Paciente getPaciente(int theId);

	public void deletePaciente(int theId);
	
}
