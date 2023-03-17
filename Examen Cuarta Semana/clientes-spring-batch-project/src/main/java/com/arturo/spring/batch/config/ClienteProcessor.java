package com.arturo.spring.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.arturo.spring.batch.entity.Cliente;

public class ClienteProcessor implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
    	// METODO DE PROCESAMIENTO DE LOS CLIENTES
        if(cliente.getPais().equals("Mexico")) {
        	if(cliente.getGenero().equals("Male"))
        		cliente.setGenero("Masculino");
        	else if(cliente.getGenero().equals("Female"))
        		cliente.setGenero("Femenino");
            return cliente;
        }
        return null;
        
    }
}
