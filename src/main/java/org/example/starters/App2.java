package org.example.starters;

import org.example.domain_one_to_many.Person;
import org.example.domain_one_to_many.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().
                addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        try(
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();

                Person person = session.get(Person.class, 3);
                System.out.println(person.getItems());
                Item item = session.get(Item.class, 2);
                System.out.println(item.getOwner());
                Person person1 = session.get(Person.class, 2);
                Item item1 = new Item("Permann", person);
                person.getItems().add(item);
                session.save(item);


                Person person2 = new Person("Akusilanj", 22);
                Item item2 = new Item("Jnalisupa", person2);
                person2.setItems(new ArrayList<>(Collections.singletonList(item)));
                session.save(person2);
                session.save(item);


                Person person3 = session.get(Person.class, 2);
                List<Item> list = person3.getItems();
                for (Item item3 : list) {
                    session.remove(item);
                }
                person3.getItems().clear();


                Person person4 = session.get(Person.class, 2);
                session.delete(person4);
                person4.getItems().forEach(e -> e.setOwner(null));

                Person person5 = session.get(Person.class, 3);
                Item item4 = session.get(Item.class, 1);
                item.getOwner().getItems().remove(item);
                item.setOwner(person5);
                person5.getItems().add(item);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }
}