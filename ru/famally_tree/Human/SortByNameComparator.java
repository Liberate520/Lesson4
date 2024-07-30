package ru.famally_tree.Human;

import ru.famally_tree.FamilyTree.ItemFamalyTree;

import java.util.Comparator;

public class SortByNameComparator<E extends ItemFamalyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
