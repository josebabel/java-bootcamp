package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.LoginGestor;
import es.curso.modelo.negocio.VideojuegoGestor;

@WebServlet("/listar_videojuegos")
public class ListarVideojuegos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarVideojuegos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LoginGestor.isAccess()) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			VideojuegoGestor videojuegoGestor = new VideojuegoGestor();
			List<Videojuego> listVideojuegos = videojuegoGestor.listVideogames();
			
			request.setAttribute("listado", listVideojuegos);
			request.setAttribute("error", VideojuegoGestor.isError());
			VideojuegoGestor.setError(false);
			
			request.getRequestDispatcher("listarVideojuegos.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
