package by.academy.it;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

@WebServlet("")
public class CountImageServlet extends HttpServlet {
    private volatile int visitsCounter;

    @Override
    public void init() {
        visitsCounter = 0;
    }

    synchronized void increaseAmountOfVisits() {
        visitsCounter++;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        increaseAmountOfVisits();

        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.BOLD, 48));
        graphics.setColor(Color.RED);
        graphics.drawString("Visits amounts: " + visitsCounter, 100, 100);

        //file will be in this filepath of %DISK%:tmp/count.jpeg
        File outputFile = new File("tmp/count.jpeg");
        ServletOutputStream out = resp.getOutputStream();
        try {
            ImageIO.write(image, "jpeg", out); //write in ServletOutputStream
            ImageIO.write(image, "jpeg", outputFile); //write in File
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


