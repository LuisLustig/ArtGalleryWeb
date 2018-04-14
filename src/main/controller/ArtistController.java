package main.controller;

import main.dao.ArtistDAO;
import main.dao.Config;
import main.domain.Artist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

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

    public void add(String name, String bio, String country, Date bdate, Date ddate){
        ArtistDAO dao = new ArtistDAO();
        ArtistDAO.add(new Artist(name, bio, country, bdate, ddate));
        try {
            Config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Artist artist){
        ArtistDAO dao = new ArtistDAO();
        ArtistDAO.add(artist);
        try {
            Config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
