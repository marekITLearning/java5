package sk.itlearning.java5.create.wba1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApp1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		displayDynamicPage(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		displayDynamicPage(req, resp);
	}
	
	private void displayDynamicPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.getOutputStream().println("<table>");

		resp.getOutputStream().println("<tr>");
		resp.getOutputStream().println("<td>cislo</td><td>meno</td>");
		resp.getOutputStream().println("</tr>");
		
		resp.getOutputStream().println("<tr>");
		resp.getOutputStream().println("<td>11234</td><td>Jozo</td>");
		resp.getOutputStream().println("</tr>");
		
		resp.getOutputStream().println("</table>");
		
	}

}
