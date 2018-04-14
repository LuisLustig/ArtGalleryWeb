package main.domain;

import java.sql.Date;

/**
 * Created by Пользователь on 09.03.2018.
 */
public class Artist {
    private int id;
    private String name;
    private String bio;
    private String country;
    private Date birth_date;
    private Date death_date;

    public Artist(String name, String bio, String country, Date birth_date, Date death_date) {
        setName(name);
        setId(id);
        setBio(bio);
        setCountry(country);
        setBirth_date(birth_date);
        setDeath_date(death_date);
    }

    public Artist()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getDeath_date() {
        return death_date;
    }

    public void setDeath_date(Date death_date) {
        this.death_date = death_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
