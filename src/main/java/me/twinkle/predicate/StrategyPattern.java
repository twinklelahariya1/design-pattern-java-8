package me.twinkle.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {

    public static void main(String[] args) {
        new StrategyPattern().run();
    }

    private void run() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> evenOperation = e -> e % 2 == 0;
        Predicate<Integer> oddOperation = e -> e % 2 != 0;

        System.out.println(compute(integers, evenOperation));
        System.out.println(compute(integers, oddOperation));

    }

    private int compute(List<Integer> integers, Predicate<Integer> evenOperation) {
        return integers.stream()
                .filter(evenOperation)
                .mapToInt(e -> e)
                .sum();
    }
}
