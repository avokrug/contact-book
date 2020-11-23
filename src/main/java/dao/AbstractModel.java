package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public abstract class AbstractModel<T> {

    //  Typed variable for inheritance
    private Class<T> entityClass;

    public AbstractModel() {
    }

    //  Initialize the type
    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //  Method for finding all objects
    public List<T> findAll() {
        //  Opening session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //  Starting a transaction
        Transaction trans = session.beginTransaction();
        //  Send a request
        Query query = session.createQuery("FROM " + entityClass.getName());
        //  Read the answer
        List<T> lst = query.list();
        //  Fix the action
        trans.commit();
        //  Close session
        session.close();
        //  return finding objects
        return lst;
    }

    //  Method for adding an object
    public void add(T entity) throws Exception{
        //  Opening session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //  Starting a transaction
        Transaction trans = session.beginTransaction();
        try {
            // Save object
            session.save(entity);
            //  Fix action
            trans.commit();
        } catch (Exception ex) {
            //  If an error occurs during the transaction, rollback to the previous state
            trans.rollback();
            //  Print error
            ex.printStackTrace();
            // Create exception
            throw new Exception(ex.getMessage());
        }
        session.close();
    }

    //  Method for updating an object
    public void update(T entity) throws Exception{
        //  Opening session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //  Starting a transaction
        Transaction trans = session.beginTransaction();
        try {
            // Update object
            session.update(entity);
            //  Fix action
            trans.commit();
        } catch (Exception ex) {
            //  If an error occurs during the transaction, rollback to the previous state
            trans.rollback();
            //  Print error
            ex.printStackTrace();
            // Create exception
            throw new Exception(ex.getMessage());
        }
        //  Close session
        session.close();
    }

    //  Method for deleting an object
    public void delete(T entity) throws Exception {
        //  Opening session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //  Starting a transaction
        Transaction trans = session.beginTransaction();
        try {
            // Delete object from DB
            session.delete(entity);
            //  Fix action
            trans.commit();
        } catch (Exception ex) {
            //  If an error occurs during the transaction, rollback to the previous state
            trans.rollback();
            //  Print error
            ex.printStackTrace();
            // Create exception
            throw new Exception(ex.getMessage());
        }
        //  Close session
        session.close();
    }
}
