/**
 * Abstract class representing a MultiSet ADT.
 */
public abstract class MultiSet {

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    abstract void add(Integer item);

    /**
     * Remove the given item from this multiset
     *
     * @param item the item to remove
     */
    abstract void remove(Integer item);

    /**
     * Returns if an item is in the multiset.
     *
     * @param item the item to find
     * @return whether the item is in the multiset
     */
    abstract boolean contains(Integer item);

    /**
     * Returns if the multiset is empty.
     *
     * @return whether the set is empty
     */
    abstract boolean isEmpty();

    /**
     * Count the number of the given item in the multiset.
     *
     * @param item the item to count occurrences of
     * @return Integer the number of occurrences of the item
     */
    abstract Integer count(Integer item);

    /**
     * Gets the size of this multiset.
     *
     * @return Size of the multiset
     */
    abstract Integer size();
    abstract void doNothing();
}
