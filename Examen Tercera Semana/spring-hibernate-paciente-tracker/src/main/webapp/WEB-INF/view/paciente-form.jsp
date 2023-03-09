<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Paciente</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-paciente-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Clínica de Atenciones Médicas</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Paciente</h3>
	
		<form:form action="savePaciente" modelAttribute="paciente" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label>Número de Seguro:</label></td>
						<td><form:input path="numSeguro" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/paciente/list">Volver a la lista</a>
		</p>
	
	</div>

</body>

</html>










