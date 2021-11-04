<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videojuegos</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body class="bg-gray-100">

	<div class="container mx-auto px-4">
		<h1
			class="text-center font-semibold text-2xl bg-indigo-600 text-white py-3 rounded-md shadow-md">Videojuegos
			${user.nombre}</h1>

		<div class="text-right px-4 mt-4">
			<a href="cart"> <span class="material-icons" style="font-size: 2rem">
					shopping_cart </span>
			</a>
		</div>

		<div
			class="py-4 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-3">

			<c:forEach var="juego" items="${listado}">
				<div class="rounded-md overflow-hidden shadow-md bg-white h-96">
					<div>
						<img class="max-h-56" alt="img" src="<c:out value="${juego.foto}"></c:out>">
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
						<a href="videojuego_detalle?id=${juego.id}"
							class="text-blue-500 hover:text-blue-700">Ver mas</a>
					</div>
				</div>
			</c:forEach>

			<div
				class="rounded-md overflow-hidden shadow-md bg-white flex justify-center items-center h-96">
				<a href="add_videojuego"> <span class="material-icons"
					style="font-size: 4rem"> add_circle_outline </span>
				</a>
			</div>
		</div>


	</div>
</body>
</html>