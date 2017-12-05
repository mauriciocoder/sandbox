package com.bon.threads;

import lombok.Builder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Builder
public class SquareCalculator {
    private ExecutorService executor;

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("Start evaluatiing power of " + input);
            Thread.sleep(500);
            System.out.println("End calculation of power of " + input);
            return input * input;
        });
    }
}
