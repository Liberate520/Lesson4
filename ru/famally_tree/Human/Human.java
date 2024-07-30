package ru.famally_tree.Human;

import ru.famally_tree.FamilyTree.ItemFamalyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public  class Human implements Comparable<Human>, ItemFamalyTree<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birth;
    private LocalDate dead;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birth,LocalDate dead,Human father,Human mother,Human spouse){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.dead = dead;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        this.spouse = spouse;

    }

    public Human(String name, Gender gender, LocalDate birth){
        this(name,gender,birth,null,null,null,null);
    }

    public Human(String name, Gender gender, LocalDate birth, Human mother, Human father){
        this(name, gender,birth,null,father,mother,null);
    }

    public boolean addChildren(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }
        if(parent.getGender().equals(Gender.Famale)){
            setMother(parent);
        }
        return true;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFather(Human father){
        this.father = father;
    }

    public void setMother(Human mother){
        this.mother = mother;
    }

    public Human getFather(){
        return father;
    }
    public Human getMother(){
        return mother;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>();
        if(father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if(dead == null){
            return getPeriod(birth, LocalDate.now());
        }else{
            return getPeriod(birth, dead);
        }
    }

    public int getPeriod(LocalDate birth, LocalDate dead){
        Period diff = Period.between(birth,dead);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    public Human getSpouse(){
        return spouse;
    }

    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public LocalDate  getBirth(){
        return birth;
    }

    public LocalDate getDead(){
        return dead;
    }

    public List<Human> getChildren(){
        return children;
    }

    public void setBirth(){
        this.birth = birth;
    }

    public void setDead(){
        this.dead = dead;
    }

    public Gender getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return  sb.toString();
    }

    public String getSpouseInfo(){
        String res = "spouse: ";
        if(spouse == null){
            res+= "no";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "mother: ";
        Human mother = getMother();
        if(mother != null){
            res += mother.getName();
        } else {
            res += "no";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "father: ";
        Human father = getFather();
        if(father != null){
            res += father.getName();
        } else {
            res += "no";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("child: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size() ; i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else {
            res.append("no");
        }
        return res.toString();
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human =(Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}