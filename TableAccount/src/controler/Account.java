package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Calculator;

@WebServlet("/AccountResult")
public class Account extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
			double total = Double.parseDouble(request.getParameter("total"));
			double tipPercentage = Double.parseDouble(request.getParameter("tip"));
			
			out.println("<html>");
			out.println("<body>");
			out.println("<fieldset>");
			out.println("<legend>Resultado da Conta:</legend>");
			out.println("<h3> Valor total: " + Calculator.totalExpense(total, tipPercentage) + "</h3><br>");
			out.println("<h3> Valor por pessoa: " + Calculator.totalPerPerson(numberOfPeople, total, tipPercentage) + "</h3>");
			out.println("</fieldset>");
			out.println("</body>");
			out.println("</html>");	
		}
	}
}
