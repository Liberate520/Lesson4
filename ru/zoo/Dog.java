package ru.zoo;

public class Dog extends Animal{
    private String name;

    public Dog(String name) {
        super(name);

    }

    @Override
    public void speak(){
        System.out.println("гав-гав");
    }
}
