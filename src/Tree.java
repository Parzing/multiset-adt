import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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
        return root.isEmpty();
    }

    public int length(){
        if(isEmpty()){
            return 0;
        }
        int size = 1;
        for(Tree tree : subtrees){
            size += tree.length();
        }
        return size;
    }

    public int count(int item){
        if(isEmpty()){
            return 0;
        }
        int num = 0;
        if(root.get().equals(item)){
            num += 1;
        }
        for(Tree subtree : subtrees){
            num += subtree.count(item);
        }
        return num;
    }


    public float average(){
        if(isEmpty()){
            return 0.0f;
        }
        int[] avgValues = averageHelper();
        return 0.0f;
    }

    private int[] averageHelper(){
        if(isEmpty()){
            return new int[]{0,0};
        }
        int total = root.get();
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
        if(root.get().equals(item)){
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
        if(isEmpty()){
            return new int[]{};
        }
        if(subtrees.isEmpty()){
            return new int[]{root.get()};
        }
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for (Tree subtree : subtrees){
            for(int leaf : subtree.leaves()){
                leaves.add(leaf);
            }
        }
        int[] leafList = new int[leaves.size()];
        for (int i = 0; i < leaves.size(); i++){
            leafList[i] = leaves.get(i);
        }
        return leafList;
    }

    public boolean deleteItem(int item){
        // TODO
        return true;
    }

    private void deleteRoot(){
        // TODO
    }

    private int extractLeaf(){
        // TODO
        return 0;
    }

    public void insert(int item){
        // TODO
    }

    public boolean insertChild(int item, int parent){
        // TODO
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
