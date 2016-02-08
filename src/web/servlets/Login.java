package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usuario.Usuario;

/**
 * Servlet implementation class LogIn
 */


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{	    
		     //UserBean user = new UserBean();
			nombreUsuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("contrasenia");
			Array recetas [];
			Usuario user = new Usuario();

			if(nombreUsuario.equals("admin") && contrasenia.equals("admin")){
		         HttpSession session = request.getSession(true);	    
		         session.setAttribute("currentSessionUser",nombreUsuario); 
		         response.sendRedirect("welcome.jsp?usuario=admin&datos=0");
		     }else{
		    	 //validar si existe el usuario
//		    	 for(int i; i <= 3; i++){
//		    		 recetas[i] = user.buscarMisRecetas();
//		    	 }
		    	 response.sendRedirect("login.jsp");
		     }
		    	 
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

}
 