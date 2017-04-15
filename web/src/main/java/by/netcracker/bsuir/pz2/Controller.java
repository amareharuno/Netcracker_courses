package by.netcracker.bsuir.pz2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

    public void init() throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("This is ");
        out.print(this.getClass().getName());
        out.print(", using the GET method");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("This is ");
        out.print(this.getClass().getName());
        out.print(", using the POST method");
    }

    public void destroy() {
        super.destroy();
    }
}
