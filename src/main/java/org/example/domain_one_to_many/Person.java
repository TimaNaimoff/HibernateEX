package org.example.domain_one_to_many;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="person_id")
    private Integer personId;
    @Column(name="person_name")
    private String personName;
    @Column(name="person_age")
    private Integer personAge;
    @OneToMany(mappedBy="owner")
    private List<Item> items;

    public Person() {
    }

    public Person(String personName, Integer personAge) {
        this.personName = personName;
        this.personAge = personAge;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }
}
