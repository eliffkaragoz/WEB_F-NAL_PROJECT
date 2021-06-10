

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connector.CartConnector;
import Entity.Product;


@WebServlet("/Sepet")
public class Sepet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sepet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println(request.getParameter("product") + " | " +
						   request.getParameter("name") + " | " +
						   request.getParameter("price") + " | " +
						   request.getParameter("urunFotograf"));
		
		
		Product product = new Product(Integer.parseInt(request.getParameter("product")),
									  request.getParameter("name"),
									  Integer.parseInt(request.getParameter("price")),
									  request.getParameter("urunFotograf"));
		
		CartConnector cart = new CartConnector();
		cart.Insert(product);
		
		response.sendRedirect("eshopper/cart.jsp");
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("eshopper/cart.jsp");
		dispatcher.forward(request, response);*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
