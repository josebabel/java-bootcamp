<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${juego.nombre}</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<div class="flex flex-col items-center mt-10">
		<div class="w-96 rounded-md overflow-hidden shadow-md bg-white">
			<div>
				<img alt="img" src="${juego.foto}">
			</div>
			<div class="bg-white p-3">
				<h3 class="text-xl font-medium mb-3">${juego.nombre}</h3>
				<p class="text-gray-600">${juego.compania}</p>
				<p class="text-gray-600">${juego.creador}</p>
				<p class="text-gray-600">Nota: ${juego.nota}</p>
				<p class="text-gray-600">${juego.precio}&euro;</p>
				<a href="${juego.enlace}" target="_blank">Web Oficial</a>
			</div>
			<div class="grid grid-cols-3">
				<a href="cart/add?id=${juego.id}" class="hover:bg-gray-200 py-2 text-center">
					<span class="material-icons"> add_shopping_cart </span>
				</a>
				<a href="edit_videojuego?id=${juego.id}" class="hover:bg-gray-200 py-2 text-center">
					<span class="material-icons"> edit </span>
				</a>
				<a href="delete_videojuego?id=${juego.id}" class="hover:bg-gray-200 py-2 text-center">
					<span class="material-icons"> delete </span>
				</a>
			</div>
		</div>
		<div>
			<a href="listar_videojuegos"
				class="inline-block bg-indigo-600 py-2 px-4 m-4 text-white font-semibold rounded-md shadow-md hover:bg-indigo-800">Volver</a>
		</div>
	</div>
</body>
</html>