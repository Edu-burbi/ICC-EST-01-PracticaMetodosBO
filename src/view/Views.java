package view;

import java.util.Scanner; // Corregido

import models.Person;

public class Views {
    private Scanner scanner; // Declaración del Scanner

    // Constructor
    public Views() {
        this.scanner = new Scanner(System.in); // Inicialización del Scanner
    }

    public int showMenu() {
        System.out.println("Menú");
        System.out.println("1. Ingresar Personas");
        System.out.println("100. Salir");
        System.out.print("Ingrese una opción: ");

        return scanner.nextInt();
    }

    public Person inputPerson() {
        String name = inputName();
        int edad = inputEdad();
        return new Person(name, edad); // Corregido el nombre de la clase
    }

    public String inputName() {
        System.out.print("Ingrese el nombre: ");
        return scanner.next(); // Cambiado a next() para capturar un String
    }

    public int inputEdad() {
        return inputInt("Ingrese la edad: ");
    }

    public int inputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
