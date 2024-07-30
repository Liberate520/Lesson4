package ru.study.group;

import java.util.*;

public class StydentGroup<E extends ItemStudyGroup> implements Iterable<E> {
    private List<E> students;


    public StydentGroup() {

        students = new ArrayList<>();
    }

    public void addStydent(E student){

        students.add(student);
    }

    public void sortByName(){
        students.sort(new StudentComparateByName<>());
    }

    public void sortByAge(){
        students.sort(new StudentComporatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new StudentIterator<>(students);
    }


}
