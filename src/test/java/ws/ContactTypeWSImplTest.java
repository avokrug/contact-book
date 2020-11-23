package ws;

import entities.ContactTypeEntity;
import entities.ContactsEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTypeWSImplTest {
    private ContactTypeWSImpl contactTypeWS = new ContactTypeWSImpl();
    private String type = "Type";

    @Before
    public void setUp() {
        contactTypeWS.findAll().stream().forEach(el -> contactTypeWS.delete(el));
    }

    @Test
    public void findAll() {
        contactTypeWS.add(new ContactTypeEntity(type));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().count(), 1);
        contactTypeWS.add(new ContactTypeEntity(1, type + "_new"));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().count(), 2);
    }

    @Test
    public void add() {
        ContactTypeEntity contactType = new ContactTypeEntity(type);
        contactTypeWS.add(contactType);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().findFirst().get(), contactType);
    }

    @Test
    public void update() {
        ContactTypeEntity contactType = new ContactTypeEntity(type);
        contactTypeWS.add(contactType);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().findFirst().get(), contactType);
        contactType.setType(type + "_new");
        contactTypeWS.update(contactType);
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().findFirst().get(), contactType);
    }

    @Test
    public void delete() {
        contactTypeWS.add(new ContactTypeEntity(type));
        contactTypeWS.add(new ContactTypeEntity(type + "_new"));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().count(), 2);
        contactTypeWS.findAll().stream().forEach(el -> contactTypeWS.delete(el));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), contactTypeWS.findAll().stream().count(), 0);
    }

    private String getErrorMessage(String name) {
        return "Method " + name + " don't work!";
    }
}