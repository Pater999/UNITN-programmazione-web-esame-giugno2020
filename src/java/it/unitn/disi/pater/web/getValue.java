package it.unitn.disi.pater.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "getValue", urlPatterns = {"/getValue"})
public class getValue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String r = request.getParameter("riga");
        String c = request.getParameter("colonna");
        if (r != null && c != null) {
            int riga = Integer.parseInt(r);
            int colonna = Integer.parseInt(c);
            if (riga >= 0 && riga < 9 && colonna >= 0 && colonna < 9) {
                HttpSession session = request.getSession();
                int valore = ((MatriceGioco) session.getAttribute("gameMatrix")).getValore(riga, colonna);

                response.setContentType("application/json;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("{\"valore\": " + valore + "}");
                }
            } else {
                response.sendError(404);
            }
        }
        else
        {
            response.sendError(404);
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
