package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (personas[j].getNombre().compareTo(personas[j + 1].getNombre()) > 0) {
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
            Person temp = personas[i];
            personas[i] = personas[minIndex];
            personas[minIndex] = temp;
        }
    }

    public void sortByNameWithInsertion(Person[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Person key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getNombre().compareTo(key.getNombre()) > 0) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }

    public void sortByEdadWithImprovedBubble(Person[] personas) {
        int n = personas.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (personas[j].getEdad() > personas[j + 1].getEdad()) {
                    Person temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
