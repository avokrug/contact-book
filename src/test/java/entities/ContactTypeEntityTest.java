package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTypeEntityTest {
    ContactTypeEntity contactTypeEntity;
    private int id = 0;
    private String type = "Type";

    @Before
    public void setUp() {
        contactTypeEntity = new ContactTypeEntity(id, type);
    }

    @Test
    public void getId() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.id, contactTypeEntity.getId());
    }

    @Test
    public void setId() {
        int id = 1;
        contactTypeEntity.setId(id);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.id, contactTypeEntity.getId());
        this.id = id;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), id, contactTypeEntity.getId());
    }

    @Test
    public void getType() {
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.type, contactTypeEntity.getType());
    }

    @Test
    public void setType() {
        String type = "new Type";
        contactTypeEntity.setType(type);
        assertNotEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), this.type, contactTypeEntity.getType());
        this.type = type;
        assertEquals(getErrorMessage(new Object(){}.getClass().getEnclosingMethod().getName()), type, contactTypeEntity.getType());
    }

    private String getErrorMessage(String name){
        return "Method " + name + " don't work!";
    }
}