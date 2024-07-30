package ru.famally_tree.FamilyTree;

import ru.famally_tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T extends ItemFamalyTree> implements Iterator<T> {

    private List<T> list;
    private int index;

    public TreeIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    public boolean hasNext(){
        return index < list.size();
    }

    public T next(){
        return list.get(index++);
    }
}
