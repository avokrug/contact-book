package entities;

import javax.persistence.*;
import java.util.Objects;

// A class describing an entity contacts for working with Hibernates
@Entity
@Table(name = "contacts", schema = "phone_book")
public class ContactsEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name="person_id", referencedColumnName = "id", nullable = false)
    private PersonEntity person;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name="contact_type_id", referencedColumnName = "id", nullable = false)
    private ContactTypeEntity contactType;

    public ContactsEntity() {
    }

    public ContactsEntity(int id, String number, PersonEntity person, ContactTypeEntity contactType) {
        this.id = id;
        this.number = number;
        this.person = person;
        this.contactType = contactType;
    }

    public ContactsEntity(String number, PersonEntity person, ContactTypeEntity contactType) {
        this.number = number;
        this.person = person;
        this.contactType = contactType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ContactTypeEntity getContactType() {
        return contactType;
    }

    public void setContactType(ContactTypeEntity contactType) {
        this.contactType = contactType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsEntity that = (ContactsEntity) o;
        return  Objects.equals(person, that.person) &&
                Objects.equals(contactType, that.contactType) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, contactType, number);
    }
}
