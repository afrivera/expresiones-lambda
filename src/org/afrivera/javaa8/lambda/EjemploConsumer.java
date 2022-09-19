package org.afrivera.javaa8.lambda;

import org.afrivera.javaa8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " años");

        consumidorBi.accept("Andres", 32);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola Mundo lambda");

        List<String> nombres = Arrays.asList("Andres", "Felipe", "Rivera");
        nombres.forEach(consumidor2);

        Usuario user = new Usuario();

//        BiConsumer<Usuario, String> asignarNombre = (persona, nombre)->{
//            persona.setNombre(nombre);
//        };
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre; // simplificando lo de arriba

        asignarNombre.accept(user, "Andres");
        System.out.println("user = " + user.getNombre());

        // supplier no recibe argumento pero si devuelve un valor se describe el tipo de retorno
//        Supplier<String> proveedor = ()-> {
//            return "Hola Mundo";
//        };
        Supplier<String> proveedor = ()-> "Hola Mundo"; // simplificar lo de arriba
        System.out.println(proveedor.get()); // con get se recibe el valor

        // crear un Usuario
        Supplier<Usuario> creaUsuario = () -> new Usuario(); // otra forma Usuario::new
        Usuario nu = creaUsuario.get();
        asignarNombre.accept(nu, "Felipe");
        System.out.println("nu = " + nu.getNombre());

    }
}
