package ds;

import java.util.Arrays;

public class TRIE {
    private final int SIZE = 26;
    private class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            this.children = new Node[SIZE];
            Arrays.fill(this.children,null);
            isEnd = false;
        }
    }
    private Node root;
    TRIE(){
        root = new Node();
    }
    void insert(String data){
        Node curr = this.root;
        for(int i = 0,h=data.length();i<h;i++){
            int index = data.charAt(i) - 'a';
            if(curr.children[index]==null) curr.children[index] = new Node();
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    boolean contains(String data){
        Node curr = this.root;
        for(int i = 0,h=data.length();i<h;i++){
            int index = data.charAt(i) - 'a';
            if(curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        return curr.isEnd;
    }
}
