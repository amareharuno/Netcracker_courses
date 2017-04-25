package by.netcracker.bsuir.pz2;

import by.netcracker.bsuir.pz2.command.Command;
import by.netcracker.bsuir.pz2.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
         executeQuery(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         executeQuery(request, response);
    }

    private void executeQuery(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        Command command = CommandFactory.INSTANCE.createCommand(request);
        String pathToPage = command.execute(request);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pathToPage);
        dispatcher.forward(request, response);
    }
}
