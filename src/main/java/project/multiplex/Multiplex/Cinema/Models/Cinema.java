package project.multiplex.Multiplex.Cinema.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false, name = "name")
    private String name;
    @OneToMany(mappedBy = "cinema" , cascade = CascadeType.ALL,fetch = FetchType.EAGER , orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    public Cinema() {
    }
    public Cinema(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setCinema(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
