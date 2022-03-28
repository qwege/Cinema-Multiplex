package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.Seat;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class SeatDAO {
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
    public void saveData(Seat o) {
        start();
        try{
        session.persist(o);
        }catch (EntityExistsException e){
        }
        end();
    }
    @Transactional
    public void removeData(Seat o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(Seat o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<Seat> getData() {
        start();
        try {
            TypedQuery<Seat> query = session.createQuery("select u from Seat u", Seat.class);
            List<Seat> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public Seat getUserByID(int id){
        start();
        try {
            TypedQuery<Seat> query = session.createQuery("select u from Seat u where u.id="+id, Seat.class);
            Seat result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
