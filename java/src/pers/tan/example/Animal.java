package pers.tan.example;

public class Animal {

    private String name = "animal";

    public Animal() {
        printinfo();
    }

    public void printinfo() {
        System.out.println(name);
    }
}


class Dog extends Animal {

    private String name = "dog";
    public void printinfo() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
    }
}