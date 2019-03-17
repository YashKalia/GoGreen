package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeatureTest {

    private Feature feature1;
    private Feature feature2;

    @Before
    public void setup() {

        feature1 = new Feature();
        feature1.setFeature("Eating a vegetarian meal");

        feature2 = new Feature("Eating a vegetarian meal");

    }

    @Test
    public void testGetFeature() {

        assertEquals("Eating a vegetarian meal", feature1.getFeature());

    }

    @Test
    public void testSetFeature() {

        feature1.setFeature("Riding a bike to work");

        assertEquals("Riding a bike to work", feature1.getFeature());

    }

    @Test
    public void testEqualsSameMemLoc() {

        Feature feature3 = feature1;

        assertTrue(feature1.equals(feature3));

    }

    @Test
    public void testEqualsTrue() {

        assertTrue(feature1.equals(feature2));

    }

    @Test
    public void testEqualsWrongName() {

        feature2.setFeature("Riding a bike to work");

        assertFalse(feature1.equals(feature2));

    }

    @Test
    public void testEqualsWrongObj() {

        assertFalse(feature1.equals("hello"));

    }

}
