package main.controller;

import main.dao.PictureDAO;
import main.domain.Picture;

import java.util.List;

/**
 * Created by Пользователь on 06.04.2018.
 */
public class PictureController {
    public static List<Picture> getAll()
    {
        List<Picture> list = PictureDAO.getAll();
        return  list;
    }

    public static boolean add(String name, String description, String photo, String technique, int genre_id, int artist_id)
    {
        Picture picture = new Picture();
        picture.setName(name);
        picture.setDescription(description);
        picture.setPhoto(photo);
        picture.setTechnique(technique);
        picture.setGenre_id(genre_id);
        picture.setArtist_id(artist_id);
        return PictureDAO.add(picture);
    }

    public static boolean update(int id, String name, String description, String photo, String technique, int genre_id, int artist_id)
    {
        Picture picture = new Picture();
        picture.setId(id);
        picture.setName(name);
        picture.setDescription(description);
        picture.setPhoto(photo);
        picture.setTechnique(technique);
        picture.setGenre_id(genre_id);
        picture.setArtist_id(artist_id);
        return PictureDAO.update(picture);
    }
    public static boolean delete(int id)
    {
        return PictureDAO.delete(id);
    }

    public static List<String[]> forShow()
    {
        return PictureDAO.forShow();
    }
}
