<%@page import="es.curso.modelo.entidad.Videojuego"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videogames</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body class="bg-gray-100">

	<div class="container mx-auto px-4">
		<h1
			class="text-center font-semibold text-2xl bg-indigo-600 text-white py-3 rounded-md shadow-md">Videojuegos</h1>

		<div class="py-4 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-3">

			<c:forEach var="juego" items="${listado}">
				<div class="rounded-md overflow-hidden shadow-md bg-white">
					<div>
						<img alt="img" src="<c:out value="${juego.foto}"></c:out>">
					</div>
					<div class="bg-white p-3">
						<h3 class="text-xl font-medium mb-3">
							<c:out value="${juego.nombre}"></c:out>
						</h3>
						<p class="text-gray-600">
							<c:out value="${juego.compania}"></c:out>
						</p>
						<p class="text-gray-600">
							Nota:
							<c:out value="${juego.nota}"></c:out>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>

		<div class="w-52">
			<h2 class="text-xl font-medium mb-3 text-center">Buscador</h2>

			<form action="videojuego_detalle" method="GET" class="space-y-3">
				<div>
					<label for="busqueda" class="sr-only">Email address</label> <input
						id="busqueda" name="id" type="number" required
						class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
						placeholder="Introduce ID">
				</div>

				<div>
					<button type="submit"
						class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Buscar</button>
				</div>
			</form>
			
			<p class="text-red-500 text-center mt-4">${(error) ? "No existe ese ID" : ""}</p>
		</div>


	</div>
</body>
</html>