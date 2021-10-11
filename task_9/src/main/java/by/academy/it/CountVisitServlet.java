package by.academy.it;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

        //file will be at source directory of disk
        File dir = new File("tmp/test");
        dir.mkdirs();
        File tmp = new File(dir, "visitCounter.txt");
        tmp.createNewFile();
        try (FileWriter fileWriter = new FileWriter(tmp, false)) {
            fileWriter.write("Visit amount: " + visitsCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");

        String docType = "<!DOCTYPE html>";
        String title = "Visits Counter Demo";
        try {
            PrintWriter writer = response.getWriter();
            writer.println(docType + "<html>" +
                    "<head>" +
                    "<title>" + title +
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
