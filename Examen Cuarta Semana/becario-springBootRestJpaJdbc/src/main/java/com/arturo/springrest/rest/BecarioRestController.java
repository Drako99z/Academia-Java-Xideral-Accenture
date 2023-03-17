package com.arturo.springrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arturo.springrest.entity.Becario;
import com.arturo.springrest.exception.BecarioNotFoundException;
import com.arturo.springrest.service.BecarioService;

@RestController
@RequestMapping("/api")
public class BecarioRestController {
	// INYECCION DEL BecarioService
	@Autowired
	private BecarioService becarioService;

	@GetMapping("/becarios")
	public List<Becario> findAll() {
		// OBTENER Y DEVOLVER LA LISTA DE BECARIOS
		return becarioService.getBecarios();
	}

	@GetMapping("/becarios/{becarioId}")
	public Becario getBecario(@PathVariable int becarioId) throws Exception {
		// OBTENER UN SOLO BECARIO POR EL ID RECIBIDO
		Becario becario = becarioService.getBecario(becarioId);
		// SI EL BECARIO RECIBIDO ES NULL SE LANZA UNA EXCEPCION PERSONALIZADA
		if (becario == null) {
			throw new BecarioNotFoundException("Becario no encontrado - " + becarioId);
		}
		// SE DEVUELVE EL BECARIO SE ECONTRO
		return becario;
	}

	@PostMapping("/becarios")
	public Becario addBecario(@RequestBody Becario becario) {
		// SE MARCA AL BECARIO A AÑADIR CON ID 0
		becario.setId(0);
		// SE AGREGA EL BECARIO NUEVO Y SE ASIGNA LA DEVOLUCION DEL NUEVO BECARIO
		// INSERTADO
		Becario addBecario = becarioService.saveBecario(becario);
		// SE DEVUELVE EL BECARIO AGREGADO
		return addBecario;
	}

	@PutMapping("/becarios")
	public Becario updateBecario(@RequestBody Becario becario) {
		// SE ACTUALIZAN LOS CAMPOS DEL BECARIO Y SE ASIGNA EL BECARIO DEVUELTO
		Becario bec = becarioService.saveBecario(becario);
		// SE DEVUELVE EL BECARIO YA ACTUALIZADO
		return bec;
	}

	@DeleteMapping("/becarios/{becarioId}")
	public String deleteBecario(@PathVariable int becarioId) {
		// SE OBTIENE EL BECARIO A ELIMINAR
		Becario becario = becarioService.getBecario(becarioId);
		// SI NO FUE ENCONTRADO NINGUN BECARIO SE LANZA LA EXEPCION PERSONALIZADA
		if (becario == null) {
			throw new BecarioNotFoundException("Becario no encontrado - " + becarioId);
		}
		// SE ELIMINA EL BECARIO SI FUE ENCONTRADO
		becarioService.deleteBecario(becarioId);
		// SE DEVUELVE UNA RESPUESTA EN TEXTO PLANO
		return "Becario eliminado id - " + becarioId;
	}
}
