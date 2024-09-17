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

    /**
     * Remove the given item from this multiset.
     *
     * @param item the item to remove
     */
    @Override
    void remove(Integer item) {
        this.tree.deleteItem(item);
    }

    /**
     * Return whether the multiset includes the given item
     *
     * @param item the item to search for
     * @return whether the item is in the multiset
     */
    @Override
    boolean contains(Integer item) {
        return this.tree.contains(item);
    }

    /**
     * Return whether the multiset is empty.
     *
     * @return whether the multiset is empty
     */
    @Override
    boolean isEmpty() {
        return this.tree.isEmpty();
    }

    /**
     * Return the multiplicity of the given item.
     *
     * @param item the item to search for
     * @return the multiplicity of the item
     */
    @Override
    Integer count(Integer item) {
        return this.tree.count(item);
    }

    /**
     * Return the size of the multiset
     *
     * @return the total number of items in the multiset
     */
    @Override
    Integer size() {
        return this.tree.length();
    }
}
