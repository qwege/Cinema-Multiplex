package project.multiplex.Multiplex.Cinema.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false, name = "row_number")
    private int rowNumber;
    @Column(nullable = false, name = "seat_number")
    private int seatNumber;
    @Column(nullable = false, name = "is_booked")
    private boolean isBooked;
    @ManyToOne (cascade = CascadeType.ALL)
    @JsonIgnore
    private Room room;

    public Seat() {
    }
    public Seat(int row,int seat){
        setRowNumber(row);
        setSeatNumber(seat);
        setBooked(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
