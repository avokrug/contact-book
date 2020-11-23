package entities;

import javax.persistence.*;
import java.util.Objects;

// A class describing an entity type of contact for working with Hibernates
@Entity
@Table(name = "contact_type", schema = "phone_book")
public class ContactTypeEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "type", nullable = true, length = 255)
    private String type;

    @OneToOne(mappedBy = "contactType", cascade = CascadeType.ALL)
    private ContactsEntity contacts;

    public ContactTypeEntity() {
    }

    public ContactTypeEntity(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public ContactTypeEntity(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactTypeEntity that = (ContactTypeEntity) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
