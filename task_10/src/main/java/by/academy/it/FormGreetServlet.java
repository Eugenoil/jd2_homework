package by.academy.it;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/servlet")
public class FormGreetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        if (Objects.equals(name, "")) {
            out.println("<html><body><h1>Error: Name field is empty.</h1>");
            out.println("<h1>Please enter the name</h1></body><html>");
        } else if (Objects.equals(phone, "") && Objects.equals(email, "")) {
            out.println("<html><body><h1>Error: Contact fields are empty.</h1>");
            out.println("<h1>Please enter the phone and email</h1></body><html>");
        } else {
            out.println("<html><head><title>Greet Servlet</title></head>");
            out.println("<body><h1>Hello dear " + name + "</h1>");
            out.println("Phone number: " + phone);
            out.println("Email: " + email);
            out.println("</body></html>");
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
