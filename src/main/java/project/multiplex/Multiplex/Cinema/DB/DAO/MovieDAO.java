package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.Movie;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class MovieDAO {
    private static Session session;

    private void start() {
        try {
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
        }catch (IllegalStateException ignored){
        }
    }


    public void end() {
        session.getTransaction().commit();
        session.close();

    }
    @Transactional
    public void saveData(Movie o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){

        }
        end();
    }
    @Transactional
    public void removeData(Movie o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(Movie o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<Movie> getData() {
        start();
        try {
            TypedQuery<Movie> query = session.createQuery("select u from Movie u", Movie.class);
            List<Movie> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public Movie getUserByID(int id){
        start();
        try {
            TypedQuery<Movie> query = session.createQuery("select u from Movie u where u.id="+id, Movie.class);
            Movie result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
