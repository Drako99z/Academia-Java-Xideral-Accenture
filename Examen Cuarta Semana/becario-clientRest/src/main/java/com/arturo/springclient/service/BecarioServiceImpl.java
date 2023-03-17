package com.arturo.springclient.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arturo.springclient.entity.Becario;

@Service
public class BecarioServiceImpl implements BecarioService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	// INYECCION DE LAS DEPENDENCIAS NECESARIAS
	@Autowired
	public BecarioServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		// MOSTRAR INFORMACION DE LAS OPERACIONES
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Becario> getBecarios() {
		logger.info("in getBecarios(): Calling REST API " + crmRestUrl);

		// HACER LA PETICION REST AL URL POR METODO GET PARA TODOS LOS BECARIOS
		ResponseEntity<List<Becario>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Becario>>() {
				});

		// OBTENER LOS BECARIOS DE LA RESPUESTA
		List<Becario> becarios = responseEntity.getBody();

		logger.info("in getBecarios(): becarios" + becarios);

		return becarios;
	}

	@Override
	public void saveBecario(Becario becario) {
		logger.info("in saveBecario(): Calling REST API " + crmRestUrl);

		// VERIFICAR SE SE REALIZARA UNA INSERCION O MODIFICACION
		if (becario.getId() == 0) {
			// PETICION REST PARA INSERTAR POR POST
			restTemplate.postForEntity(crmRestUrl, becario, String.class);
		} else {
			// PETICION REST PARA ACTUALIZAR POR PUT
			restTemplate.put(crmRestUrl, becario);
		}

		logger.info("in saveBecario(): success");
	}

	@Override
	public Becario getBecario(int theId) {
		logger.info("in getBecario(): Calling REST API " + crmRestUrl);

		// HACER LA PETICION REST PARA OBTENER UN SOLO BECARIO POR GET
		Becario becario = restTemplate.getForObject(crmRestUrl.concat("/").concat(String.valueOf(theId)),
				Becario.class);

		logger.info("in getBecario(): becario=" + becario);

		// DEVOLVER EL BECARIO OBTENIDO
		return becario;
	}

	@Override
	public void deleteBecario(int theId) {
		logger.info("in deleteBecario(): Calling REST API " + crmRestUrl);

		// HACER LA PETICION REST PARA ELIMINAR UN BECARIO POR DELETE
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteBecario(): deleted becario theId=" + theId);

	}
}
