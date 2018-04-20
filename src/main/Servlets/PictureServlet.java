package main.Servlets;

import main.controller.PictureController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by Пользователь on 19.04.2018.
 */
@WebServlet("/PictureServlet")
public class PictureServlet extends HttpServlet {
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
            String photo = request.getParameter("photo");
            String technique = request.getParameter("technique");
            int genre = Integer.parseInt(request.getParameter("genre"));
            int artist = Integer.parseInt(request.getParameter("artist"));
            if(PictureController.add(name, description, photo, technique, genre, artist)) this.forward("/pictures.jsp", request, response);
            else this.forward("/error.jsp?type=0", request, response);
        }
        else if (request.getParameter("delete")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            if(PictureController.delete(id)) this.forward("/pictures.jsp", request, response);
            else this.forward("/error.jsp?type=1", request, response);
        }
        else if (request.getParameter("update")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String photo = request.getParameter("photo");
            String technique = request.getParameter("technique");
            int genre = Integer.parseInt(request.getParameter("genre"));
            int artist = Integer.parseInt(request.getParameter("artist"));
            if(PictureController.update(id, name, description, photo, technique, genre, artist)) this.forward("/pictures.jsp", request, response);
            else
            {
                this.forward("/error.jsp?type=2", request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
