package org.example;

import org.example.domain_auth.Actor;
import org.example.domain_auth.Director;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
                    Director director=session.get(Director.class,1);
                    Actor actor=new Actor("Sheppard",154);
                    director.getActors().add(actor);
                    actor.setTheDirector(director);
                    session.save(actor);
                  session.getTransaction().commit();
            }catch(Exception e){
                session.getTransaction().rollback();
            }
        }
    }
}
