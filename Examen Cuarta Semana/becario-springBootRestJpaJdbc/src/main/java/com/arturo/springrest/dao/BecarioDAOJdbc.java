package com.arturo.springrest.dao;

import java.math.BigDecimal;
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

import com.arturo.springrest.entity.Becario;

@Repository
public class BecarioDAOJdbc implements BecarioDAO {

	// INYECCION DEL DataSource
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Becario> getBecarios() {
		//DECLARAR LISTA DE BECARIOS
		List<Becario> becarios = new ArrayList<>();

		//DEFINIR LA CONSULTA SQL
		String sql = "select * from becario order by apellido";

		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// CREAR INSTANCIAS DE BECARIOS TEMPORALES PARA AGREGARLOS A LA LISTA
			while (myRs.next()) {

				int id = myRs.getInt("id");
				String firstName = myRs.getString("nombre");
				String lastName = myRs.getString("apellido");
				String email = myRs.getString("correo");
				BigDecimal montoBeca = myRs.getBigDecimal("monto_beca");

				Becario tempBecario = new Becario(id, firstName, lastName, email, montoBeca);

				becarios.add(tempBecario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DEVOLVER LA LISTA DE BECARIOS
		return becarios;
	}

	@Override
	public Becario saveBecario(Becario becario) {
		//DEFINIR EL BECARIO QUE SE DEVOLVERA
		Becario bec = null;
		//DEFINIR LA CONSULTA SQL YA SEA PARA INSERTAR O PARA ACTUALIZAR
		String sql = null;
		
		if(becario.getId() == 0)
			sql = "insert into becario (nombre, apellido, correo, monto_beca) values (?, ?, ?, ?)";
		else
			sql = "update becario set nombre=?, apellido=?, correo=?, monto_beca=? where id=?";

		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			// ASIGNACION DE LOS DATOS PARA INSERTAR O ACTUALIZAR
			ps.setString(1, becario.getNombre());
			ps.setString(2, becario.getApellido());
			ps.setString(3, becario.getCorreo());
			ps.setBigDecimal(4, becario.getMonto());
			
			//id PARA WHERE DEL UPDATE
			if(becario.getId() != 0)
				ps.setInt(5, becario.getId());

			// EJECUTAR LA CONSULTA
			ps.execute();
			
			// OBTENER EL REGISTRO DEL BECARIO QUE SE HA GUARDADO O ACTUALIZADO
			int idSaved = becario.getId();
			// OBTENER EL ID QUE SE HA GENERADO SI SE TRATA DE INSERCION
			if(idSaved == 0) {
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next())
					idSaved = generatedKeys.getInt(1);
			}
			// BUSCAR POR ID EL BECARIO QUE SE HA MODIFICADO
			bec = getBecario(idSaved);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return bec;
	}

	@Override
	public Becario getBecario(int theId) {
		
		Becario becario = null;
		
		//TRY WITH RESOURCE PARA INICIAR LA CONEXION
		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetBecario(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// INSTANCIAR UN BECARIO NUEVO Y ASIGNAR LOS VALORES DESDE LOS RESULTADOS DE LA BD
			if (myRs.next()) {
				String firstName = myRs.getString("nombre");
				String lastName = myRs.getString("apellido");
				String email = myRs.getString("correo");
				BigDecimal montoBeca = myRs.getBigDecimal("monto_beca");

				becario = new Becario(theId, firstName, lastName, email, montoBeca);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		// DEVOLVER AL BECARIO
		return becario;
	}
	
	// PREPARAR AL PreparedStatement PARA LA CONSULTA DE UN BECARIO POR ID
	private PreparedStatement crearStatementGetBecario(Connection myConn, int becarioId) throws SQLException {
		//DEFINIR LA CONSULTA SQL
		String sql = "select * from becario where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, becarioId);
		// DEVOLVER AL PreparedStatement
		return ps;
	}

	@Override
	public void deleteBecario(int theId) {
		//DEFINIR LA CONSULTA SQL
		String sql = "delete from becario where id=?";

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
