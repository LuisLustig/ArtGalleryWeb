package main.Servlets;

import main.controller.ArtistController;
import main.controller.GenreController;
import main.domain.Artist;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Пользователь on 15.04.2018.
 */
@WebServlet("/GenreServlet")
public class GenreServlet extends HttpServlet  {
    protected void forward(String address, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("WINDOWS-1251");
        request.setCharacterEncoding("UTF-8");
        ServletContext ctx = request.getServletContext();
        if (request.getParameter("add")!=null) {
            String name = request.getParameter("name");

            String description = request.getParameter("description");

            String type = request.getParameter("type");

            if(GenreController.add(name, description, type)) this.forward("/genres.jsp", request, response);
            else this.forward("/error.jsp?type=0", request, response);
        }
        else if (request.getParameter("delete")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            if(GenreController.delete(id)) this.forward("/genres.jsp", request, response);
            else this.forward("/error.jsp?type=1", request, response);
        }
        else if (request.getParameter("update")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");

            String description = request.getParameter("description");

            String type = request.getParameter("type");

            if(GenreController.update(id,name, description, type)) this.forward("/genres.jsp", request, response);
            else
            {
                this.forward("/error.jsp?type=2", request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
