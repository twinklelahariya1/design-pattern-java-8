package me.twinkle.function;

import java.util.function.Function;

public class DecoratorPattern {

    private void printIt(int n, String msg, Function<Integer, Integer> function) {
        System.out.println(n + " " + msg + " : " + function.apply(n));
    }

    public static void main(String[] args) {
        new DecoratorPattern().run();
    }

    private void run() {

        Function<Integer, Integer> increment = e -> e + 1;
        Function<Integer, Integer> doubleValues = e -> e * 2;
        Function<Integer, Integer> half = e -> e / 2;
        Function<Integer, Integer> reset = e -> 0;

        printIt(2, "Increment", increment);
        printIt(3, "Half", half);

        printIt(10, "MixToRefactor and combine methods", increment.andThen(half).andThen(doubleValues).andThen(reset));

    }
}
