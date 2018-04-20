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

    public static List<Artist> getAll()
    {
        List<Artist> list = ArtistDAO.getAll();
        return  list;
    }

    public static boolean add(String name, String country, String bio, Date bdate, Date ddate)
    {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setCountry(country);
        artist.setBio(bio);
        artist.setBirth_date(bdate);
        artist.setDeath_date(ddate);
        return ArtistDAO.add(artist);
    }

    public static boolean update(int id, String name, String country, String bio, Date bdate, Date ddate)
    {
        Artist artist = new Artist();
        artist.setId(id);
        artist.setName(name);
        artist.setCountry(country);
        artist.setBio(bio);
        artist.setBirth_date(bdate);
        artist.setDeath_date(ddate);
        return ArtistDAO.update(artist);
    }
    public static boolean delete(int id)
    {
        return ArtistDAO.delete(id);
    }
}
