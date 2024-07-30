package ru.zoo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        List<Speakable> animals = new ArrayList<>();
        animals.add(new Cat("Муся"));
        animals.add(new Dog("Ларик"));
        animals.add(new Radio());


        NoiseZoo noiseZoo = new NoiseZoo(animals);
        noiseZoo.speakAll();


    }






}
