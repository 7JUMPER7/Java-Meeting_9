package com.arseniisemenov.hibernateapp.models;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "citizens")
    private int citizens;
    @Column(name = "story")
    private String story;
    @Column(name = "coordinates")
    private String coordinates;

    public City() { }
    public City(String name, int citizens, String story, String coordinates) {
        this.name = name;
        this.citizens = citizens;
        this.story = story;
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCitizens() {
        return citizens;
    }
    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    public String getStory() {
        return story;
    }
    public void setStory(String story) {
        this.story = story;
    }

    public String getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citizens=" + citizens +
                ", story='" + story + '\'' +
                ", coordinates='" + coordinates + '\'' +
                '}';
    }
}
