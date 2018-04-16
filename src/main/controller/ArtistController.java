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

    public static List<Artist> getAll() {
        List<Artist> strings = ArtistDAO.getAll();
        try {
            Config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static void add(String name, String bio, String country, Date bdate, Date ddate){
        ArtistDAO.add(new Artist(name, bio, country, bdate, ddate));
        try {
            Config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(Artist artist){
        ArtistDAO.add(artist);
        try {
            Config.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
