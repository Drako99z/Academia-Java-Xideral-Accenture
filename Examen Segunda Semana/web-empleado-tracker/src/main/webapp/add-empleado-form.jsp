<!DOCTYPE html>
<html>

<head>
	<title>Agregar Empleado</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Xideral</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Agregar Empleado</h3>
		
		<form action="EmpleadoControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="apellido" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><input type="text" name="correo" /></td>
					</tr>
					
					<tr>
						<td><label>Teléfono:</label></td>
						<td><input type="text" name="telefono" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="EmpleadoControllerServlet">Volver a la lista</a>
		</p>
	</div>
</body>

</html>











