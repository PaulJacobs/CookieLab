package prj.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String cookieVal = request.getParameter("cookievalue");
		
		Cookie cookie = new Cookie(request.getParameter("cookiename"),cookieVal);
		// cookie.setMaxAge(2*60); 
		response.addCookie(cookie);
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form action=/CookieLab/CookieServlet method=POST>");
		
		out.println(request.getParameter("cookievalue"));
		out.println("Cookie name: <input type='text' name=cookiename><br>"
				+ "Cookie value: <textarea rows=4 columns=50 name=cookievalue></textarea><br>"
				+ "<input type='submit' value = 'Submit'>"
				+ "");
		

		out.println("</form>");
		
		out.println("</body></html>");

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
