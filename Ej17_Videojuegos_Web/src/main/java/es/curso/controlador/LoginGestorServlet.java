package es.curso.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.negocio.LoginGestor;

@WebServlet("/LoginGestor")
public class LoginGestorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginGestorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(LoginGestor.isAccess()) {
			response.sendRedirect(request.getContextPath() + "/listar_videojuegos");
			
		} else {
			LoginGestor loginGestor = new LoginGestor();
			
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			
			boolean res = loginGestor.checkCreadentials(user, password);
			if(res) {
				LoginGestor.setAccess(true);
				response.sendRedirect(request.getContextPath() + "/listar_videojuegos");
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
