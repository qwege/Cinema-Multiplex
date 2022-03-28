package project.multiplex.Multiplex.Cinema.DB.Hibernate;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;
import project.multiplex.Multiplex.Cinema.DB.DBConnect;
import project.multiplex.Multiplex.Cinema.Models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImportDataToDB {
    private static List<UserCinema> users = new ArrayList<>();
    private static List<Cinema> cinemas = new ArrayList<>();
    private static List<Seat> seats = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();
    private static List<Movie> movies = new ArrayList<>();
    private static List<ScreeningMovie> screeningMovies = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();

    public static void run() {
        createUsers();
        for (UserCinema user : users) DBConnect.userDAO.saveData(user);
        createSeats();
        createRooms();
        createCinema();
        for (Cinema cinema : cinemas) DBConnect.cinemaDAO.saveData(cinema);
        createMoovies();
        for (Movie movie : movies) DBConnect.movieDAO.saveData(movie);
        createScreeningMoovies();
        for (ScreeningMovie screeningMovie : screeningMovies) DBConnect.screeningMovieDAO.saveData(screeningMovie);
        createTickets();
        createBooks();
        for (Book book : books) DBConnect.bookDAO.saveData(book);



    }


    private static void save() {
        for (UserCinema user : users) DBConnect.userDAO.saveData(user);
        for (Seat seat : seats) DBConnect.seatDAO.saveData(seat);
        for (Room room : rooms) DBConnect.roomDAO.saveData(room);
        for (Cinema cinema : cinemas) DBConnect.cinemaDAO.saveData(cinema);
        for (Movie movie : movies) DBConnect.movieDAO.saveData(movie);
        for (ScreeningMovie screeningMovie : screeningMovies) DBConnect.screeningMovieDAO.saveData(screeningMovie);
        for (Ticket ticket : tickets) DBConnect.ticketDAO.saveData(ticket);
        for (Book book : books) DBConnect.bookDAO.saveData(book);
    }

    private static void createTickets() {
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int smovie = Math.abs(random.nextInt() % 20);
            int seat = Math.abs(random.nextInt() % 62);
            Ticket t1 = new Ticket(screeningMovies.get(smovie), screeningMovies.get(smovie).getRoom().getSeats().get(1 + seat), TypeTicket.ADULT);
            Ticket t2 = new Ticket(screeningMovies.get(smovie), screeningMovies.get(smovie).getRoom().getSeats().get(seat), TypeTicket.STUDENT);
            Ticket t3 = new Ticket(screeningMovies.get(smovie), screeningMovies.get(smovie).getRoom().getSeats().get(2 + seat), TypeTicket.CHILD);
            tickets.add(t1);
            tickets.add(t2);
            tickets.add(t3);
        }

    }

    private static void createCinema() {
        Cinema cinema1 = new Cinema("alfa");
        Cinema cinema2 = new Cinema("beta");
        cinema1.addRoom(rooms.get(0));
        cinema1.addRoom(rooms.get(1));
        cinema1.addRoom(rooms.get(2));
        cinema1.addRoom(rooms.get(3));
        cinema2.addRoom(rooms.get(4));
        cinemas.add(cinema1);
        cinemas.add(cinema2);

    }

    private static void createBooks() {
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.addTicket(tickets.get(i * 3));
            book.addTicket(tickets.get(i * 3 + 1));
            book.addTicket(tickets.get(i * 3 + 2));
            book.setUser(users.get(i % 12));
            books.add(book);
        }
    }

    private static void createScreeningMoovies() {
        for (int i = 0; i < 60; i++) {
            int hour = 12;
            ScreeningMovie screeningMovie = new ScreeningMovie(movies.get(i % 20), rooms.get(i / 12),
                    LocalDateTime.of(2022, 1, 1 + i / 2, hour, 0, 0, 0),
                    LocalDateTime.of(2022, 1, 1 + i / 2, hour + 3, 0, 0, 0)

            );
            screeningMovies.add(screeningMovie);
        }
    }

    private static void createMoovies() {
        for (int i = 1; i < 6; i++) {
            movies.add(new Movie("Shrek " + i));
        }
        for (int i = 1; i < 11; i++) {
            movies.add(new Movie("Fast&Furious " + i));
        }
        for (int i = 1; i < 6; i++) {
            movies.add(new Movie("King Artur " + i));
        }
    }

    private static void createRooms() {
        Room room1 = new Room();
        room1.setNumber("1a");
        Room room2 = new Room();
        room2.setNumber("1b");
        Room room3 = new Room();
        room2.setNumber("2");
        Room room4 = new Room();
        room2.setNumber("3");
        Room room5 = new Room();
        room2.setNumber("1");
        for (int i = 0; i < 320; i++) {
            if (i < 64) room1.addSeat(seats.get(i));
            else if (i < 128) room2.addSeat(seats.get(i));
            else if (i < 192) room3.addSeat(seats.get(i));
            else if (i < 256) room4.addSeat(seats.get(i));
            else room5.addSeat(seats.get(i));

        }
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);


    }

    private static void createSeats() {
        // 5 sal po 64 miejsca

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    seats.add(new Seat(j, k));
                }
            }
        }


    }

    private static void createUsers() {
        users.add(new UserCinema("adam", "sede"));
        users.add(new UserCinema("michał", "pele"));
        users.add(new UserCinema("sebastian", "agry"));
        users.add(new UserCinema("frederyk", "myki"));
        users.add(new UserCinema("cezary", "zeri"));
        users.add(new UserCinema("emilia", "niki"));
        users.add(new UserCinema("kinga", "paki"));
        users.add(new UserCinema("magda", "sere"));
        users.add(new UserCinema("paulina", "cede"));
        users.add(new UserCinema("julia", "polo"));
        users.add(new UserCinema("nick", "kolo"));
        users.add(new UserCinema("jhon", "bode"));

    }
}
