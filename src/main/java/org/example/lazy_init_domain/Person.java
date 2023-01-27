package org.example.lazy_init_domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;


@Entity
@Table(name="_person_")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="person_id")
    private Integer personId;
    @Column(name="person_name")
    private String personName;
    @Column(name="person_age")
    private Integer personAge;
    @OneToMany(mappedBy = "person",fetch=FetchType.LAZY)
//    @Cascade({CascadeType.SAVE_UPDATE})
    private List<Item> itemList;
    public Person(String personName, Integer personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    public Person() {
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
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
