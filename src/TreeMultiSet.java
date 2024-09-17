public class TreeMultiSet extends MultiSet {

    Tree tree;

    public TreeMultiSet() {
        this.tree = new Tree(null);
    }
    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    void add(Integer item) {
        this.tree.insert(item);
    }

    @Override
    void remove(Integer item) {
        this.tree.deleteItem(item);
    }

    @Override
    boolean contains(Integer item) {
        return this.tree.contains(item);
    }

    @Override
    boolean isEmpty() {
        return this.tree.isEmpty();
    }

    @Override
    Integer count(Integer item) {
        return this.tree.count(item);
    }

    @Override
    Integer size() {
        return this.tree.length();
    }
}
