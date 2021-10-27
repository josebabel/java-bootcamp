<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${game.nombre}</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="flex flex-col items-center mt-10">
		<div class="w-96 rounded-md overflow-hidden shadow-md bg-white">
			<div>
				<img alt="img" src="${game.foto}">
			</div>
			<div class="bg-white p-3">
				<h3 class="text-xl font-medium mb-3">${game.nombre}</h3>
				<p class="text-gray-600">${game.compania}</p>
				<p class="text-gray-600">Nota: ${game.nota}</p>
				<p class="text-gray-600">${game.creador}</p>
				<a href="${game.enlace}" target="_blank">Web Oficial</a>
			</div>
		</div>
		<div>
			<a href="listar_videojuegos" class="inline-block bg-indigo-600 py-2 px-4 m-4 text-white font-semibold rounded-md shadow-md hover:bg-indigo-800">Volver</a>
		</div>
	</div>
</body>
</html>