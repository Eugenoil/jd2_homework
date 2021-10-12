package by.academy.it;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("")
public class CountVisitServlet extends HttpServlet {
    private volatile int visitsCounter;

    @Override
    public void init() {
        visitsCounter = 0;
    }

    synchronized void increaseAmountOfVisits() {
        visitsCounter++;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        increaseAmountOfVisits();

        //file will be in this filepath of %DISK%:tmp/test/visitCounter.txt
        File dir = new File("tmp/text");
        dir.mkdirs();
        File tmp = new File(dir, "visitCounter.txt");
        tmp.createNewFile();
        try (FileWriter fileWriter = new FileWriter(tmp, false)) {
            fileWriter.write("Visit amount: " + visitsCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");

        try {
            PrintWriter writer = response.getWriter();
            writer.println("<html>" +
                    "<head>" +
                    "<title>" + "Count Visit" +
                    "</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Visits amount: </h1>" +
                    visitsCounter +
                    "</body>" +
                    "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
