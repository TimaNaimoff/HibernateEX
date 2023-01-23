package org.example;


import org.example.domain.Person;
import org.example.domain.PersonSequence;
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
        Configuration configuration2=new Configuration().addAnnotatedClass(PersonSequence.class);
        SessionFactory sessionFactory2 = configuration2.buildSessionFactory();
        Session session2=sessionFactory2.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person.getPersonName() + ":" + person.getPersonAge());
            Person person2=new Person("Tokugava",43);
            Person person3=new Person("Mazunga",32);
            session.save(person3);
            session.save(person2);
            session.getTransaction().commit();
            session2.beginTransaction();
            PersonSequence sequence=new PersonSequence("Kitsuna",22);
            PersonSequence sequence2=new PersonSequence("Chandragupta",564);
            session2.save(sequence);
            session2.save(sequence2);
            session2.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            session2.getTransaction().rollback();
        }
        finally{
            sessionFactory.close();
            sessionFactory2.close();
        }
    }
}
