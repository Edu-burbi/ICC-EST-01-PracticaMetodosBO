package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (personas[j].getNombre().compareTo(personas[j + 1].getNombre()) > 0) {
                    // Intercambiar personas[j] y personas[j + 1]
                    Person temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    public void sortByEdadWithSelection(Person[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (personas[j].getEdad() < personas[minIndex].getEdad()) {
                    minIndex = j;
                }
            }
            // Intercambiar personas[i] y personas[minIndex]
            Person temp = personas[i];
            personas[i] = personas[minIndex];
            personas[minIndex] = temp;
        }
    }
}
