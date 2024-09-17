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
        // TODO
        return 0;
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
    public boolean equals(Object other){
        // TODO
        return true;
    }






}
