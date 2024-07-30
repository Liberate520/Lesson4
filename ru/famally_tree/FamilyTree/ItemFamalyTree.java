package ru.famally_tree.FamilyTree;

import ru.famally_tree.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ItemFamalyTree<Q> extends Serializable {
    boolean addChildren(Q human);
    boolean addParent(Q human);
    void setId(long id);
    long getId();
    String getName();
    LocalDate  getBirth();
    LocalDate getDead();
    List<Q> getParents();
    List<Q> getChildren();
    Q getFather();
    Q getMother();
    void setSpouse(Q human);
    Q getSpouse();
    int getAge();
    String getChildrenInfo();



}
