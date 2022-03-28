package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.Ticket;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class TicketDAO  {
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
    public void saveData(Ticket o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){
        }
        end();
    }
    @Transactional
    public void removeData(Ticket o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(Ticket o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<Ticket> getData() {
        start();
        try {
            TypedQuery<Ticket> query = session.createQuery("select u from Ticket u", Ticket.class);
            List<Ticket> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public Ticket getUserByID(int id){
        start();
        try {
            TypedQuery<Ticket> query = session.createQuery("select u from Ticket u where u.id="+id, Ticket.class);
            Ticket result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}

