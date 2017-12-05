package com.bon.threads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String... args) throws InterruptedException, ExecutionException {
        SquareCalculator calc = SquareCalculator
                .builder()
                .executor(Executors.newCachedThreadPool())
                .build();
        List<Future<Integer>> futures = IntStream.range(0, 100).mapToObj(num -> calc.calculate(num)).collect(Collectors.toList());
        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            for (Future future : futures) {
                isDone &= future.isDone();
            }
            Thread.sleep(200);
        }
        futures.stream().forEach(fut -> {
            try {
                System.out.println("Result is: " + fut.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
