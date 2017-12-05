package com.bon.valladolid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityTest {
    private City c;

    @Before
    public void setup() {
        c = City.builder().build();
        c.addToMap(new int[] {0, 1}, 200);
        c.addToMap(new int[] {0, 2}, 200);
        c.addToMap(new int[] {0, 3}, 200);
        c.addToMap(new int[] {1, 2}, 200);
        c.addToMap(new int[] {2, 3}, 200);

        c.addToMap(new int[] {3, 4}, 100);
        c.addToMap(new int[] {4, 6}, 50);
        c.addToMap(new int[] {4, 5}, 200);
        c.addToMap(new int[] {5, 6}, 100);
    }

    @Test
    public void streets_must_be_built_correctly() {
        Intersection i0 = c.getIntersection(0);
        int d0_1 = i0.getNextDistance(1);
        Assert.assertEquals(d0_1, 200);

        Intersection i1 = c.getIntersection(1);
        int d1_0 = i1.getNextDistance(0);
        Assert.assertEquals(d1_0, 200);

        int d1_2 = i1.getNextDistance(2);
        Assert.assertEquals(d1_2, 200);
    }

    @Test
    public void find_shortest_distance() {
        int d = c.findShortestDistance(1, 3);
        Assert.assertEquals(400, d);

        d = c.findShortestDistance(1, 5);
        Assert.assertEquals(650, d);
    }

    @Test
    public void find_longest_from_shortest_distances() {
        int d = c.findLongestFromShortestDistances(7);
        Assert.assertEquals(650, d);
    }
}
