package org.example.many_to_many_praktik;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "_actor")
public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="_actor_id")
    private Integer actorId;
    @Column(name="_actor_name")
    private String actorName;
    @Column(name="_actor_age")
    private Integer actorAge;
    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")

    )
    private List<Movie>movies;

    public Actor(){
    }
    public Actor(String actorName, Integer actorAge) {
        this.actorName = actorName;
        this.actorAge = actorAge;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Integer getActorAge() {
        return actorAge;
    }

    public void setActorAge(Integer actorAge) {
        this.actorAge = actorAge;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(actorId, actor.actorId) && Objects.equals(actorName, actor.actorName) && Objects.equals(actorAge, actor.actorAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, actorName, actorAge);
    }
}
