package controllers;

import models.Person;

public class SearchMethods {

    public Person searchByNameWithLinear(Person[] personas, String name) {
        for (Person persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(name)) {
                return persona;
            }
        }
        return null;
    }

    public Person searchByEdadWithLinear(Person[] personas, int edad) {
        for (Person persona : personas) {
            if (persona.getEdad() == edad) {
                return persona;
            }
        }
        return null;
    }

    public Person searchByNameWithBinary(Person[] personas, String name) {
        int left = 0, right = personas.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = personas[mid].getNombre().compareToIgnoreCase(name);
            if (comparison == 0) {
                return personas[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Person searchByEdadWithBinary(Person[] personas, int edad) {
        int left = 0, right = personas.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (personas[mid].getEdad() == edad) {
                return personas[mid];
            } else if (personas[mid].getEdad() < edad) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
