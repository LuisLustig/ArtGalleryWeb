package main.dao;

import main.domain.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by Пользователь on 20.03.2018.
 */
public class GenreDAO {

    public static List<Genre> getAll()
    {
        Connection connection = Config.getConnection();
        List<Genre> list = new LinkedList<Genre>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM genre");

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Genre genre = new Genre();
                    genre.setId(rs.getInt(1));
                    genre.setName(rs.getString(2));
                    genre.setDescription(rs.getString(3));
                    genre.setType(rs.getString(4));
                    list.add(genre);
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

    public static Genre get(int id)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        Genre genre = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM genre WHERE id=?");
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                rs.next();
                genre = new Genre();
                genre.setId(rs.getInt(1));
                genre.setName(rs.getString(2));
                genre.setDescription(rs.getString(3));
                genre.setType(rs.getString(4));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return genre;
        }
    }

    public static void update(Genre genre)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE genre SET name = ?, description = ?, type = ? WHERE id = ?");
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setString(2, genre.getDescription());
            preparedStatement.setString(3, genre.getType());
            preparedStatement.setInt(4, genre.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
        }
    }

    public static void add(Genre genre)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO genre(name, description, type) values(?, ?, ?)");
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setString(2, genre.getDescription());
            preparedStatement.setString(3, genre.getType());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
        }
    }

    public static void delete(int id)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM genre where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
        }
    }
}
