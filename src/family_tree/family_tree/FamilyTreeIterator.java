package family_tree.family_tree;



public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> list;
    private int index;

    public FamilyTreeIterator(List<Human> list) {
        this.list = list;
        index = 0;

    }

    @Override
    public boolean hasNext() {return index < list.size();}

    @Override
    public boolean next() {return list.get(index++);}
    
}
