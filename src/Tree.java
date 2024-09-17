import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class Tree {
    private Optional<Integer> root;
    private ArrayList<Tree> subtrees;

    public Tree(Optional<Integer> root, Tree[] subtrees){
        this.root = root;
        this.subtrees = new ArrayList<Tree>();
        this.subtrees.addAll(Arrays.asList(subtrees));
    }

    public Tree(Optional<Integer> root){
        this.root = root;
        this.subtrees = new ArrayList<Tree>();
    }

    public boolean isEmpty(){
        return this.root.isEmpty();
    }

    public int length(){
        if(this.isEmpty()){
            return 0;
        }
        int size = 1;
        for(Tree tree : subtrees){
            size += tree.length();
        }
        return size;
    }

    public int count(int item){
        if(this.isEmpty()){
            return 0;
        }
        int num = 0;
        if(this.root.get().equals(item)){
            num += 1;
        }
        for(Tree subtree : this.subtrees){
            num += subtree.count(item);
        }
        return num;
    }


    public float average(){
        if(this.isEmpty()){
            return 0.0f;
        }
        int[] avgValues = this.averageHelper();
        return 0.0f;
    }

    private int[] averageHelper(){
        if(this.isEmpty()){
            return new int[]{0,0};
        }
        int total = this.root.get();
        int size = 1;
        for (Tree subtree : subtrees) {
            int[] totalAndSize = subtree.averageHelper();
            total += totalAndSize[0];
            size += totalAndSize[1];
        }
        return new int[]{total, size};
    }

    public boolean contains(int item){
        if(this.isEmpty()){
            return false;
        }
        if(this.root.get().equals(item)){
            return true;
        }
        for(Tree subtree : subtrees){
            if(subtree.contains(item)){
                return true;
            }
        }
        return false;
    }

    public int[] leaves(){

        return new int[]{};
    }

    public boolean deleteItem(int item){
        if (isEmpty()) {
            return false;
        } else if (root.get() == item) { //root.isPresent() implied by check above
            deleteRoot();
        } else {
            for (Tree subtree : subtrees) {
                boolean deleted = subtree.deleteItem(item);
                if (deleted && subtree.isEmpty()) {
                    subtrees.remove(subtree); //mutating list while looping is ok b/c we return immediately
                    return true;
                } else if (deleted) {
                    return true;
                }
            }
        }
        return false;
    }

    private void deleteRoot(){
        if (isEmpty()) {
            root = Optional.empty();
        } else {
            Tree chosenSubtree = subtrees.remove(subtrees.size() - 1); //last subtree
            root = chosenSubtree.root;
            subtrees.addAll(chosenSubtree.subtrees);
        }
    }

    private int extractLeaf(){
        if (subtrees.isEmpty()) {
            Optional<Integer> oldRoot = root;
            root = Optional.empty();
            return oldRoot.get();  //precondition requires root.isPresent()
        } else {
            int leaf = subtrees.get(0).extractLeaf();
            // Need to check whether self._subtrees[0] is now empty,
            // and if so, remove it.
            if (subtrees.get(0).isEmpty()) {
                subtrees.remove(0);
            }
            return leaf;
        }
    }

    public void insert(int item){
        if (isEmpty()) {
            root = Optional.of(item);
        } else if (subtrees.isEmpty()) {  //root.isPresent() is implied by the case above
            subtrees.add(new Tree(Optional.of(item)));
        } else {
            Random random = new Random();
            if (random.nextInt(3) == 0) {
                subtrees.add(new Tree(Optional.of(item)));
            } else {
                int subtreeIndex = random.nextInt(subtrees.size());
                subtrees.get(subtreeIndex).insert(item);
            }
        }
    }

    public boolean insertChild(int item, int parent){
        if (isEmpty()) {
            return false;
        } else if (root.get() == parent) {  //root.isPresent() is implied by the case above
            subtrees.add(new Tree(Optional.of(item)));
        } else {
            for (Tree subtree : subtrees) {
                if (subtree.insertChild(item, parent)) {
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public String toString(){
        return stringIndented(0);
    }

    private String stringIndented(int depth){
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder s = new StringBuilder();
            s.append("  ".repeat(depth));
            s.append(root);
            s.append('\n');
            for (Tree subtree : subtrees) {
                s.append(subtree.stringIndented(depth + 1));
            }
            return s.toString();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tree)) {
            return false;
        }

        Tree otherTree = (Tree) other;

        if (this.isEmpty() && otherTree.isEmpty()) {
            return true;
        } else if (this.root != otherTree.root) {
            return false;
        } else if (this.subtrees.size() != otherTree.subtrees.size()) {
            return false;
        } else {
            for (int i = 0; i < this.subtrees.size(); i++) {
                if (!this.subtrees.get(i).equals(otherTree.subtrees.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }






}
