package controler;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Calculator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/IMCResult")
public class CalculateIMC extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			String name = request.getParameter("name");
			Double weight = Double.parseDouble(request.getParameter("weight"));
			Double height = Double.parseDouble(request.getParameter("height"));
	    
			out.println("<html>");
			out.println("<body>");
			out.println("<fieldset>");
			out.println("<legend>Result:</legend>");
			out.println("<h3>" + name + " you are " + Calculator.imcCalculate(weight, height) + "</h1>");
			out.println("</fieldset>");
			out.println("</body>");
			out.println("</html>");	
		}
	}
}
