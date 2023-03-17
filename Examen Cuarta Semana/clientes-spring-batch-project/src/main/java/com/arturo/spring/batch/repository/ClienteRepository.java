package com.arturo.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.spring.batch.entity.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {
}
