package main.domain;

import java.sql.Date;

/**
 * Created by Пользователь on 20.03.2018.
 */
public class ArtistPicture {
    private int picture_id;
    private Date year;
    private int artist_id;

    public ArtistPicture() {
    }


    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }
}
