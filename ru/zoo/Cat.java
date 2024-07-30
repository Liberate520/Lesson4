package ru.zoo;

public class Cat extends Animal{
    private String name;
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak(){
        System.out.println("мяу-мяу");
    }
}
