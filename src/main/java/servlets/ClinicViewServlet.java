package servlets;

import model.Client;
import model.Clinic;
import model.animals.Cat;
import model.animals.Dog;
import model.animals.Parrot;
import model.animals.Pet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Влад on 28.11.2015.
 */
@WebServlet(name = "ClinicViewServlet", urlPatterns = "/add")
public class ClinicViewServlet extends HttpServlet {
    private Clinic clinic = Clinic.getInstance();
    final AtomicInteger ids = new AtomicInteger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = null;
        if (request.getParameter("pets") != null) {
            if (request.getParameter("pets").equals("dog")) {
                pet = new Dog(request.getParameter("petName"));
            }
            if (request.getParameter("pets").equals(("cat"))) {
                pet = new Cat(request.getParameter("petName"));
            }
            if (request.getParameter("pets").equals("parrot")) {
                pet = new Parrot(request.getParameter("petName"));
            }

        }
        if (request.getParameter("clientName") != null && !request.getParameter("petName").isEmpty()) {
            clinic.addClient(new Client(ids.incrementAndGet(),request.getParameter("clientName"),pet));
        }
        request.setAttribute("clinic",clinic);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/clinic/ClinicView.jsp");
        dispatcher.forward(request,response);
    }
}