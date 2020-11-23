package ws;

import entities.ContactTypeEntity;
import entities.ContactsEntity;
import entities.PersonEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonWSImplTest {
    private PersonWSImpl personWS = new PersonWSImpl();
    private String firstName = "First Name";
    private String lastName = "Last Name";
    private String middleName = "Middle Name";
    private String position = "Position";

    @Before
    public void setUp() {
        personWS.findAll().stream().forEach(el -> personWS.delete(el));
    }

    @Test
    public void findAll() {
        personWS.add(getPerson(""));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().count(), 1);
        personWS.add(getPerson("_new"));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().count(), 2);
    }

    @Test
    public void add() {
        personWS.add(getPerson(""));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().findFirst().get(), getPerson(""));
    }

    @Test
    public void update() {
        personWS.add(getPerson(""));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().findFirst().get(), getPerson(""));
        personWS.update(getPerson("_new"));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().findFirst().get(), getPerson("new"));
    }

    @Test
    public void delete() {
        personWS.add(getPerson(""));
        personWS.add(getPerson("_new"));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().count(), 2);
        personWS.findAll().stream().forEach(el -> personWS.delete(el));
        assertEquals(getErrorMessage(new Object() {
        }.getClass().getEnclosingMethod().getName()), personWS.findAll().stream().count(), 0);
    }

    private PersonEntity getPerson(String prefix) {
        return new PersonEntity(firstName + prefix, lastName + prefix, middleName + prefix, position + prefix);
    }

    private String getErrorMessage(String name) {
        return "Method " + name + " don't work!";
    }
}