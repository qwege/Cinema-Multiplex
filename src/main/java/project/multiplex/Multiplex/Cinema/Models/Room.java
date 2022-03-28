package project.multiplex.Multiplex.Cinema.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL,fetch = FetchType.EAGER , orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();
    @Column(name="number_room")
    private String number;
    @ManyToOne
    @JsonIgnore
    private Cinema cinema;

    public Room() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setRoom(this);
    }

}

