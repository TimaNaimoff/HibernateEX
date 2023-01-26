package org.example.many_to_many_praktik;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(mappedBy = "actors")
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


}
