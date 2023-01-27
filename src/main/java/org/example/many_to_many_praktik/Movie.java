package org.example.many_to_many_praktik;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Integer movieId;
    @Column(name="movie_name")
    private String movieName;
    @ManyToMany(mappedBy = "movies")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId) && Objects.equals(movieName, movie.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName);
    }
}
