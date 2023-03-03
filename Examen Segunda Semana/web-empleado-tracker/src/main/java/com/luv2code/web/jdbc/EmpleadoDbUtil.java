package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmpleadoDbUtil {

	private DataSource dataSource;

	public EmpleadoDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Empleado> getTodosEmpleados() {
		// LISTA DE EMPLEADOS A DEVOLVER
		List<Empleado> students = new ArrayList<>();

		// INSTRUCCIÓN SQL PARA SELECCIONAR LOS EMPLEADOS DE LA DB
		String sql = "select * from empleado order by apellido";

		// TRY WITH RESOURCE
		// INTENTAR LA CONEXIÓN A LA BASE DE DATOS
		// CREAR EL STATEMENT
		// EJECUTAR LA CONSULTA
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// INTERAR LOS RESULTADOS OBTENIDOS
			while (myRs.next()) {

				// ASIGNAR LOS DATOS OBTENIDOS EN VARIABLES
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				String telefono = myRs.getString("telefono");

				// CREAR EL NUEVO EMPLEADO CON LOS VALORES RESCATADOS
				Empleado empleadoTemp = new Empleado(id, nombre, apellido, correo, telefono);

				// AGREGAR EL EMPLEADO A LA LISTA
				students.add(empleadoTemp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;

	}

	public void addEmpleado(Empleado empleado) throws SQLException {

		// INSTRUCCION SQL PARA INSERTAR EL EMPLEADO
		String sql = "insert into empleado " + "(nombre, apellido, correo, telefono) " + "values (?, ?, ?, ?)";

		// TRY WITH RESOURCE
		// INTENTAR LA CONEXIÓN A LA BASE DE DATOS
		// CREAR EL STATEMENT
		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement ps = myConn.prepareStatement(sql);) {

			//ASIGNACIÓN DE LOS CAMPOS A LA CONSULTA, EVITANDO INYECCIÓN SQL
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setString(3, empleado.getCorreo());
			ps.setString(4, empleado.getTelefono());

			//EJECUTAR LA INSERCIÓN
			ps.execute();
		}
	}

	//OBTENER UN SOLO EMPLEADO
	public Empleado getEmpleado(String empleadoId) throws SQLException, NoFoundException {

		//DECLARAR EL EMPLEADO QUE SE DEVOLVERÁ
		Empleado empleado = null;
		//OBTENER EL ID DEL EMPLEADO QUE SE VA A BUSCAR
		int id = Integer.parseInt(empleadoId);

		// TRY WITH RESOURCE
		// INTENTAR LA CONEXIÓN A LA BASE DE DATOS
		// CREAR EL STATEMENT MEDIANTE UN METODO DE LA CLASE
		// OBTENER EL RESULTADO DE LA CONSULTA
		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetEmpleado(myConn, id);
				ResultSet myRs = myStmt.executeQuery()) {

			// VERIFICAR QUE EXISTAN DATOS EN LA RESPUESTA
			if (myRs.next()) {
				//ASIGNAR LOS DATOS A VARIABLES
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				String telefono = myRs.getString("telefono");

				// USAR LOS DATOS PARA INSTANCIAR UN EMPLEADO NUEVO
				empleado = new Empleado(id, nombre, apellido, correo, telefono);
			} else {
				//SI NO SE ENCONTRÓ EL EMPLEADO, SE LANZA UNA EXCEPCION
				throw new NoFoundException("No se encontró el estudiante con el id: " + id);
			}

			return empleado;
		}
	}

	//OBTENER EL STATEMENT DEL EMPLEADO PARA BUSCAR SOLO A UNO
	private PreparedStatement crearStatementGetEmpleado(Connection myConn, int id) throws SQLException {
		String sql = "select * from empleado where id=?";
		//PREPARED STATEMENT CON PARA CARGAR LOS DATOS DE LA CONSULTA
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
	}

	//ACTUALIZAR UN EMPLEADO
	public void updateEmpleado(Empleado empleado) throws SQLException{

		// CREAR LA CONSULTA SQL
		String sql = "update empleado set nombre=?, apellido=?, correo=?, telefono=? where id=?";

		// TRY WITH RESOURCE
		// INTENTAR LA CONEXIÓN A LA BASE DE DATOS
		// CREAR EL STATEMENT MEDIANTE UN METODO DE LA CLASE
		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// INSERTAR LOS DATOS DEL EMPLEADO EN EL STATEMENT
			myStmt.setString(1, empleado.getNombre());
			myStmt.setString(2, empleado.getApellido());
			myStmt.setString(3, empleado.getCorreo());
			myStmt.setString(4, empleado.getTelefono());
			myStmt.setInt(5, empleado.getId());

			// EJECUTAR LA CONSULTA
			myStmt.execute();
		}
	}

	//ELIMINAR UN EMPLEADO
	public void deleteEmpleado(String empleadoId) throws SQLException {

		// CREAR LA CONSULTA SQL PARA ELIMINAR
		String sql = "delete from empleado where id=?";

		// TRY WITH RESOURCE
		// INTENTAR LA CONEXIÓN A LA BASE DE DATOS
		// CREAR EL STATEMENT MEDIANTE UN METODO DE LA CLASE
		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// OBTENER EL ID DEL EMPLEADO A ELIMINAR
			int id = Integer.parseInt(empleadoId);

			// INSERTAR EL PARAMETRO DEL ID
			myStmt.setInt(1, id);

			// EXECUTAR LA CONSULTA
			myStmt.execute();
		}
	}
}
