package org.example.starters;

import org.example.lazy_init_domain.Item;
import org.example.lazy_init_domain.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LazyTramplain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class);
        try(SessionFactory sessionFactory=configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            try{
                session.beginTransaction();

//                Person person = session.get(Person.class,1);
//                System.out.println(person.getPersonName());
//                List<Item> items = person.getItemList();
//                System.out.println(items);

//                 Item item=session.get(Item.class,2);
//                 System.out.println(item);
//                 System.out.println(item.getPerson().getItemList());
                Person person =session.get(Person.class,1);
//                System.out.println(person);
                Hibernate.initialize(person.getItemList());
                session.getTransaction().commit();
                 System.out.println(person.getItemList());
        }catch(Exception e){
                session.getTransaction().rollback();
            }
            }
    }
}
