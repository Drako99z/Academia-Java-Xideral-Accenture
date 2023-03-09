package com.arturo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arturo.spring.entity.Paciente;
import com.arturo.spring.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	// INYECCION DEL PacienteService
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// OBTENER LA LISTA DE PACIENTES DESDE EL SERVICIO
		List<Paciente> pacientes = pacienteService.getPacientes();
				
		// AGREGAR LOS PACIENTES AL MODELO
		theModel.addAttribute("pacientes", pacientes);
		
		// RETONO DEL NOMBRE DE LA VISTA A MOSTRAR
		return "list-pacientes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// CREAR UN PACIENTE PARA ATRAPAR LOS DATOS
		Paciente paciente = new Paciente();
		
		// AGREGAR EL PACIENTE AL MODELO
		theModel.addAttribute("paciente", paciente);
		
		// RETONO DEL NOMBRE DE LA VISTA A MOSTRAR
		return "paciente-form";
	}
	
	@PostMapping("/savePaciente")
	public String saveCustomer(@ModelAttribute("paciente") Paciente paciente) {
		
		// GUARDAR EL PACIENTE USANDO EL SERVICIO
		pacienteService.savePaciente(paciente);	
		
		// RETONO DE REDIRECCION DE LA VISTA A MOSTRAR
		return "redirect:/paciente/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pacienteId") int theId,
									Model theModel) {
		
		// OBTENER EL PACIENTE DESDE EL SERVICIO CON EL ID OBTENIDO COMO PARAMETRO
		Paciente paciente = pacienteService.getPaciente(theId);	
		
		// ENVIAR AL MODELO EL PACIENTE PARA PRELLENAR LOS DATOS
		theModel.addAttribute("paciente", paciente);
		
		// RETONO DEL NOMBRE DE LA VISTA A MOSTRAR	
		return "paciente-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("pacienteId") int theId) {
		
		// ELIMINAR EL PACIENTE CON EL SERVICIO
		pacienteService.deletePaciente(theId);
		
		// RETONO DE REDIRECCION DE LA VISTA A MOSTRAR
		return "redirect:/paciente/list";
	}
}










