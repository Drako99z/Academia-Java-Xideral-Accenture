package com.luv2code.web.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/EmpleadoControllerServlet")
public class EmpleadoControllerServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpleadoDbUtil empleadoDbUtil;
	
	//INYECCIÓN DE LOS DATOS DE CONEXION PARA EL DATASOURCE
	@Resource(name="jdbc/web_empleado_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// CREAR EL empleadoDbUtil Y PASAR EL dataSource
		try {
			empleadoDbUtil = new EmpleadoDbUtil(dataSource);			
		}
		catch (Exception exc) {
			//DELEGANDO LA EXECPCION EN CASO DE ERROR ??
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		try {
			// LEER EL PARAMETRO "command" EN LA URL
			String theCommand = request.getParameter("command");
			// SI NO HAY PARAMETRO EN LA URL, SE TOMA LIST POR DEFECTO
			if (theCommand == null)
				theCommand = "LIST";
			
			// EJECUTAR LA ACCION REQUERIDA
			switch (theCommand) {
			
			case "LIST":
				listEmpleados(request, response);
				break;
				
			case "ADD":
				addEmpleado(request, response);
				break;
				
			case "LOAD":
				loadEmpleado(request, response);
				break;
				
			case "UPDATE":
				updateEmpleado(request, response);
				break;
			
			case "DELETE":
				deleteEmpleado(request, response);
				break;
				
			default:
				listEmpleados(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteEmpleado(HttpServletRequest request, HttpServletResponse response) {

		// LEER EL PARAMETRO DEL ID DE EMPLEADO
		String empleadoId = request.getParameter("empleadoId");
		
		// BORRAR EL EMPLEADO
		try {
			empleadoDbUtil.deleteEmpleado(empleadoId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// RECARGAR LA LISTA DE EMPLEADOS
		listEmpleados(request, response);
	}

	private void updateEmpleado(HttpServletRequest request, HttpServletResponse response) {

		// LEER LOS DATOS DESDE LOS PARAMETROS DEL EMPLEADO
		int id = Integer.parseInt(request.getParameter("empleadoId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		
		// CREAR UN NUEVO EMPLEADO CON LOS DATOS RECIBIDOS
		Empleado empleado = new Empleado(id, nombre, apellido, correo, telefono);
		
		// ACTUALIZAR EL EMPLEADO EN LA BD
		try {
			System.out.println(empleado);
			empleadoDbUtil.updateEmpleado(empleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// RECARGAR LA LISTA DE EMPLEADOS
		listEmpleados(request, response);
		
	}
	
	private void addEmpleado(HttpServletRequest request, HttpServletResponse response){

		// LEER LOS DATOS DEL ESTUDIANTE DESDE LOS PARAMETROS DE LA URL
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		
		// CREAR UN NUEVO EMPLEADO CON LOS DATOS
		Empleado empleado = new Empleado(nombre, apellido, correo, telefono);
		
		try {
			// AGREGAR EL EMPLEADO A LA BD
			empleadoDbUtil.addEmpleado(empleado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		// RECARGAR LA LISTA DE EMPLEADOS
		listEmpleados(request, response);
	}

	private void loadEmpleado(HttpServletRequest request, HttpServletResponse response) {

		// LEER EL ID DESDE LOS PARAMETROS EN LA URL
		String empleadoId = request.getParameter("empleadoId");
		
		// OBTENER EL EMPLEADO DESDE LA DB
		Empleado empleado;
		try {
			empleado = empleadoDbUtil.getEmpleado(empleadoId);
			// PASAR AL EMPLEADO COMO ATRIBUTO
			request.setAttribute("EL_EMPLEADO", empleado);
			
			// ENVIAR A LA JSP Y PASAR EL ATRIBUTO: update-empleado-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/update-empleado-form.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException | NoFoundException | ServletException | IOException e) {
			e.printStackTrace();
		}	
	}

	private void listEmpleados(HttpServletRequest request, HttpServletResponse response) {

		// OBTENER LOS EMPLEADOS DESDE LA BASE DE DATOS
		List<Empleado> empleados = empleadoDbUtil.getTodosEmpleados();
		
		// ENVIAR A LA JSP Y PASAR EL ATRIBUTO
		request.setAttribute("LISTA_EMPLEADOS", empleados);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-empleados.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}













