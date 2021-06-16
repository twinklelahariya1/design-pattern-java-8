package me.twinkle.supplier;

import java.util.function.Supplier;

class Lazy<T> {

    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (instance == null) {
            instance = supplier.get();
            supplier = null;
        }

        return instance;
    }
}
public class ProxyPattern {


    public static void main(String[] args) {

        int variable = 4;

        Lazy<Integer> temp = new Lazy<>(() -> compute(variable));

        if (variable > 5 && temp.get() > 10)
            System.out.println("True");
        else
            System.out.println("False");
    }
    private static int compute(int variable) {
        System.out.println("from compute");
        return variable * 2;
    }
}
