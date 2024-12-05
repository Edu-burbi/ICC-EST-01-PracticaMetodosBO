package view;

import java.util.Scanner;
import models.Person;

public class Views {
    private Scanner scanner;

    public Views() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("Menú");
        System.out.println("1. Ingresar Personas");
        System.out.println("2. Adicionar Personas");
        System.out.println("3. Ordenar Personas");
        System.out.println("4. Buscar Persona");
        System.out.println("100. Salir");
        System.out.print("Ingrese una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        String name = inputName();
        int edad = inputEdad();
        return new Person(name, edad);
    }

    public String inputName() {
        System.out.print("Ingrese el nombre: ");
        return scanner.next();
    }

    public int inputEdad() {
        return inputInt("Ingrese la edad: ");
    }

    public int inputInt(String message) {
        int value;
        while (true) {
            System.out.print(message);
            String input = scanner.next();
            if (isNumeric(input)) {
                value = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Valor incorrecto. Ingrese un número.");
            }
        }
        return value;
    }
    public void showMessage(String message) {
        System.out.println("LOG: " + message);
    }

    public void displayPersons(Person[] personas) {
        if (personas == null || personas.length == 0) {
            System.out.println("No hay personas para mostrar.");
            return;
        }
        System.out.println("Listado de personas:");
        for (Person persona : personas) {
            System.out.println(persona);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public int selectSortingMethods() {
        System.out.println("Opciones de ordenamiento:");
        System.out.println("1. Ordenar por nombre (Burbuja)");
        System.out.println("2. Ordenar por edad (Selección)");
        System.out.println("3. Ordenar por nombre (Inserción)");
        System.out.println("4. Ordenar por edad (Burbuja mejorada)");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int selectSearchMethod() {
        System.out.println("Opciones de búsqueda:");
        System.out.println("1. Buscar por nombre (Lineal)");
        System.out.println("2. Buscar por edad (Lineal)");
        System.out.println("3. Buscar por nombre (Binaria)");
        System.out.println("4. Buscar por edad (Binaria)");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+"); // Verifica si la cadena contiene solo dígitos
    }
}
