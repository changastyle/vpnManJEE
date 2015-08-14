package model.daos;

import java.util.ArrayList;
import model.Radcheck;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AbstractDAO
{
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    
    public static int save(Object object)
    {
        int id = 0;
        sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        
        try
        {
            transaction = session.beginTransaction();
            id = (int) session.save(object);
            transaction.commit();
            
            session.close();
        }
        catch(Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("ERROR: ABSTRACTDAO -> save: " + object);
        }
        return id;
    }
    public static ArrayList<Object> findAll(Class clase)
    {
        ArrayList<Object> arrRespuesta = new ArrayList<Object>();
        sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        
        try 
        {
            //transaction = session.beginTransaction();
            Query query = session.createQuery("from " + clase.getName());
            arrRespuesta = (ArrayList<Object>) query.list();
            //transaction.commit();
            session.close();
        } 
        catch (Exception e) 
        {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("ERROR: ABSTRACTDAO -> findAll: " + clase.getName());
        }
        
        return arrRespuesta;
    }
    public static ArrayList<Object> findAll(String sql)
    {
        ArrayList<Object> arrRespuesta = new ArrayList<Object>();
        sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        
        try 
        {
            //transaction = session.beginTransaction();
            Query query = session.createQuery(sql);
            arrRespuesta = (ArrayList<Object>) query.list();
            //transaction.commit();
            session.close();
        } 
        catch (Exception e) 
        {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("ERROR: ABSTRACTDAO -> findAll: " + sql );
        }
        
        return arrRespuesta;
    }
    public static Object get(Class clase ,int id)
    {
        Object result = null;
        
        sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        
        result = session.get(clase, id);
        
        session.close();
        
        return result;
    }
}
