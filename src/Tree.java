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

        return true;
    }






}
