package main.Servlets;

import main.controller.ArtistController;
import main.domain.Artist;
import javax.servlet.*;
import javax.servlet.http.*;

//import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Пользователь on 15.04.2018.
 */
@WebServlet("/AddArtist")
public class ArtistAdd extends javax.servlet.http.HttpServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("WINDOWS-1251");
        request.setCharacterEncoding("UTF-8");
        ServletContext ctx = request.getServletContext();

        if (request.getParameter("save")!=null){

            String name = request.getParameter("name");

            String bio = request.getParameter("bio");

            String country = request.getParameter("country");

            Artist artist = new Artist();
            artist.setName(name);
            artist.setBio(bio);
            artist.setCountry(country);

            ArtistController artistController = new ArtistController();
            artistController.add(artist);

//            ctx.setAttribute("user", newUser);
//
//            boolean res = UserList.addUser(newUser);
//
//            if (res) {
//
//                this.forward("/successRegistration.jsp", request, response);
//
//            } else {
//
//                this.forward("/errorRegistration.html", request, response);
//
//            }

        } else if (request.getParameter("cancel")!=null){

            //this.forward("/", request, response);

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
