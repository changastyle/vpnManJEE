package model.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AbstractDAO
{
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    
    public static void create(Object object)
    {
        sessionFactory = hibernate.HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        
        try
        {
            transaction = session.beginTransaction();
            
            session.save(object);
            
            transaction.commit();
            
            session.close();
        }
        catch(Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
            System.out.println("ERROR: ABSTRACTDAO -> create: " + object);
        }
    }
}
