package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import family_tree.Human;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E>{
    private long humansId;
    private final List<E> humanList;

    public FamilyTree(List<E> humanList){this.humanList = humanList;}

    public FamilyTree(){this(new ArrayList<>());}

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeople++)
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }
    
    public List<E> getSiblings(int id){
        E human = getByld(id);
        if (human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent:human.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(humanId1, humanId2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else{
            return false;
        }
    }

    public boolean setDivorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(E human1, E human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }else {
            return false;
        }
    }

    public boolean remove(long humanId){
        if (checkId(humanId)){
            E human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < countPeople && id >= 0;
    }

    public E getById(long id){
        if (checkId(id)){
            for (E human: humanList){
                if (human.getId() == id){
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString(){return getInfo();}

    public String getInfo(){
        StringBuilder sb =new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append("объектов: \n");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {humanList.sort(new FamilyTreeComparatorByName<>());}

    public void sortByDeathDate() {humanList.sort(new FamilyTreeComparatorByBirthDate<>());}

    @Override
    public Iterator<E> iterator() {return new FamilyTreeIterator<>(humanList);}
    
}
