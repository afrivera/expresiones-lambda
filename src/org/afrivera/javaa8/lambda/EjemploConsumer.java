package org.afrivera.javaa8.lambda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EjemploConsumer {
    public static void main(String[] args) {

        // por defecto el Consumer solo acepta un dato como parametro y no retorna nada
        Consumer<String> consumidor = saludo-> System.out.println(saludo);
        Consumer<Date> fecha = fech ->{
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fech));
        };
        fecha.accept(new Date());

        // el BiConsumer acepta dos parámetros
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) ->{
            System.out.println(nombre + ", tiene " + edad + " años");
        };

        consumidorBi.accept("Andres", 32);

    }
}
