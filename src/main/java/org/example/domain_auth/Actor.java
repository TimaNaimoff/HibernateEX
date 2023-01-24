package org.example.domain_auth;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="actor_id")
    private Integer actorId;
    @Column(name="actor_name")
    private String actorName;
    @Column(name="actor_age")
    private Integer actorAge;
    @ManyToOne
    @JoinColumn(name="director_id",referencedColumnName = "director_id")
    private Director theDirector;
    public Actor(String actorName, Integer actorAge) {
        this.actorName = actorName;
        this.actorAge = actorAge;
    }

    public Actor(){}

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Director getTheDirector() {
        return theDirector;
    }

    public void setTheDirector(Director theDirector) {
        this.theDirector = theDirector;
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

    @Override
    public String toString() {
        return "Actor{" +
                "actorName='" + actorName + '\'' +
                ", actorAge=" + actorAge +
                '}';
    }
}
