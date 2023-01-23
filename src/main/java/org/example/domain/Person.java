package org.example.domain;


import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="person_id")
    private Integer personId;
    @Column(name="person_name")
    private String personName;
    @Column(name="person_age")
    private Integer personAge;
    public Person(){}
    public Integer getPersonId() {
        return personId;
    }
    public Person(String personName,Integer personAge){
        this.personName=personName;
        this.personAge=personAge;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }
}
