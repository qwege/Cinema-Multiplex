package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.Cinema;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class CinemaDAO {
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
    public void saveData(Cinema o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){
        }
        end();
    }
    @Transactional
    public void removeData(Cinema o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(Cinema o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<Cinema> getData() {
        start();
        try {
            TypedQuery<Cinema> query = session.createQuery("select u from Cinema u", Cinema.class);
            List<Cinema> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public Cinema getUserByID(int id){
        start();
        try {
            TypedQuery<Cinema> query = session.createQuery("select u from Cinema u where u.id="+id, Cinema.class);
            Cinema result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
