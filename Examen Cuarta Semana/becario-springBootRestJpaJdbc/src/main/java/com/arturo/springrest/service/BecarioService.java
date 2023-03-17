package com.arturo.springrest.service;

import java.util.List;

import com.arturo.springrest.entity.Becario;

public interface BecarioService {
	public List<Becario> getBecarios();

	public Becario saveBecario(Becario becario);

	public Becario getBecario(int theId);

	public void deleteBecario(int theId);
}
