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
        System.out.print(message);
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println("LOG" + message);

    }    
    public int selec
}
