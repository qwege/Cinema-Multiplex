package project.multiplex.Multiplex.Cinema.Contollers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.multiplex.Multiplex.Cinema.DB.DBConnect;
import project.multiplex.Multiplex.Cinema.Models.UserCinema;


import java.util.List;

@RestController
public class UserController {


    @RequestMapping("/CreateUser/{name}/{surname}")
    public boolean createUser(@PathVariable String name, @PathVariable String surname) {
        if (name.length() > 3 && surname.length() > 3) {
            DBConnect.userDAO.saveData(new UserCinema(name, surname));
            return true;
        } else return false;
    }

    @RequestMapping("/ShowUserList")
    public List<UserCinema> getUsers() {
        return DBConnect.userDAO.getData();
    }
}
