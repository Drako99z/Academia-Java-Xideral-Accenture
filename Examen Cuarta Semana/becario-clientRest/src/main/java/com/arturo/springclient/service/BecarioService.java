package com.arturo.springclient.service;

import java.util.List;

import com.arturo.springclient.entity.Becario;

public interface BecarioService {

	public List<Becario> getBecarios();

	public void saveBecario(Becario becario);

	public Becario getBecario(int theId);

	public void deleteBecario(int theId);
	
}
