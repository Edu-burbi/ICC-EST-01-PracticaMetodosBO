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

        if(personas == null){
            view.showMessage("No existe, ingrese las palabras por primer vez: ");
            inputPersons();
        }else{
            int numeroPersonas = view.inputInt("Ingrese el número de personas a adicionar: ");
            Person[] personasTotales = new Person[personas.length + numeroPersonas];

            for (int i = 0; i < personas.length; i++) {
            personasTotales[i] = personas[i];
            }

            for (int i = personas.length; i < personas.length; i++) {
            personas[i] = view.inputPerson(); 
            }

            personas= personasTotales;


    }
}

public void sortPersons() {
    if (personas == null || personas.length == 0) {
        view.showMessage("No hay personas para ordenar.");
        return;
    }

    int sortintOption = view.selectSortingMethods();

    if (sortintOption == 1) {
        sortingMethods.sortByNameWithBubble(personas); // Asegúrate de pasar el array de personas
        view.showMessage("Personas ordenadas por nombre.");
    } else if (sortintOption == 2) {
        sortingMethods.sortByEdadWithSelection(personas); // Asegúrate de pasar el array de personas
        view.showMessage("Personas ordenadas por edad.");
    } else {
        view.showMessage("Opción no válida");
    }

}
    }
