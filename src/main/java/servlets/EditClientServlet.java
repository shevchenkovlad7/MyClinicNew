package servlets;

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
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Влад on 05.01.2016.
 */
@WebServlet(name = "EditClientServlet", urlPatterns = "/edit")
public class EditClientServlet extends HttpServlet {
    private Clinic clinic = Clinic.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = null;
        final AtomicInteger id = new AtomicInteger();
        if(request.getParameter("pets")!= null){
            if(request.getParameter("pets").equals(request.getParameter("dog"))){
                    pet= new Dog(request.getParameter("petName"));
            }
            if(request.getParameter("pets").equals(request.getParameter("cat"))){
                pet = new Cat(request.getParameter("petName"));
            }
            if(request.getParameter("pets").equals(request.getParameter("parrot"))){
                pet = new Parrot(request.getParameter("petName"));
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clinic/ClinicView.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", clinic.getClient(Integer.valueOf(req.getParameter("id"))));
        clinic.removeClientById(Integer.valueOf(req.getParameter("id"))-1);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/clinic/EditClient.jsp");
        dispatcher.forward(req, resp);
    }
}
