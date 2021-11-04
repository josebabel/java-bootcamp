<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ${juego.nombre}</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="flex justify-center mt-10">

		<div class="mt-5 md:mt-0 md:col-span-2 shadow-md">
			<form action="add_videojuego_gestor" method="POST">
				<div class="shadow overflow-hidden sm:rounded-md">
					<div class="px-4 py-5 bg-white sm:p-6">
						<div class="grid grid-cols-6 gap-6">
							<input type="hidden" name="id" value="${juego.id}" />
							<div class="col-span-6">
								<label for="nombre"
									class="block text-sm font-medium text-gray-700">Nombre</label>
								<input type="text" name="nombre" id="nombre" value="${juego.nombre}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>

							<div class="col-span-6 sm:col-span-3">
								<label for="compania"
									class="block text-sm font-medium text-gray-700">Compania</label>
								<input type="text" name="compania" id="compania" value="${juego.compania}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>

							<div class="col-span-6 sm:col-span-3">
								<label for="creador"
									class="block text-sm font-medium text-gray-700">Creador</label>
								<input type="text" name="creador" id="creador" value="${juego.creador}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>

							<div class="col-span-6 sm:col-span-3">
								<label for="nota"
									class="block text-sm font-medium text-gray-700">Nota</label> <input
									type="number" name="nota" id="nota" value="${juego.nota}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>

							<div class="col-span-6 sm:col-span-3">
								<label for="precio"
									class="block text-sm font-medium text-gray-700">Precio</label>
								<input type="number" name="precio" id="precio" value="${juego.precio}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>

							<div class="col-span-6">
								<label for="foto"
									class="block text-sm font-medium text-gray-700">Foto</label> <input
									type="text" name="foto" id="foto" value="${juego.foto}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>

							<div class="col-span-6">
								<label for="enlace"
									class="block text-sm font-medium text-gray-700">Enlace</label>
								<input type="text" name="enlace" id="enlace" value="${juego.enlace}" required
									class="mt-1 appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm">
							</div>
						</div>
					</div>
					<div class="px-4 py-3 bg-gray-50 text-right sm:px-6">
						<a href="listar_videojuegos"
							class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Volver</a>
						<button type="submit"
							class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
							Guardar</button>
					</div>
				</div>
			</form>
		</div>

	</div>
</body>
</html>