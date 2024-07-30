package ru.study.group;

import java.util.Comparator;

public class StudentComporatorByAge<T extends ItemStudyGroup> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
