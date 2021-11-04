<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<body>
	<div class="container mx-auto">
		<div class="border border-gray-300 my-4 rounded-md">
			<div class="border-b border-gray-300 p-4 flex justify-between">
				<p class="text-2xl font-medium text-gray-700">Shopping cart</p>
				<a href="listar_videojuegos"
					class="text-center py-2 px-4 bg-indigo-600 hover:bg-indigo-800 font-medium text-white rounded-md">Volver</a>
			</div>
			<div class="grid grid-cols-1 md:grid-cols-10">
				<div class="col-span-8">

					<c:forEach var="juego" items="${carrito}">
						<div class="flex m-4">
							<img class="rounded-md"
								src="${juego.foto}"
								alt="logo" width="250">
							<div class="flex flex-col justify-between px-4 ">
								<div>
									<p class="text-xl font-medium">${juego.nombre}</p>
									<p class="text-lg text-gray-600">${juego.compania}</p>
								</div>
								<p class="text-lg text-gray-600 font-medium">${juego.precio}&euro;</p>
							</div>
						</div>
						<hr>
					</c:forEach>

				</div>

				<div class="col-span-2 p-4 border-l border-gray-300">
					<div class="grid grid-rows-3">
						<div>
							<p class="text-lg font-semibold">Items: ${carrito.size()}</p>
						</div>
						<div>
							<p class="text-lg font-semibold">Total: ${total}&euro;</p>
						</div>
						<div>
							<a href="cart/checkout"
								class="block text-center py-2 bg-indigo-600 hover:bg-indigo-800 font-medium text-white rounded-md">Comprar</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>

</html>