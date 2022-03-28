package project.multiplex.Multiplex.Cinema.DB.Hibernate;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import project.multiplex.Multiplex.Cinema.Models.*;


public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {


                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();


               configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Cinema.class);
                configuration.addAnnotatedClass(Movie.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(ScreeningMovie.class);
                configuration.addAnnotatedClass(Seat.class);
                configuration.addAnnotatedClass(Ticket.class);
                configuration.addAnnotatedClass(UserCinema.class);



                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;

    }
}
