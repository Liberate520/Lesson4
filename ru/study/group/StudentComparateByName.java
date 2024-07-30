package ru.study.group;

import java.util.Comparator;

public class StudentComparateByName<T extends ItemStudyGroup> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
