

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


@WebServlet("/Sepet1")
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
		
		
		List<String> items = new ArrayList<>(); 
		
		String id = request.getParameter("product");
		String itemsid = "";
		boolean find = false;
		
		
		Cookie[] cookies = request.getCookies(); //Tüm cookieleri alıyoruz
		if(cookies != null) {
			for(Cookie c: cookies) {
				if((c.getName().equals("items")) == true) { //Alınan cookilerin içinden ismi formdan girilen isme eş olanı varsa alıyoruz
					itemsid = c.getValue();
					if(id != null) {
						c.setValue(c.getValue() + id); //bir arttırıp yeni değeri yapıyoruz
						itemsid = c.getValue() + id;
						response.addCookie(c); //cookie yi gönderiyoruz
					}
					
					find = true; //istediğimiz cookieyi bulduğumuzu belirtiyoruz ki 51. satırdaki if yapısı çalışmasın.
					break;
				}
			}
		}
		
		if(find == false) { 
			Cookie cookie = new Cookie("items", "");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		
		for(String i: itemsid.split("")) {
			System.out.println(i);
			items.add(i);
		}
		
		request.setAttribute("items", items);
		RequestDispatcher dispatcher = request.getRequestDispatcher("eshopper/cart.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
