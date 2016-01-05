package servlets;

import model.Clinic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 05.01.2016.
 */
@WebServlet(name = "SearchClientServlet", urlPatterns = "/search")
public class SearchClient extends HttpServlet {
    private Clinic clinic = Clinic.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clients",clinic.findClient(request.getParameter("search")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clinic/ClinicView.jsp");
        dispatcher.forward(request, response);
    }
}
