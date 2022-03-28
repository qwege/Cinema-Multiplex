package project.multiplex.Multiplex.Cinema;

import project.multiplex.Multiplex.Cinema.DB.DAO.UserDAO;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.UserCinema;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        UserDAO userDAO = new UserDAO();
        userDAO.saveData(new UserCinema("adam","mickiewicz"));
        userDAO.saveData(new UserCinema("adam","czeczenski"));
        for(UserCinema user :userDAO.getData()){
            userDAO.removeData(user);
        }

    }
}
