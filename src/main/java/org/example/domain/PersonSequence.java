package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name="person_sec")
public class PersonSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seq_generator_person")
    @Column(name="person_sec_id")
    @SequenceGenerator(
            name="seq_generator_person",sequenceName="person_sec_id_seq",allocationSize=1
    )
    private Integer person2Id;
    @Column(name="person_sec_name")
    private String person2Name;
    @Column(name="person_sec_age")
    private Integer person2Age;

    public PersonSequence() {
    }

    public PersonSequence(String person2Name, Integer person2Age) {
        this.person2Name = person2Name;
        this.person2Age = person2Age;
    }

    public Integer getPerson2Id() {
        return person2Id;
    }

    public void setPerson2Id(Integer person2Id) {
        this.person2Id = person2Id;
    }

    public String getPerson2Name() {
        return person2Name;
    }

    public void setPerson2Name(String person2Name) {
        this.person2Name = person2Name;
    }

    public Integer getPerson2Age() {
        return person2Age;
    }

    public void setPerson2Age(Integer person2Age) {
        this.person2Age = person2Age;
    }
}
