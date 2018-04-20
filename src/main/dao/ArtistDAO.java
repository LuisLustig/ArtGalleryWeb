package main.dao;

import main.domain.Artist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пользователь on 20.03.2018.
 */
public class ArtistDAO {

        public static List<Artist> getAll() {
        Connection connection = Config.getConnection();
        List<Artist> list = new LinkedList<Artist>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM artist");

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Artist artist = new Artist();
                    artist.setId(rs.getInt(1));
                    artist.setName(rs.getString(2));
                    artist.setBio(rs.getString(3));
                    artist.setCountry(rs.getString(4));
                    artist.setBirth_date(rs.getDate(5));
                    artist.setDeath_date(rs.getDate(6));
                    list.add(artist);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return list;
        }
    }

    public static Artist get(int id)  {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        Artist artist = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM artist WHERE id=?");
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                rs.next();
                artist = new Artist();
                artist.setId(rs.getInt(1));
                artist.setName(rs.getString(2));
                artist.setBio(rs.getString(3));
                artist.setCountry(rs.getString(4));
                artist.setBirth_date(rs.getDate(5));
                artist.setDeath_date(rs.getDate(6));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return artist;
        }
    }



    public static boolean update(Artist artist)  {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE artist SET name = ?, bio = ?, country = ?, birth_date = ?, death_date = ? WHERE id = ?");
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getBio());
            preparedStatement.setString(3, artist.getCountry());
            preparedStatement.setDate(4, artist.getBirth_date());
            preparedStatement.setDate(5, artist.getDeath_date());
            preparedStatement.setInt(6,artist.getId());
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
        }
    }

    public static boolean add(Artist artist)  {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO artist(name, bio, country, birth_date, death_date) values(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getBio());
            preparedStatement.setString(3, artist.getCountry());
            preparedStatement.setDate(4, artist.getBirth_date());
            preparedStatement.setDate(5, artist.getDeath_date());
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
        }
    }

    public static boolean delete(int id)  {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM artist where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
        }
    }
}
