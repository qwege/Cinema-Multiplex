package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.Room;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class RoomDAO {
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
    public void saveData(Room o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){

        }
        end();
    }
    @Transactional
    public void removeData(Room o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(Room o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<Room> getData() {
        start();
        try {
            TypedQuery<Room> query = session.createQuery("select u from Room u", Room.class);
            List<Room> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public Room getUserByID(int id){
        start();
        try {
            TypedQuery<Room> query = session.createQuery("select u from Room u where u.id="+id, Room.class);
            Room result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
