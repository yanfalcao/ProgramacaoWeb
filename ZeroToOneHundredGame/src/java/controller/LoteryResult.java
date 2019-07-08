package controller;

import business.Game;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Lotery")
public class LoteryResult extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            int numberEntered = Integer.parseInt(request.getParameter("numberEntered"));
            int attempts;
            
            HttpSession session = request.getSession();
            Game game = (Game)session.getAttribute("game");
        
            if(game == null){
                game = new Game();
                session.setAttribute("game", game);
            }
            
            attempts = game.getAttempts();
            
            out.println("<html>");
            out.println("<body>");
            out.println("<fieldset>");
            out.println("<legend>Result:</legend>");
            out.println("<br><h3>" + game.verify(numberEntered) + "</h3><br>");
            out.println("<h3> You tried " + game.getAttempts() + " time(s)</h3><br>");
            out.println("</fieldset>");
	    out.println("</body>");
            out.println("</html>");
        }
    }
    
}
