package com.bon.hackerrank;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Arrays;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MinimumDistanceTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void should_take_user_input_as_TestCase_class() {
        MinimumDistance.TestCase expected = MinimumDistance.TestCase
                .builder()
                .numbers(Arrays.asList(7, 1, 3, 4, 1, 7))
                .build();
        systemInMock.provideLines("6 7 1 3 4 1 7");
        Assert.assertEquals(expected, MinimumDistance.readInput());
    }

    @Test
    public void should_return_3_on_test_case_7_1_3_4_1_7() {
        MinimumDistance.TestCase t = MinimumDistance.TestCase
                .builder()
                .numbers(Arrays.asList(7, 1, 3, 4, 1, 7))
                .build();
        Assert.assertEquals(3, MinimumDistance.find(t));
    }
}
