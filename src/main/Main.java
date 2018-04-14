package main;

import main.controller.ArtistController;
import main.dao.ArtistDAO;
import main.domain.Artist;

import java.sql.*;
import java.util.List;

public class Main {
    private static String url = "jdbc:postgresql://localhost/Gallery";
    private static String login = "Root";
    private static String password = "root";
    public static void main(String[] args) {
        ArtistController controller = new ArtistController();
        List<Artist> all = controller.getAll();
        for(Artist artist: all)
        {
            System.out.println(artist.getName());
        }
        all = controller.getAll();
        for(Artist artist: all)
        {
            System.out.println(artist.getName());
        }
    }
}
