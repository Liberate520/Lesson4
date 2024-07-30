package ru.study.group;

public class StudentBuilder {
    private int genId;

    public Student buld(String name, int age){
        return new Student(genId++, name, age);
    }
}
