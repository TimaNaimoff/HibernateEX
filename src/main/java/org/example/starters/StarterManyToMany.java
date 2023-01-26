package org.example.starters;

import org.example.many_to_many_praktik.Actor;
import org.example.many_to_many_praktik.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StarterManyToMany {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().addAnnotatedClass(Actor.class).
                addAnnotatedClass(Movie.class);
        try(SessionFactory sessionFactory=configuration.buildSessionFactory();
            Session session=sessionFactory.openSession()){
            try{
                session.beginTransaction();

                Movie movie = new Movie("Jumanji");
                Actor actor=new Actor("Timman",29);
                Actor actor2=new Actor("Bjegosch",30);
                movie.setActors(new ArrayList<>(List.of(actor,actor2)));
                actor.setMovies(new ArrayList<>(Collections.singletonList(movie)));
                actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
                session.save(movie);
                session.save(actor);
                session.save(actor2);
                session.getTransaction().commit();
            }catch(Exception e){
                session.getTransaction().rollback();
            }
        }
    }
}
