import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
    private int root;
    private ArrayList<Tree> subtrees;

    public Tree(int root, Tree[] subtrees){
        this.root = root;
        this.subtrees = new ArrayList<Tree>();
        this.subtrees.addAll(Arrays.asList(subtrees));
    }
    public Tree(int root){
        this.root = root;
        this.subtrees = new ArrayList<Tree>();
    }

    public boolean isEmpty(){
        // TODO
        return false;
    }

    public int length(){
        // TODO
        return 0;
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
