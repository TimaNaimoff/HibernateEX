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

            Person person=new Person("Timur",22);
            session.save(person);
            Person person = session.get(Person.class, 2);
            person.setPersonName("Tamarringulis");
            person.setPersonAge(31);
            session.delete(person);
            session.getTransaction().commit();
            System.out.println(person.getPersonId());
        }catch(Exception e){
            session.getTransaction().rollback();
        }
        finally{
            sessionFactory.close();
        }
    }
}
