package org.example.domain_one_to_one;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;

@Entity
@Table(name="_person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="_person_id")
    private Integer personId;
    @Column(name="_person_name")
    private String personName;
    @Column(name="_person_age")
    private Integer personAge;
    @OneToOne(mappedBy = "person")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Passport passport;
    public Person(String personName, Integer personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }
    public Person(){}

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPerson(this);
    }

    public Integer getPersonId() {
        return personId;
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

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }
}
