package org.example.domain_auth;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="director_id")
    private Integer directorId;
    @Column(name="director_name")
    private String directorName;
    @Column(name="director_age")
    private Integer directorAge;
    @OneToMany(mappedBy="theDirector")
    private List<Actor> actors;

    public Director(String directorName, Integer directorAge) {
        this.directorName = directorName;
        this.directorAge = directorAge;
    }

    public Director(){}

    public Integer getDirectorId() {
        return directorId;
    }


    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Integer getDirectorAge() {
        return directorAge;
    }

    public void setDirectorAge(Integer directorAge) {
        this.directorAge = directorAge;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorName='" + directorName + '\'' +
                ", directorAge=" + directorAge +
                '}';
    }
}
