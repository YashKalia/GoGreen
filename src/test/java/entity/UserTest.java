package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {

    private User user1 = new User();
    private User user2;

    @Before
    public void setup() {

        user1 = new User("user1", "password");
        user2 = new User("user1", "password");

    }

    @Test
    public void testGetUsername() {

        assertEquals("user1", user1.getUsername());

    }

    @Test
    public void testSetUsername() {

        user1.setUsername("user15");

        assertEquals("user15", user1.getUsername());

    }

    @Test
    public void testGetPassword() {

        assertEquals("password", user1.getPassword());

    }

    @Test
    public void testSetPassword() {

        user1.setPassword("newPassword");

        assertEquals("newPassword", user1.getPassword());

    }

    @Test
    public void testEqualsSameMemLoc() {

        User user3 = user1;

        assertTrue(user1.equals(user3));

    }

    @Test
    public void testEqualsTrue() {

        assertTrue(user1.equals(user2));

    }

    @Test
    public void testEqualsWrongUsername() {

        user2.setUsername("user2");

        assertFalse(user1.equals(user2));

    }

    @Test
    public void testEqualsWrongPassword() {

        user2.setPassword("newpassword");

        assertFalse(user1.equals(user2));

    }

    @Test
    public void testEqualsWrongObject() {

        assertFalse(user1.equals("hello"));

    }

}
