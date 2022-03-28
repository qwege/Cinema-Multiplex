package project.multiplex.Multiplex.Cinema.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> tickets = new ArrayList<>();
    @OneToOne (cascade = CascadeType.DETACH)
    private UserCinema userCinema;

    public Book(){}

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public UserCinema getUser() {
        return userCinema;
    }

    public void setUser(UserCinema userCinema) {
        this.userCinema = userCinema;
    }
    public void addTicket(Ticket t){
        tickets.add(t);
    }
}
