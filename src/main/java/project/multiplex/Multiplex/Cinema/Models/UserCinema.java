package project.multiplex.Multiplex.Cinema.Models;

import javax.persistence.*;

@Entity
@Table(name = "User_cinema")
public class UserCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "surname")
    private String surname;

    public UserCinema(String name, String surname) {
        super();
        setName(name);
        setSurname(surname);
    }

    public UserCinema() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();

    }
}
