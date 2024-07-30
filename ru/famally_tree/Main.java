package ru.famally_tree;

import ru.famally_tree.FamilyTree.FamilyTree;
import ru.famally_tree.Filehandler.FileHandler;
import ru.famally_tree.Human.Gender;
import ru.famally_tree.Human.Human;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();

        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(1900, 9, 10), LocalDate.of(1970,9,12),null,null,null);
        Human lena = new Human("Лена", Gender.Famale, LocalDate.of(1905, 11, 11),LocalDate.of(1973,12,11),null,null,igor);
        Human nasty = new Human("Настя", Gender.Famale, LocalDate.of(1930, 12, 15),LocalDate.of(2010,11,17),lena, igor,null);
        tree.addHumans(igor);
        tree.addHumans(lena);
        tree.addHumans(nasty);

        Human grandMother = new Human("Лариса", Gender.Famale, LocalDate.of(1840, 03, 22),null,null,null,null);
        grandMother.addChildren(igor);
        tree.addHumans(grandMother);

        System.out.println(tree);

        saveThree(tree);
        FamilyTree readTree = readTree();
//        System.out.println("Сохрарены данные\n" + readTree);

        tree.sortByAge();
        System.out.println(tree);

        tree.sortByName();
        System.out.println(tree);

//        Команды для пользователя:
//        1. команда добавления в древо людей непосредственно пользавотелем
//                2.команда редактирование людей
//                3.команда выборка по конкретным значениям людей





//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Tree.out"));
//        out.writeObject(tree);
//        out.close();

//        FileInputStream fileInputStream = new FileInputStream("Tree.out");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        FamilyTree tree2 = (FamilyTree) objectInputStream.readObject();
//
//        System.out.println(tree2);


    }

    private static void saveThree(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);

    }

    private static FamilyTree readTree(){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }


}
