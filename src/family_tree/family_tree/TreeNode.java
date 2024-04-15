package family_tree;

public interface TreeNode<T> extends Serializable {
    void setId(long id);

    long getId();

    T getFather();

    T getMother();

    boolean addChild(T human);

    boolean addParent(T human);

    String getName();

    LocalDate getDeathDate();

    LocalDate getBiirthDate();

    List<T> getParents();

    List<T> getChildren();

    T getSpouse();

    void setSpouse(T human);

}
