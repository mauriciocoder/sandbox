// Solution for: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
package com.bon.cracking;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayRotation {

    public static List<Integer> rotateLeft(TestCase c) {
        int size = c.size;
        int leftRotations = c.leftRotations;
        List<Integer> values = new ArrayList<>(c.values);
        Collections.rotate(values, leftRotations * -1);
        return values;
    }

    public static TestCase readInput() {
        Scanner in = new Scanner(System.in);
        List<Integer> firstLine = Arrays.stream(in.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        int size = firstLine.get(0);
        int leftRotations = firstLine.get(1);
        List<Integer> values = Arrays.stream(in.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        return new TestCase(size, leftRotations, values);
    }

    public static void main(String... args) {
        List<Integer> result = rotateLeft(readInput());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != (result.size() - 1)) {
                System.out.print(" ");
            }
        }
    }

    static class TestCase {
        int size, leftRotations;
        List<Integer> values;

        public TestCase(int size, int leftRotations, List<Integer> values) {
            this.size = size;
            this.leftRotations = leftRotations;
            this.values = values;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestCase testCase = (TestCase) o;

            if (size != testCase.size) return false;
            if (leftRotations != testCase.leftRotations) return false;
            return values != null ? values.equals(testCase.values) : testCase.values == null;
        }

        @Override
        public int hashCode() {
            int result = size;
            result = 31 * result + leftRotations;
            result = 31 * result + (values != null ? values.hashCode() : 0);
            return result;
        }
    }

}
