package com.arturo.springpaciente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arturo.springpaciente.entity.Paciente;

@Repository
public class PacienteDAOJdbc implements PacienteDAO {

	// INYECCION DEL DataSource
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Paciente> getPaciente() {
		//DECLARAR LISTA DE PACIENTES
		List<Paciente> pacientes = new ArrayList<>();

		//DEFINIR LA CONSULTA SQL
		String sql = "select * from paciente order by apellido";

		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// CREAR INSTANCIAS DE PACIENTE TEMPORALES PARA AGREGARLOS A LA LISTA
			while (myRs.next()) {

				int id = myRs.getInt("id");
				String firstName = myRs.getString("nombre");
				String lastName = myRs.getString("apellido");
				String email = myRs.getString("correo");
				String numSeguro = myRs.getString("num_seguro");

				Paciente tempPaciente = new Paciente(id, firstName, lastName, email, numSeguro);

				pacientes.add(tempPaciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DEVOLVER LA LISTA DE PACIENTES
		return pacientes;
	}

	@Override
	public void savePaciente(Paciente paciente) {
		
		//DEFINIR LA CONSULTA SQL YA SEA PARA INSERTAR O PARA ACTUALIZAR
		String sql = null;
		if(paciente.getId() == 0)
			sql = "insert into paciente (nombre, apellido, correo, num_seguro) values (?, ?, ?, ?)";
		else
			sql = "update paciente set nombre=?, apellido=?, correo=?, num_seguro=? where id=?";

		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql);
				
		) {

			// ASIGNACION DE LOS DATOS PARA INSERTAR O ACTUALIZAR
			ps.setString(1, paciente.getFirstName());
			ps.setString(2, paciente.getLastName());
			ps.setString(3, paciente.getEmail());
			ps.setString(4, paciente.getNumSeguro());
			
			//id PARA WHERE DEL UPDATE
			if(paciente.getId() != 0)
				ps.setInt(5, paciente.getId());

			// EJECUTAR LA CONSULTA
			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Paciente getPaciente(int theId) {
		
		Paciente paciente = null;
		
		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetPaciente(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// INSTANCIAR UN PACIENTE NUEVO Y ASIGNAR LOS VALORES DESDE LOS RESULTADOS DE LA BD
			if (myRs.next()) {
				String firstName = myRs.getString("nombre");
				String lastName = myRs.getString("apellido");
				String email = myRs.getString("correo");
				String numSeguro = myRs.getString("num_seguro");

				paciente = new Paciente(theId, firstName, lastName, email, numSeguro);
			} else {
				System.out.println("No se encontró el paciente: " + theId);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		// DEVOLVER AL PACIENTE
		return paciente;
	}
	
	// PREPARAR AL PreparedStatement PARA LA CONSULTA DE UN PACIENTE POR ID
	private PreparedStatement crearStatementGetPaciente(Connection myConn, int pacienteId) throws SQLException {
		//DEFINIR LA CONSULTA SQL
		String sql = "select * from paciente where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, pacienteId);
		// DEVOLVER AL PreparedStatement
		return ps;
	}

	@Override
	public void deletePaciente(int theId) {
		//DEFINIR LA CONSULTA SQL
		String sql = "delete from paciente where id=?";

		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// ASIGNACION DE LOS VALORES PARA LA CONSULTA
			myStmt.setInt(1, theId);

			// EJECUTAR LA CONSULTA
			myStmt.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	

}
