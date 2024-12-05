package models;

public class Person {

    private String nombre;
    private int edad;

    public Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        System.out.println("Persona creada.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
