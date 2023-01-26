package org.example.domain_one_to_one_auth;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;

@Entity
@Table(name="_director")
public class Director {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="_director_id")
    private Integer directorId;
    @Column(name="_director_name")
    private String directorName;
    @Column(name="_director_age")
    private Integer directorAge;
    @OneToOne(mappedBy="director")
    @Cascade(CascadeType.SAVE_UPDATE)
    private School school;
    public Director(String directorName, Integer directorAge) {
        this.directorName = directorName;
        this.directorAge = directorAge;
    }
    public Director(){}

    public School getScool() {
        return school;
    }

    public void setScool(School school) {
        school.setDirector(this);
        this.school = school;

    }

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
}
