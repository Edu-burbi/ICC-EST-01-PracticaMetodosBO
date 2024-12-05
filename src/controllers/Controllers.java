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
                case 2:
                    addPersons();
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPersons();
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
        if (personas == null) {
            view.showMessage("No existen personas. Ingrese las personas por primera vez.");
            inputPersons();
        } else {
            int numeroPersonas = view.inputInt("Ingrese el número de personas a adicionar: ");
            Person[] personasTotales = new Person[personas.length + numeroPersonas];

            for (int i = 0; i < personas.length; i++) {
                personasTotales[i] = personas[i];
            }

            for (int i = personas.length; i < personasTotales.length; i++) {
                personasTotales[i] = view.inputPerson();
            }

            personas = personasTotales;
        }
    }

    public void sortPersons() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No hay personas para ordenar.");
            return;
        }

        int sortingOption = view.selectSortingMethods();

        switch (sortingOption) {
            case 1:
                sortingMethods.sortByNameWithBubble(personas);
                view.showMessage("Personas ordenadas por nombre (Método Burbuja).");
                break;
            case 2:
                sortingMethods.sortByEdadWithSelection(personas);
                view.showMessage("Personas ordenadas por edad (Método Selección).");
                break;
            case 3:
                sortingMethods.sortByNameWithInsertion(personas);
                view.showMessage("Personas ordenadas por nombre (Método Inserción).");
                break;
            case 4:
                sortingMethods.sortByEdadWithImprovedBubble(personas);
                view.showMessage("Personas ordenadas por edad (Burbuja Mejorada).");
                break;
            default:
                view.showMessage("Opción de ordenamiento no válida.");
        }

        displayPersons();
    }

    public void searchPersons() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No hay personas para buscar.");
            return;
        }

        int searchOption = view.selectSearchMethod();

        switch (searchOption) {
            case 1:
                String name = view.inputName();
                Person resultNameLinear = searchMethods.searchByNameWithLinear(personas, name);
                displaySearchResult(resultNameLinear);
                break;
            case 2:
                int age = view.inputEdad();
                Person resultAgeLinear = searchMethods.searchByEdadWithLinear(personas, age);
                displaySearchResult(resultAgeLinear);
                break;
            case 3:
                sortingMethods.sortByNameWithBubble(personas); // Ordenar antes de buscar
                String nameBinary = view.inputName();
                Person resultNameBinary = searchMethods.searchByNameWithBinary(personas, nameBinary);
                displaySearchResult(resultNameBinary);
                break;
            case 4:
                sortingMethods.sortByEdadWithSelection(personas); // Ordenar antes de buscar
                int ageBinary = view.inputEdad();
                Person resultAgeBinary = searchMethods.searchByEdadWithBinary(personas, ageBinary);
                displaySearchResult(resultAgeBinary);
                break;
            default:
                view.showMessage("Opción de búsqueda no válida.");
        }
    }

    public void displayPersons() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No hay personas para mostrar.");
            return;
        }

        view.showMessage("Lista de personas:");
        for (Person persona : personas) {
            System.out.println(persona);
        }
    }

    public void displaySearchResult(Person persona) {
        if (persona != null) {
            view.showMessage("Resultado de la búsqueda: " + persona);
        } else {
            view.showMessage("No se encontró ninguna persona.");
        }
    }
}
