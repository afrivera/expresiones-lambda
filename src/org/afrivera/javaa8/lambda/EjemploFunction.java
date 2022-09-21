package org.afrivera.javaa8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        // recibe un argumento y devuelve un valor
        // el primer valor es el que recibe y el segundo el que devuelve
        Function<String, String> f1 = param -> "Hola que tal " + param;
        String r = f1.apply("Andres");
        System.out.println(r);

        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("andres"));

        BiFunction<String, String, String> f3 = (a, b)-> a.toUpperCase().concat(b.toUpperCase());
        System.out.println(f3.apply("andres", "felipe"));

        // BiFunction<String, String, Integer> f4 = (a,b)-> a.compareTo(b);
        BiFunction<String, String, Integer> f4 = String::compareTo;
        System.out.println(f4.apply("andres", "andress"));

        BiFunction<String, String, String> f5 = String::concat;
        System.out.println(f5.apply("andres", "andress"));

    }
}
