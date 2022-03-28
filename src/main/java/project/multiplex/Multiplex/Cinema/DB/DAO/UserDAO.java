package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.UserCinema;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


public class UserDAO {
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
    public void saveData(UserCinema o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){
        }
        end();
    }
    @Transactional
    public void removeData(UserCinema o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(UserCinema o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<UserCinema> getData() {
        start();
        try {
            TypedQuery<UserCinema> query = session.createQuery("select u from UserCinema u", UserCinema.class);
            List<UserCinema> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public UserCinema getUserByID(int id){
        start();
        try {
            TypedQuery<UserCinema> query = session.createQuery("select u from UserCinema u where u.id="+id, UserCinema.class);
            UserCinema result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
