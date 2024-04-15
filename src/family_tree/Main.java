package family_tree;

import java.time.LocalDate;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

public class Main {
    public static void main(String[] args) {
        String filePath = "family_tree/writer/tree.txt";
        // FamilyTree tree = read(filePath):

        FamilyTree tree = testTree();
        System.out.println(tree);

        save(tree, filePath);
    }

    static FamilyTree read(String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    static void save(FamilyTree family_tree, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(family_tree, filePath);
    }

    static FamilyTree tesTree() {
        FamilyTree tree = new FamilyTree();

        Human valentin = new Human("Валентин", Gender.Male, LocalDate.of(1958, 4, 7));
        Human tatyana = new Human("Татьяна", Gender.Female, LocalDate.of(1959, 9, 15));
        tree.add(valentin);
        tree.add(tatyana);
        tree.setWedding(valentin, tatyana);

        Human aleksandr = new Human("Александр", Gender.Male, LocalDate.of(1980, 9, 3));
        tree.add(aleksandr);

        return tree;
    }

}
