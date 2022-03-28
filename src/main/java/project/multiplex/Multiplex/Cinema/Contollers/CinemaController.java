package project.multiplex.Multiplex.Cinema.Contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.multiplex.Multiplex.Cinema.DB.DBConnect;
import project.multiplex.Multiplex.Cinema.Models.Cinema;

import java.util.List;

@RestController
public class CinemaController {
    @RequestMapping("/CinemaShowAll")
    public List<Cinema> showAll(){
        return DBConnect.cinemaDAO.getData();
    }
}
