package project.multiplex.Multiplex.Cinema.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class ScreeningMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToOne (cascade = CascadeType.DETACH)
    private Movie movie;
    @OneToOne (cascade = CascadeType.DETACH)
    private Room room;
    @Column (name="time_Start")
    private LocalDateTime timeStart;
    @Column (name="time_end")
    private LocalDateTime timeEnd;

    public ScreeningMovie() {
    }

    public ScreeningMovie(Movie movie, Room room, LocalDateTime timeStart, LocalDateTime timeEnd) {
        this.movie = movie;
        this.room = room;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }
}
