
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginControllerAdmin")
public class LoginControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO adminDao;

    public void init() {
        adminDao = new AdminDAO();
    }
       
    public LoginControllerAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("loginAdmin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            authenticate(request, response);
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	        }
	}
	
    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            dispatcher.forward(request, response);
        } else {
            throw new Exception("Login not successful..");
        }
    }
}
