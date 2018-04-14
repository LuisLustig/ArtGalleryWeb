package main.controller;

import main.dao.ArtistDAO;
import main.dao.Config;
import main.domain.Artist;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Пользователь on 06.04.2018.
 */
public class ArtistController {

    public ArtistController()
    {
    }

    public List<Artist> getAll() {
        ArtistDAO dao = new ArtistDAO();
        List<Artist> strings = dao.getAll();
        try {
            Config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public void add(){
    }
}
