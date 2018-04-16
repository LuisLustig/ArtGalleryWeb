package main.controller;

import main.dao.Config;
import main.dao.GenreDAO;
import main.domain.Genre;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Пользователь on 06.04.2018.
 */
public class GenreController {

    public static List<Genre> getAll()
    {
        List<Genre> list = GenreDAO.getAll();
        return  list;
    }

    public static boolean add(String name, String description, String type)
    {
        Genre genre = new Genre();
        genre.setName(name);
        genre.setDescription(description);
        genre.setType(type);
        return GenreDAO.add(genre);
    }

    public static boolean update(int id, String name, String description, String type)
    {
        Genre genre = new Genre();
        genre.setId(id);
        genre.setName(name);
        genre.setDescription(description);
        genre.setType(type);
        return GenreDAO.update(genre);
    }
    public static boolean delete(int id)
    {
        return GenreDAO.delete(id);
    }
}
