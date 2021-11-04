<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body>
	<div
		class="min-h-full flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
		<div class="max-w-md w-full space-y-8">
			<div>
				<h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
					Sign up a new account</h2>
			</div>
			<form class="mt-8 space-y-6" action="registerUser" method="POST">
				<input type="hidden" name="remember" value="true">
				<div class="rounded-md shadow-sm -space-y-px">
					<div>
						<label for="usuario" class="sr-only">Username</label> <input
							id="usuario" name="usuario" type="text" required
							class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
							placeholder="User">
					</div>
					<div>
						<label for="password" class="sr-only">Password</label> <input
							id="password" name="password" type="password"
							autocomplete="current-password" required
							class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
							placeholder="Password">
					</div>
				</div>

				<div>
					<button type="submit"
						class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Sign
						up</button>
				</div>
				<div class="text-center">
					<p>
						Already have an account? <a href="login" class="text-blue-500 hover:text-blue-700">Sign in</a>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>