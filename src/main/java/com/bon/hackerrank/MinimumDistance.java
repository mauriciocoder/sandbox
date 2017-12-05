package com.bon.hackerrank;

import lombok.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumDistance {

    public static int find(TestCase t) {
        int size = t.numbers.size();
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < size - 1; i++) {
            int reference = t.numbers.get(i);
            for (int j = i + 1; j < size; j++) {
                int actual = t.numbers.get(j);
                if (reference == actual) {
                    int diff = j - i;
                    distance = diff < distance ? diff : distance;
                }
            }
        }
        return distance < Integer.MAX_VALUE ? distance : -1;
    }


    public static TestCase readInput() {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        List<Integer> numbers = IntStream.range(0, size)
                .map(s -> in.nextInt())
                .boxed().collect(Collectors.toList());
        return TestCase
                .builder()
                .numbers(numbers)
                .build();
    }

    public static void main(String... args) {
        MinimumDistance inst = new MinimumDistance();
        TestCase testCase = inst.readInput();
        System.out.println(find(testCase));
    }

    @Builder
    @EqualsAndHashCode
    @ToString
    static class TestCase {
        @Getter
        @Setter
        private List<Integer> numbers;
    }
}
