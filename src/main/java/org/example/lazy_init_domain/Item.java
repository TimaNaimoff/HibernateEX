package org.example.lazy_init_domain;


import javax.persistence.*;

@Entity
@Table(name="_item_")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer itemId;
    @Column(name="item_name")
    private String itemName;
    @ManyToOne
    @JoinColumn(name="person_id",referencedColumnName = "person_id")
    private Person person;

    public Item() {
    }

    public Item(String itemName, Person person) {
        this.itemName = itemName;
        this.person = person;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName=" + itemName +
//                "person="+person+
                '}';
    }
}
