package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.ScreeningMovie;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class ScreeningMovieDAO {
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
    public void saveData(ScreeningMovie o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){
        }
        end();
    }
    @Transactional
    public void removeData(ScreeningMovie o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(ScreeningMovie o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<ScreeningMovie> getData() {
        start();
        try {
            TypedQuery<ScreeningMovie> query = session.createQuery("select u from ScreeningMovie u", ScreeningMovie.class);
            List<ScreeningMovie> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public ScreeningMovie getUserByID(int id){
        start();
        try {
            TypedQuery<ScreeningMovie> query = session.createQuery("select u from ScreeningMovie u where u.id="+id, ScreeningMovie.class);
            ScreeningMovie result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
