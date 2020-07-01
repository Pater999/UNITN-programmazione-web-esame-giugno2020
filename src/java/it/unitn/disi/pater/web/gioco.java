package it.unitn.disi.pater.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "gioco", urlPatterns = {"/gioco"})
public class gioco extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            
            if(username != null && !username.isEmpty())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", username);
                session.setAttribute("gameMatrix", new MatriceGioco());
                
                String encodedURL = response.encodeRedirectURL("giocaPartita.jsp");
                response.sendRedirect(encodedURL); 
            }
            else
            {
                request.getRequestDispatcher("/index.html").include(request, response);
            }
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
