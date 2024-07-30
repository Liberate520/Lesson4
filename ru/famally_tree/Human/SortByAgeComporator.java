package ru.famally_tree.Human;

import ru.famally_tree.FamilyTree.ItemFamalyTree;

import java.util.Comparator;

public class SortByAgeComporator<E extends ItemFamalyTree> implements Comparator<E> {


    @Override
    public int compare(E o1, E o2) {
        return o2.getAge() - o1.getAge();
    }
}
