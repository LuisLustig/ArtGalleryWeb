package main.Servlets;

import main.controller.ArtistController;
import main.domain.Artist;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Пользователь on 11.04.2018.
 */
@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter writer = response.getWriter();
        ArtistController controller = new ArtistController();
        List<Artist> all = controller.getAll();
        for (Artist artist : all) writer.println(artist.getId() + " " + artist.getName());

        writer.close();
    }
}
