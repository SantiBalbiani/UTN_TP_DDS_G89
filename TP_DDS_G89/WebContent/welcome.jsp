<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">

<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->

<%  String usuario1 = request.getParameter("usuario");
	String datos [] = request.getParameterValues("datos");
	//Agregar un array en donde vienen los datos restantes, los grupos, las primeras 3 recetas del usuario
	//Las recomendaciones tambien vienen en el array y se muestran las primeras 3/4 de las que esten en la tabla de recestas
%>

<head>
	<meta charset="UTF-8">
	<title>Que Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
</head>

<body>
	<header>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion-kd">
						<span class="sr-only"> Desplegar / Ocultar Menu</span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">Que Comemos Hoy?</a>
				</div>
				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse" id="navegacion-kd">
					<form action="" class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Buscar">
						</div>
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</form>
				</div>


			</div>
		</nav>
	</header>

	<!-- Jumbotron -->

	<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Que Comemos Hoy?</h1>
			<p>Recetas sugeridas para una alimentación saludable</p>
		</div>
	</section>

	<section class="main container">
<!-- Crear las 2 columnas para mostrar los datos -->
<!-- Hacer una seccion para que se puedan ver las recetas del usuario -->
	<div id="columna1">
		<div class="panel panel-default" id="recetasPropias">
			<!-- Asi se muestran lo que se recibe del servlet -->
			<div class="panel-heading">Recetas tuyas, <%=usuario1%></div>
			<div class="panel-body">
				<!-- Buscar las recetas del usuario y poner algunas aca -->
				<% if(datos[0].equals("0")){ %>
					<p>Todavía no tienes ninguna receta!</p>
				<% } else {%>
					<p>Aca se van a mostrar las recetas</p>
				<% } %>
				<a class="btn btn-default" href="nuevaReceta.jsp" role="button" id="nuevaReceta">Crear Nueva Receta</a>
			</div>
		</div>
<!-- Hacer una seccion para que se puedan ver los grupos a los que pertenece el usuario -->
		<div class="panel panel-default" id="grupos">
			<div class="panel-heading">Grupos a los que pertenece</div>
			<div class="panel-body">
				<!-- Buscar los grupos a los que pertenece el usuario -->
			</div>
		</div>
	</div>
<!-- Hacer una seccion para que se puedan ver las recetas recomendadas (en forma de columna a la derecha) -->
	<div id="columna2">
		<div class="panel panel-default" id="recomendaciones">
			<div class="panel-heading">Recomendaciones</div>
			<div class="panel-body">
				<!-- Obtener las recomendaciones -->
			</div>
		</div>
	</div>
	</section>
	<footer></footer>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>