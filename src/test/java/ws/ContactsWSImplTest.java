package ws;

import entities.ContactTypeEntity;
import entities.ContactsEntity;
import entities.PersonEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactsWSImplTest {
    private ContactsWSImpl contactsWS = new ContactsWSImpl();
    private String number = "89998887766";
    private String firstName = "First Name";
    private String lastName = "Last Name";
    private String middleName = "Middle Name";
    private String position = "Position";
    private String type = "Type";

    @Before
    public void setUp() {
        contactsWS.findAll().stream().forEach(el -> contactsWS.delete(el));
    }

    @Test
    public void findAll() {
        contactsWS.add(new ContactsEntity(number, getPerson(""), getContactType("")));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().count(), 1);
        contactsWS.add(new ContactsEntity(number, getPerson("_two"), getContactType("_two")));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().count(), 2);
        contactsWS.delete(contactsWS.findAll().stream().findFirst().orElse(null));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().count(), 1);
    }

    @Test
    public void add() {
        ContactsEntity contacts = new ContactsEntity(number, getPerson(""), getContactType(""));
        contactsWS.add(contacts);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().findFirst().get(), contacts);
    }

    @Test
    public void update() {
        ContactsEntity contacts = new ContactsEntity(number, getPerson(""), getContactType(""));
        contactsWS.add(contacts);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().findFirst().get(), contacts);
        contacts.setNumber("123123123");
        contactsWS.update(contacts);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().findFirst().get(), contacts);
        contacts.setPerson(getPerson("_two"));
        contacts.setContactType(getContactType("_two"));
        contactsWS.update(contacts);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().findFirst().get(), contacts);
    }

    @Test
    public void delete() {
        contactsWS.add(new ContactsEntity(number, getPerson(""), getContactType("")));
        contactsWS.add(new ContactsEntity(number, getPerson("_two"), getContactType("_two")));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().count(), 2);
        contactsWS.findAll().stream().forEach(el -> contactsWS.delete(el));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactsWS.findAll().stream().count(), 0);
    }

    private PersonEntity getPerson(String prefix) {
        return new PersonEntity(firstName + prefix, lastName + prefix, middleName + prefix, position + prefix);
    }

    private ContactTypeEntity getContactType(String prefix) {
        return new ContactTypeEntity(type + prefix);
    }

    private String getErrorMessage(String name) {
        return "Method " + name + " don't work!";
    }
}