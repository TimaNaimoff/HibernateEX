package org.example.starters;


import org.example.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

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
            List<Person>people=session.createQuery("FROM Person").getResultList();
            session.createQuery("UPDATE Person SET personName='Test' WHERE personAge<30").executeUpdate();
            for(Person person:people){
                System.out.println(person.getPersonName()+":"+person.getPersonAge());
            }
            session.createQuery("DELETE FROM Person WHERE personAge<30").executeUpdate();
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }
        finally{
            sessionFactory.close();
        }
    }
}
