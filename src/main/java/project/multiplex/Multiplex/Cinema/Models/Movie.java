package project.multiplex.Multiplex.Cinema.Models;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    @Column (nullable = false,name="title")
    private String title;
    @Column (name="description")
    private String description;

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
