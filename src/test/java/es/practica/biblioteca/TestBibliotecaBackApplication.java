package es.practica.biblioteca;

import org.springframework.boot.SpringApplication;

public class TestBibliotecaBackApplication {

    public static void main(String[] args) {
        SpringApplication.from(BibliotecaBackApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
