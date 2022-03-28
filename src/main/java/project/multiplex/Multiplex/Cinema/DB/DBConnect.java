package project.multiplex.Multiplex.Cinema.DB;

import project.multiplex.Multiplex.Cinema.DB.DAO.*;


public class DBConnect {
    public static BookDAO bookDAO = new BookDAO();
    public static CinemaDAO cinemaDAO = new CinemaDAO();
    public static MovieDAO movieDAO = new MovieDAO();
    public static RoomDAO roomDAO = new RoomDAO();
    public static ScreeningMovieDAO screeningMovieDAO = new ScreeningMovieDAO();
    public static SeatDAO seatDAO =new SeatDAO();
    public static TicketDAO ticketDAO = new TicketDAO();
    public static UserDAO userDAO = new UserDAO();

}
