package main.dao;

import main.domain.Artist;
import main.domain.Picture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пользователь on 20.03.2018.
 */
public class PictureDAO {

    public static List<Picture> getAll()
    {
        Connection connection = Config.getConnection();
        List<Picture> list = new LinkedList<Picture>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM picture");

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Picture picture = new Picture();
                    picture.setId(rs.getInt(1));
                    picture.setName(rs.getString(2));
                    picture.setDescription(rs.getString(3));
                    picture.setPhoto(rs.getString(4));
                    picture.setTechnique(rs.getString(5));
                    picture.setGenre_id(rs.getInt(6));
                    list.add(picture);
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

    public static Picture get(int id)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        Picture picture = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM picture WHERE id=?");
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                rs.next();
                picture = new Picture();
                picture.setId(rs.getInt(1));
                picture.setName(rs.getString(2));
                picture.setDescription(rs.getString(3));
                picture.setPhoto(rs.getString(4));
                picture.setTechnique(rs.getString(5));
                picture.setGenre_id(rs.getInt(6));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return picture;
        }
    }

    public static void update(Picture picture)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE picture SET name = ?, description = ?, photo = ?, technique = ?, genre_id = ? WHERE id = ?");
            preparedStatement.setString(1, picture.getName());
            preparedStatement.setString(2, picture.getDescription());
            preparedStatement.setString(3, picture.getPhoto());
            preparedStatement.setString(4, picture.getTechnique());
            preparedStatement.setInt(5, picture.getGenre_id());
            preparedStatement.setInt(6, picture.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
        }
    }

    public static void add(Picture picture)
    {
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO picture(name, description, photo, technique, genre_id) values(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, picture.getName());
            preparedStatement.setString(2, picture.getDescription());
            preparedStatement.setString(3, picture.getPhoto());
            preparedStatement.setString(4, picture.getTechnique());
            preparedStatement.setInt(5, picture.getGenre_id());
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
                    "DELETE FROM picture where id = ?");
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
