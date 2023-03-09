package com.arturo.springpaciente.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arturo.springpaciente.entity.Paciente;

@Repository
public class PacienteDAOHibernate implements PacienteDAO {

	// DEFINICION DE LA VARIABLE PARA EntityManager
	private EntityManager entityManager;

	// INYECCION POR CONSTRUCTOR PARA EL EntityManager
	@Autowired
	public PacienteDAOHibernate(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Paciente> getPaciente() {

		// OBTENER LA SESSION ACTUAL DE HIBERNATE
		Session currentSession = entityManager.unwrap(Session.class);

		// CREAR LA CONSULTA PARA HIBERNATE USANDO LOS NOMBRES DE LA ENTIDAD NO DE LA DB
		Query<Paciente> theQuery = currentSession.createQuery("from Paciente order by lastName", Paciente.class);

		// EJECUTAR EL QUERY Y GUARDAR EL RESULTADO
		List<Paciente> pacientes = theQuery.getResultList();

		// RETORNAR EL RESULTADO
		return pacientes;
	}

	@Override
	public void savePaciente(Paciente paciente) {

		// OBTENER LA SESSION ACTUAL DE HIBERNATE
		Session currentSession = entityManager.unwrap(Session.class);

		// GUARDAR O ACTUALIZAR AL PACIENTE
		currentSession.saveOrUpdate(paciente);

	}

	@Override
	public Paciente getPaciente(int theId) {

		// OBTENER LA SESSION ACTUAL DE HIBERNATE
		Session currentSession = entityManager.unwrap(Session.class);

		// OBTENER UNA INSTANCIA DE PACIENTE CON LA OBTENCION DE LOS DATOS DESDE HIBERNATE
		Paciente paciente = currentSession.get(Paciente.class, theId);

		//RETORNAR AL PACIENTE
		return paciente;
	}

	@Override
	public void deletePaciente(int theId) {

		// OBTENER LA SESSION ACTUAL DE HIBERNATE
		Session currentSession = entityManager.unwrap(Session.class);

		// ELIMINAR EL PACIENTE CON EL ID RECIBIDO
		Query theQuery = currentSession.createQuery("delete from Paciente where id=:pacienteId");
		theQuery.setParameter("pacienteId", theId);

		//EJECUTAR EL QUERY
		theQuery.executeUpdate();
	}

}
