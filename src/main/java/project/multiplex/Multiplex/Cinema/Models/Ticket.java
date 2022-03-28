package project.multiplex.Multiplex.Cinema.Models;

import org.hibernate.type.LocalDateType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToOne
    private ScreeningMovie screeningMovie;
    @OneToOne
    private Seat seat;
    @Column (nullable = false , name = "type")
    private TypeTicket type;
    @Column (nullable = false , name = "cost")
    private int cost;
    @Column (name = "time_expired")
    private LocalDateTime timeExpired;

    public Ticket() {
    }

    public Ticket(ScreeningMovie screeningMovie, Seat seat, TypeTicket type) {
        this.screeningMovie = screeningMovie;
        this.seat = seat;
        this.type = type;
        timeExpired=LocalDateTime.now();
        timeExpired.plusDays(3);
    }

    public ScreeningMovie getScreeningMovie() {
        return screeningMovie;
    }

    public void setScreeningMovie(ScreeningMovie movie) {
        this.screeningMovie = movie;
    }


    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public TypeTicket getType() {
        return type;
    }

    public void setType(TypeTicket type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDateTime getTimeExpired() {
        return timeExpired;
    }

    public void setTimeExpired(LocalDateTime timeExpired) {
        this.timeExpired = timeExpired;
    }
}
