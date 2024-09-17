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
        // TODO
        return 0.0f;
    }

    private int[] average_helper(){
        // TODO
        return new int[]{0};
    }

    public boolean contains(int item){
        // TODO
        return false;
    }

    public int[] leaves(){
        // TODO
        return new int[]{};
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
        // TODO
        return stringIndented(0);
    }

    private String stringIndented(int depth){
        return "";
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
