package com.bon.cracking;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Arrays;
import java.util.List;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ArrayRotationTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void should_take_user_input_as_TestCase_class() {
        ArrayRotation.TestCase expected = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(4)
                .withValues(1, 2, 3, 4, 5)
                .build();
        systemInMock.provideLines("5 4", "1 2 3 4 5");
        Assert.assertEquals(expected, ArrayRotation.readInput());
    }

    @Test
    public void should_rotate_left_by_one() {
        ArrayRotation.TestCase testData = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(1)
                .withValues(1, 2, 3, 4, 5)
                .build();
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 1);
        Assert.assertEquals(expected, ArrayRotation.rotateLeft(testData));
    }

    @Test
    public void should_rotate_left_by_two() {
        ArrayRotation.TestCase testData = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(2)
                .withValues(1, 2, 3, 4, 5)
                .build();
        List<Integer> expected = Arrays.asList(3, 4, 5, 1, 2);
        Assert.assertEquals(expected, ArrayRotation.rotateLeft(testData));
    }

    @Test
    public void should_rotate_left_by_three() {
        ArrayRotation.TestCase testData = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(3)
                .withValues(1, 2, 3, 4, 5)
                .build();
        List<Integer> expected = Arrays.asList(4, 5, 1, 2, 3);
        Assert.assertEquals(expected, ArrayRotation.rotateLeft(testData));
    }

    @Test
    public void should_rotate_left_by_four() {
        ArrayRotation.TestCase testData = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(4)
                .withValues(1, 2, 3, 4, 5)
                .build();
        List<Integer> expected = Arrays.asList(5, 1, 2, 3, 4);
        Assert.assertEquals(expected, ArrayRotation.rotateLeft(testData));
    }

    @Test
    public void should_rotate_left_by_five() {
        ArrayRotation.TestCase testData = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(5)
                .withValues(1, 2, 3, 4, 5)
                .build();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals(expected, ArrayRotation.rotateLeft(testData));
    }

    @Test
    public void should_rotate_left_by_six() {
        ArrayRotation.TestCase testData = new TestCaseBuilder()
                .withSize(5)
                .withLeftRotations(6)
                .withValues(1, 2, 3, 4, 5)
                .build();
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 1);
        Assert.assertEquals(expected, ArrayRotation.rotateLeft(testData));
    }
}

class TestCaseBuilder {
    private int size;
    private int leftRotations;
    private List<Integer> values;

    public TestCaseBuilder withSize(int size) {
        this.size = size;
        return this;
    }

    public TestCaseBuilder withLeftRotations(int leftRotations) {
        this.leftRotations = leftRotations;
        return this;
    }

    public TestCaseBuilder withValues(Integer... values) {
        this.values = Arrays.asList(values);
        return this;
    }

    public ArrayRotation.TestCase build() {
        return new ArrayRotation.TestCase(size, leftRotations, values);
    }
}
