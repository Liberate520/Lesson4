package ru.famally_tree.FamilyTree;

import ru.famally_tree.Human.Human;
import ru.famally_tree.Human.SortByAgeComporator;
import ru.famally_tree.Human.SortByNameComparator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemFamalyTree<E>> implements Serializable, Iterable<E> {

    private List<E> humans;
    private long humansId;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humans) {
        this.humans = humans;

    }

    public boolean addHumans(E human) {
        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            human.setId(humansId++);

            addToParent(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParent(E human) {
        for (E parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSibLins(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humans) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(humanId1, humanId2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorse(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorse(human1, human2);
        }
        return false;
    }

    public boolean setDivorse(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return setDivorse(human1, human2);
        }
        return false;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            E human = getById(humansId);
            return humans.remove(human);
        }
        return false;

    }

    public boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    public E getById(long id) {
        for (E human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();

    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();


    }

    public void sortByAge(){
        humans.sort(new SortByAgeComporator<>());
    }

    public void sortByName(){
        humans.sort(new SortByNameComparator<>());
    }


    @Override
    public String toString() {
        return info();
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Древо: ");
        sb.append(humans.size());
        sb.append(" людей: \n");
        for (E human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();

    }


    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(humans);
    }
}
