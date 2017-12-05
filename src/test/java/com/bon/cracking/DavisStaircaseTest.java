// Solution for: https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
package com.bon.cracking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Arrays;
import java.util.List;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class DavisStaircaseTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void should_take_user_input_as_TestCase_class() {
        DavisStaircase.TestCase expected = DavisStaircase.TestCase
                .builder()
                .staircases(3)
                .heights(Arrays.asList(1, 3, 7))
                .build();
        systemInMock.provideLines("3", "1", "3", "7");
        Assert.assertEquals(expected, DavisStaircase.readInput());
    }

    @Test
    public void should_take_height_3_and_return_4_ways() {
        DavisStaircase.TestCase testCase = DavisStaircase.TestCase
                .builder()
                .staircases(1)
                .heights(Arrays.asList(3))
                .build();
        Integer expected = 4;
        Integer result = new DavisStaircase().findDifferentWaysToClimb(testCase).get(0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_take_height_1_and_return_1_way() {
        DavisStaircase.TestCase testCase = DavisStaircase.TestCase
                .builder()
                .staircases(1)
                .heights(Arrays.asList(1))
                .build();
        Integer expected = 1;
        Integer result = new DavisStaircase().findDifferentWaysToClimb(testCase).get(0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_take_height_7_and_return_44_way() {
        DavisStaircase.TestCase testCase = DavisStaircase.TestCase
                .builder()
                .staircases(1)
                .heights(Arrays.asList(7))
                .build();
        Integer expected = 44;
        Integer result = new DavisStaircase().findDifferentWaysToClimb(testCase).get(0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_take_height_10_and_return_243_way() {
        DavisStaircase.TestCase testCase = DavisStaircase.TestCase
                .builder()
                .staircases(1)
                .heights(Arrays.asList(10))
                .build();
        Integer expected = 274;
        Integer result = new DavisStaircase().findDifferentWaysToClimb(testCase).get(0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_take_heights_3_and_7_and_return_4_and_44_ways() {
        DavisStaircase.TestCase testCase = DavisStaircase.TestCase
                .builder()
                .staircases(2)
                .heights(Arrays.asList(3, 7))
                .build();
        Integer expected = 4;
        List<Integer> differentWaysToClimb = new DavisStaircase().findDifferentWaysToClimb(testCase);
        Integer result = differentWaysToClimb.get(0);
        Assert.assertEquals(expected, result);
        expected = 44;
        result = differentWaysToClimb.get(1);
        Assert.assertEquals(expected, result);
    }

}
