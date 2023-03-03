<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Empleados Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
			
			<input type="button" value="Agregar Empleado" 
				   onclick="window.location.href='add-empleado-form.jsp'; return false;"
				   class="add-empleado-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Teléfono</th>
					<th>Acción</th>
				</tr>
				
				<c:forEach var="tempEmpleado" items="${LISTA_EMPLEADOS}">
					
					<c:url var="tempLink" value="EmpleadoControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>

					<c:url var="deleteLink" value="EmpleadoControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempEmpleado.nombre} </td>
						<td> ${tempEmpleado.apellido} </td>
						<td> ${tempEmpleado.correo} </td>
						<td> ${tempEmpleado.telefono} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Seguro que desea eliminar este empleado?'))) return false">
							Eliminar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








