<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Becarios</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Sistema de Administración de Becarios</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Becario -->
		
			<input type="button" value="Agregar Becario"
				   onclick="window.location.href='formAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Monto de la Beca</th>
					<th>Acción</th>
				</tr>
				
				<!-- ciclo para imprimir los becarios -->
				<c:forEach var="tempBecario" items="${becarios}">
				
					<!-- construir link para actualizar -->
					<c:url var="updateLink" value="/becario/formUpdate">
						<c:param name="becarioId" value="${tempBecario.id}" />
					</c:url>					

					<!-- construir link para eliminar -->
					<c:url var="deleteLink" value="/becario/delete">
						<c:param name="becarioId" value="${tempBecario.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempBecario.nombre} </td>
						<td> ${tempBecario.apellido} </td>
						<td> ${tempBecario.correo} </td>
						<td>$${tempBecario.monto} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Está seguro que desea eliminar este Becario?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









