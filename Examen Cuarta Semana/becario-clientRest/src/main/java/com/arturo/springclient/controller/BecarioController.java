package com.arturo.springclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arturo.springclient.entity.Becario;
import com.arturo.springclient.service.BecarioService;

@Controller
@RequestMapping("/becario")
public class BecarioController {

	// INYECCION DEL BecarioService
	@Autowired
	private BecarioService becarioService;

	@GetMapping("/lista")
	public String listBecarios(Model theModel) {
		// OBTENER LA LISTA DE BECARIOS DESDE EL SERVICIO
		List<Becario> becarios = becarioService.getBecarios();

		// AGREGAR LOS BECARIOS AL MODELO
		theModel.addAttribute("becarios", becarios);

		// RETONO DEL NOMBRE DE LA VISTA A MOSTRAR
		return "list-becario";
	}

	@GetMapping("/formAdd")
	public String showFormForAdd(Model theModel) {
		// CREAR UN BECARIO PARA ATRAPAR LOS DATOS
		Becario becario = new Becario();

		// AGREGAR EL BECARIO AL MODELO
		theModel.addAttribute("becario", becario);

		// RETONO DEL NOMBRE DE LA VISTA A MOSTRAR
		return "becario-form";
	}

	@PostMapping("/saveBecario")
	public String saveBecario(@ModelAttribute("becario") Becario becario) {
		// GUARDAR EL BECARIO USANDO EL SERVICIO
		becarioService.saveBecario(becario);

		// RETONO DE REDIRECCION DE LA VISTA A MOSTRAR
		return "redirect:/becario/lista";
	}

	@GetMapping("/formUpdate")
	public String showFormForUpdate(@RequestParam("becarioId") int theId, Model theModel) {
		// OBTENER EL BECARIO DESDE EL SERVICIO CON EL ID OBTENIDO COMO PARAMETRO
		Becario becario = becarioService.getBecario(theId);

		// ENVIAR AL MODELO EL BECARIO PARA PRELLENAR LOS DATOS
		theModel.addAttribute("becario", becario);

		// RETONO DEL NOMBRE DE LA VISTA A MOSTRAR
		return "becario-form";
	}

	@GetMapping("/delete")
	public String deleteBecario(@RequestParam("becarioId") int theId) {
		// ELIMINAR EL BECARIO CON EL SERVICIO
		becarioService.deleteBecario(theId);

		// RETONO DE REDIRECCION DE LA VISTA A MOSTRAR
		return "redirect:/becario/lista";
	}
}
