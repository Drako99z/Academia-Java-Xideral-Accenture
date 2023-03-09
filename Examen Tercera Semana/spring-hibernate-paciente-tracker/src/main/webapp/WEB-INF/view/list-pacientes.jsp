<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Pacientes</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Clínica de Atenciones Médicas</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Paciente"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Número de Seguro</th>
					<th>Acción</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPaciente" items="${pacientes}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/paciente/showFormForUpdate">
						<c:param name="pacienteId" value="${tempPaciente.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/paciente/delete">
						<c:param name="pacienteId" value="${tempPaciente.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPaciente.firstName} </td>
						<td> ${tempPaciente.lastName} </td>
						<td> ${tempPaciente.email} </td>
						<td> ${tempPaciente.numSeguro} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Está seguro que desea eliminar al paciente?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









