package org.example;

import org.example.domain_one_to_many.Item;
import org.example.domain_one_to_many.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.Collections;

public class Cascading {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class);
        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.getCurrentSession()){
            try{
                session.beginTransaction();

                Person person=new Person("Ikar",29);
                person.addItem(new Item("Magnum-500",person));
                person.addItem(new Item("Magnum-503",person));
                person.addItem(new Item("Magnum-505",person));
                session.save(person);

                session.getTransaction().commit();
            }catch(Exception e){
                session.getTransaction().rollback();
            }
        }
    }
}
