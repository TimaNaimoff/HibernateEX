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
            Session session = sessionFactory.openSession();
            Session session3 = sessionFactory.getCurrentSession()
        ){
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
                 System.out.println(person);
//                Hibernate.initialize(person.getItemList());
                 session.getTransaction().commit();
                 System.out.println("Session is ended!");
                 session3.beginTransaction();

                 Person personer=(Person)session3.merge(person);
//                 Hibernate.initialize(personer.getItemList());
                 session.getTransaction().commit();
                  List<Item>item=session.createQuery("SELECT i FROM Item i WHERE i.person.personId=:personId",Item.class)
                        .setParameter("personId",person.getPersonId()).getResultList();
                System.out.println("Second session is ended! "+ item );
//                 System.out.println(personer.getItemList());
//                 System.out.println("This is second transaction");

                 session3.getTransaction().commit();

        }catch(Exception e){
                if(session.getTransaction().getStatus().canRollback()){
                    session.getTransaction().rollback();
                }
                if(session3.getTransaction().getStatus().canRollback()) {
                    session3.getTransaction().rollback();
                }
            }
            }
    }
}
