package org.example.domain_one_to_one;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="_passport")
public class Passport {
//    @Id
//    @OneToOne
//    @JoinColumn(name="_person_id",referencedColumnName = "_person_id")
//    private Person person;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="_passport_id")
    private Integer personId;
    @Column(name="_passport_number")
    private Integer passportNumber;
    @OneToOne
    @JoinColumn(name="_person_id",referencedColumnName = "_person_id")
    private Person person;
    public Passport(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }
    public Passport(){}

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
