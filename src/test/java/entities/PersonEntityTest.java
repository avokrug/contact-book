package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonEntityTest {
    PersonEntity personEntity;
    private int id = 0;
    private String firstName = "First Name";
    private String lastName = "Last Name";
    private String middleName = "Middle Name";
    private String position = "Position";

    @Before
    public void setUp() {
        personEntity = new PersonEntity(id, firstName, lastName, middleName, position);
    }

    @Test
    public void getId() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.id, personEntity.getId());
    }

    @Test
    public void setId() {
        int id = 1;
        personEntity.setId(id);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.id, personEntity.getId());
        this.id = id;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), id, personEntity.getId());
    }

    @Test
    public void getFirstName() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.firstName, personEntity.getFirstName());
    }

    @Test
    public void setFirstName() {
        String name = "new FirstName";
        personEntity.setFirstName(name);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.firstName, personEntity.getFirstName());
        this.firstName = name;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), name, personEntity.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.lastName, personEntity.getLastName());
    }

    @Test
    public void setLastName() {
        String name = "new LastName";
        personEntity.setLastName(name);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.lastName, personEntity.getLastName());
        this.lastName = name;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), name, personEntity.getLastName());
    }

    @Test
    public void getMiddleName() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.middleName, personEntity.getMiddleName());
    }

    @Test
    public void setMiddleName() {
        String name = "new MiddleName";
        personEntity.setMiddleName(name);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.middleName, personEntity.getMiddleName());
        this.middleName = name;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), name, personEntity.getMiddleName());
    }

    @Test
    public void getPosition() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.position, personEntity.getPosition());
    }

    @Test
    public void setPosition() {
        String position = "new Position";
        personEntity.setPosition(position);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.position, personEntity.getPosition());
        this.position = position;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), position, personEntity.getPosition());
    }

    private String getErrorMessage(String name){
        return "Method " + name + " don't work!";
    }
}