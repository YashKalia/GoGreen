package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class EntryTest {

    private String user1;
    private String user2;

    private String feature1;
    private String feature2;

    private Entry entry1;
    private Entry entry2 = new Entry();

    @Before
    public void setup() {

        user1 = "user1";
        user2 = "user2";

        feature1 = "Eating a vegetarian meal";
        feature2 = "Riding a bike to work";

        entry1 = new Entry("Eating a vegetarian meal", "user1");

        entry2 = new Entry("Eating a vegetarian meal", "user1");

    }

    @Test
    public void testGetFeature() {

        assertEquals(feature1, entry1.getFeature());

    }

    @Test
    public void testSetFeature() {

        entry1.setFeature("Riding a bike to work");

        assertEquals(feature2, entry1.getFeature());

    }

    @Test
    public void testGetUser() {

        assertEquals(user1, entry1.getUsername());

    }

    @Test
    public void testSetUser() {

        entry1.setUsername(user2);

        assertEquals(user2, entry1.getUsername());

    }

    @Test
    public void testEqualsSameMemLoc() {

        Entry entry3 = entry1;

        assertTrue(entry1.equals(entry3));

    }

    @Test
    public void testEqualsTrue() {

        assertTrue(entry1.equals(entry2));

    }

    @Test
    public void testEqualsWrongFeature() {

        entry2.setFeature(feature2);

        assertFalse(entry1.equals(entry2));

    }

    @Test
    public void testEqualsWrongUser() {

        entry2.setUsername(user2);

        assertFalse(entry1.equals(entry2));

    }

    @Test
    public void testEqualsWrongObj() {

        assertFalse(entry1.equals("hello"));

    }

}
