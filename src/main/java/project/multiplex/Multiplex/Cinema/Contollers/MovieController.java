package project.multiplex.Multiplex.Cinema.Contollers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import project.multiplex.Multiplex.Cinema.DB.DBConnect;
import project.multiplex.Multiplex.Cinema.Models.Movie;
import project.multiplex.Multiplex.Cinema.Models.ScreeningMovie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {

    @RequestMapping("/CreateMovie/{title}")
    public boolean createUser(@PathVariable String title ) {
            DBConnect.movieDAO.saveData(new Movie(title));
            return true;

    }
    @RequestMapping("/CreateMovie/{title}/{desc}")
    public boolean createUser(@PathVariable String title ,@PathVariable String desc ) {
        DBConnect.movieDAO.saveData(new Movie(title,desc));
        return true;
    }
    // example data param 2022-01-03T10:15:30
    @RequestMapping(value = "/ChooseMovie/{dataStart}/{dataEnd}",method = RequestMethod.GET)
    public List<ScreeningMovie> ChooseMovie(@PathVariable("dataStart")  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  LocalDateTime dataStart,
                                   @PathVariable("dataEnd") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  LocalDateTime dataEnd){
       List<ScreeningMovie>  movies= DBConnect.screeningMovieDAO.getData();
       List<ScreeningMovie> correctmovies = new ArrayList<>();
       for(ScreeningMovie movie :movies){
           if(movie.getTimeStart().isAfter(dataStart) && movie.getTimeEnd().isBefore(dataEnd))
           correctmovies.add(movie);
       }
       return correctmovies;
    }
}
