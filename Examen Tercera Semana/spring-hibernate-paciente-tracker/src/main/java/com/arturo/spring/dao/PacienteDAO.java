package com.arturo.spring.dao;

import java.util.List;

import com.arturo.spring.entity.Paciente;

public interface PacienteDAO {

	public List<Paciente> getPaciente();

	public void savePaciente(Paciente paciente);

	public Paciente getPaciente(int theId);

	public void deletePaciente(int theId);
	
}
