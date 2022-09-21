package org.afrivera.javaa8.lambda;

import org.afrivera.javaa8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        // evaluar una expresión booleana, siempre retorna un boolean
        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(17);
        System.out.println("r = " + r);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(test2.test("ROLE_ADMINd"));

        // BiPredicate<String, String> t3 = (a,b)-> a.equals(b);
        BiPredicate<String, String> t3 = String::equals;
        System.out.println(t3.test("andres", "andres"));

        BiPredicate<Integer, Integer> t4 = (i,j)->j>i;
        boolean r2 = t4.test(5,10);
        System.out.println("r2 = " + r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("Maria");
        b.setNombre("Mariaa");
        BiPredicate<Usuario, Usuario> t5 = (ua, ub)->ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a,b));
    }
}
