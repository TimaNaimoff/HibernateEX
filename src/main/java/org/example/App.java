package org.example;


import org.example.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Configuration configuration=new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person.getPersonName() + ":" + person.getPersonAge());
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }
        finally{
            sessionFactory.close();
        }
    }
}
