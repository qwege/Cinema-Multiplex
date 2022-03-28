package project.multiplex.Multiplex.Cinema.DB.DAO;

import org.hibernate.Session;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.HibernateUtil;
import project.multiplex.Multiplex.Cinema.Models.Book;

import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class BookDAO {
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
    public void saveData(Book o) {
        start();
        try{
            session.persist(o);
        }catch (EntityExistsException e){
        }
        end();
    }
    @Transactional
    public void removeData(Book o) {
        start();
        session.remove(o);
        end();
    }
    @Transactional
    public void updateData(Book o) {
        start();
        session.update(o);
        end();
    }
    @Transactional
    public List<Book> getData() {
        start();
        try {
            TypedQuery<Book> query = session.createQuery("select u from Book u", Book.class);
            List<Book> result = query.getResultList();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
    @Transactional
    public Book getUserByID(int id){
        start();
        try {
            TypedQuery<Book> query = session.createQuery("select u from Book u where u.id="+id, Book.class);
            Book result = query.getSingleResult();
            end();
            return result;
        }
        catch (IllegalStateException e){
            throw new RuntimeException("Database Session Exception");
        }
    }
}
