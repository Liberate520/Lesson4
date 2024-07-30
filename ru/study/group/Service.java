package ru.study.group;

import java.util.Collections;

public class Service {
    private StydentGroup<Student> stydentGroup;
    private StudentBuilder studentBuilder;

    public Service(){
        stydentGroup = new StydentGroup();
        studentBuilder = new StudentBuilder();
    }

    public void addStudent(String name,int age){
        Student student = studentBuilder.buld(name,age);
        stydentGroup.addStydent(student);
    }

    public String getStudentsListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List students:\n");
        for (Student student: stydentGroup){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public void sortByName(){
        stydentGroup.sortByName();
    }

    public void sortByAge(){;
        stydentGroup.sortByAge();
    }


}
