// Solution for: https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
package com.bon.cracking;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DavisStaircase {
    private void loadCombinations(List<Integer> arr, int k, Set<List<Integer>> result) {
        //System.out.println("Generating combinations = " + arr);
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            if (!result.contains(arr)) {
                loadCombinations(arr, k + 1, result);
            }
            Collections.swap(arr, k, i);
        }
        if (k == (arr.size() - 1)) {
            result.add(new ArrayList<>(arr));
        }
    }

    private void loadWaysToClimb(List<Integer> permutation, int height, Set<List<Integer>> waysToClimb) {
        System.out.println("evaluating perm = " + permutation);
        int sum = permutation.stream().mapToInt(Integer::intValue).sum();
        if (sum == height) {
            Set<List<Integer>> permutations = new HashSet<>();
            loadCombinations(permutation, 0, permutations);
            waysToClimb.addAll(permutations);
            for (List<Integer> p : permutations) {
                if (p.size() >= 2) {
                    ArrayList<Integer> p1 = new ArrayList<>(p);
                    int first = p1.get(0);
                    int second = p1.get(1);
                    sum = first + second;
                    if (sum <= 3) {
                        p1.set(0, sum);
                        p1.remove(1);
                        if (!waysToClimb.contains(p1)) {
                            loadWaysToClimb(p1, height, waysToClimb);
                        }
                    }
                }
            }
        }
    }

    public List<Integer> findDifferentWaysToClimb(TestCase testCase) {
        List<Integer> heights = testCase.getHeights();
        List<Integer> differentWaysToClimb = new ArrayList<>();
        for (Integer height : heights) {
            List<Integer> firstPermutation = new ArrayList<>();
            IntStream.range(0, height).forEach(h -> firstPermutation.add(1));
            Set<List<Integer>> waysToClimb = new HashSet<>();
            loadWaysToClimb(firstPermutation, height, waysToClimb);
            differentWaysToClimb.add(waysToClimb.size());
        }
        return differentWaysToClimb;
    }

    public static TestCase readInput() {
        Scanner in = new Scanner(System.in);
        int stairs = in.nextInt();
        List<Integer> heights = IntStream.range(0, stairs)
                .map(s -> in.nextInt())
                .boxed().collect(Collectors.toList());
        return TestCase
                .builder()
                .staircases(stairs)
                .heights(heights)
                .build();
    }

    public static void main(String... args) {
        DavisStaircase inst = new DavisStaircase();
        TestCase testCase = inst.readInput();
        List<Integer> differentWaysToClimb = inst.findDifferentWaysToClimb(testCase);
        differentWaysToClimb.stream().forEach(System.out::println);
    }

    @Builder
    @EqualsAndHashCode
    static class TestCase {
        @Getter
        @Setter
        private int staircases;

        @Getter
        @Setter
        private List<Integer> heights;
    }

}
