package org.example.starters;

import org.example.domain_auth.Actor;
import org.example.domain_auth.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

public class Apper {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().addAnnotatedClass(Director.class).
                addAnnotatedClass(Actor.class);
        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.getCurrentSession()
        ){
            try{
                  session.beginTransaction();
//                  Director director=session.get(Director.class,2);
//                  System.out.println(director);
//                  List<Actor>actors=director.getActors();
//                  System.out.println(actors);
//                  System.out.println("-----------------------------");
//                  Actor actor1=session.get(Actor.class,5);
//                  System.out.println(actor1);
//                  Director directoris=actor1.getTheDirector();
//                  System.out.println(directoris);
//                  System.out.println("-----------------------------");
//                    Director director2=session.get(Director.class,1);
//                    Actor actor2=new Actor("Sheppard",154);
//                    director2.getActors().add(actor2);
//                    actor2.setTheDirector(director2);
//                    session.save(actor2);
//                Actor actor3=new Actor("Natali",21);
//                Director director3=new Director("Taynan",54);
//                actor3.setTheDirector(director3);
//                director3.setActors(Collections.singletonList(actor3));
//                session.save(director3);
//                session.save(actor3);
//                Actor actor4 = session.get(Actor.class,4);
//                Director director4=session.get(Director.class,2);
//                actor4.getTheDirector().getActors().remove(actor4);
//                actor4.setTheDirector(director4);
//                director4.getActors().add(actor4);
                Director director = session.get(Director.class,1);
                List<Actor>actors=director.getActors();
                for(Actor ac:actors){
                    session.remove(ac);
                }
                session.getTransaction().commit();
            }catch(Exception e){
                session.getTransaction().rollback();
            }
        }
    }
}
