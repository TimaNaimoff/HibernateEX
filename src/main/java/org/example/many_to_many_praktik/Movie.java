package org.example.many_to_many_praktik;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Integer movieId;
    @Column(name="movie_name")
    private String movieName;
    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")

    )
    private List<Actor>actors;
    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public Movie() {
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
