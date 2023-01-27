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

//                Movie movie = new Movie("Jumanji");
//                Actor actor = new Actor("Timman",29);
//                Actor actor2 = new Actor("Bjegosch",30);
//                movie.setActors(new ArrayList<>(List.of(actor,actor2)));
//                actor.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//                actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//                session.save(movie);
//                session.save(actor);
//                session.save(actor2);
//                Movie movie2=session.get(Movie.class,2);
//                System.out.println(movie.getActors());
//                Actor actor2=session.get(Actor.class,3);
//                System.out.println(actor.getMovies());
//
//                  Actor actor3=session.get(Actor.class,3);
//                  Movie movie=new Movie("Terere");
//                  movie.setActors(Collections.singletonList(actor3));
//                  actor3.getMovies().add(movie);
//                  session.save(movie);
                  Actor actor4=session.get(Actor.class,3);
                  Movie movieToRemove=actor4.getMovies().get(0);
                  actor4.getMovies().remove(movieToRemove);
                  movieToRemove.getActors().remove(actor4);
                  session.getTransaction().commit();
            }catch(Exception e){
                session.getTransaction().rollback();
            }
        }
    }
}
