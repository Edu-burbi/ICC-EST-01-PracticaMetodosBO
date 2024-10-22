package controllers;

import models.Person;
import view.Views;

public class Controllers {
    private Views view;  
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private Person[] personas;

    public Controllers(Views view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.searchMethods = searchMethods;
        this.sortingMethods = sortingMethods;
        System.out.println("Controlador creado");
    }

    public void start() {
        int option = 0;
        do { 
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersons(); 
                    break;
                case 100: 
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (option != 100); 
    }

    public void inputPersons() {
        int numeroPersons = view.inputInt("Ingrese el número de personas: "); 
        personas = new Person[numeroPersons]; 
        for (int i = 0; i < numeroPersons; i++) {
            personas[i] = view.inputPerson(); 
        }
    }

    public void addPersons() {
        int numeroPersonas = view.inputInt("Ingrese el número de personas a adicionar: ");
        Person[] personasTotales = new Person[personas.length + numeroPersonas];

        for (int i = 0; i < personas.length; i++) {
            personasTotales[i] = personas[i];
        }

        for (int i = 0; i < numeroPersonas; i++) {
            personasTotales[personas.length + i] = view.inputPerson(); 
        }

    }
}
