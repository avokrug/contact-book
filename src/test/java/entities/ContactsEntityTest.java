package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactsEntityTest {

    private PersonEntity personEntity;
    private ContactTypeEntity contactTypeEntity;
    private ContactsEntity contactsEntity;
    private int id = 0;
    private String number = "89998887766";

    @Before
    public void setUp() {
        personEntity = new PersonEntity(id, "First Name", "Last Name", "Middle Name", "Position");
        contactTypeEntity = new ContactTypeEntity(id, "Type");
        contactsEntity = new ContactsEntity(id, number, personEntity, contactTypeEntity);
    }

    @Test
    public void getId() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.id, contactsEntity.getId());
    }

    @Test
    public void setId() {
        int id = 1;
        contactsEntity.setId(id);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.id, contactsEntity.getId());
        this.id = id;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), id, contactsEntity.getId());
    }

    @Test
    public void getPerson() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), personEntity, contactsEntity.getPerson());
    }

    @Test
    public void setPerson() {
        PersonEntity personEntity = new PersonEntity();
        contactsEntity.setPerson(personEntity);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.personEntity, contactsEntity.getPerson());
        this.personEntity = personEntity;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.personEntity, contactsEntity.getPerson());
    }

    @Test
    public void getContactType() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), contactTypeEntity, contactsEntity.getContactType());
    }

    @Test
    public void setContactType() {
        ContactTypeEntity contactTypeEntity = new ContactTypeEntity();
        contactsEntity.setContactType(contactTypeEntity);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.contactsEntity, contactsEntity.getContactType());
        this.contactTypeEntity = contactTypeEntity;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.contactTypeEntity, contactsEntity.getContactType());
    }

    @Test
    public void getNumber() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.number, contactsEntity.getNumber());
    }

    @Test
    public void setNumber() {
        String number = "86669995544";
        contactsEntity.setNumber(number);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.number, contactsEntity.getNumber());
        this.number = number;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), number, contactsEntity.getNumber());
    }

    private String getErrorMessage(String name){
        return "Method " + name + " don't work!";
    }
}