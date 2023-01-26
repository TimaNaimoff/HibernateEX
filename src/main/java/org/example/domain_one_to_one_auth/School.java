package org.example.domain_one_to_one_auth;

import javax.persistence.*;

@Entity
@Table(name="school")
public class School {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="school_id")
    private Integer schoolId;
    @Column(name="school_name")
    private String schoolName;
    @OneToOne
    @JoinColumn(name="_director_id",referencedColumnName = "_director_id")
    private Director director;
    public School(){}
    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
