<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Becario</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-becario-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Sistema de Administracion de Becarios</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Becario</h3>
	
		<form:form action="saveBecario" modelAttribute="becario" method="POST">

			<!-- need to associate this data with becario id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="apellido" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><form:input path="correo" /></td>
					</tr>
					
					<tr>
						<td><label>Monto de la beca ($):</label></td>
						<td><form:input path="monto" type="number" step="0.01" /></td>
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
			<a href="${pageContext.request.contextPath}/becario/lista">Volver a la lista</a>
		</p>
	
	</div>

</body>

</html>










