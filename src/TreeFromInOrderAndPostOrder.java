import java.util.HashMap;

public class TreeFromInOrderAndPostOrder {
    private static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            this.right = this.left = null;
        }
    }
    public static void run(){
        int[] in = new int[]{4 ,8, 2, 5 ,1 ,6 ,3, 7};
        int[] po = new int[]{8, 4 ,5 ,2 ,6 ,7, 3, 1};
        Node root = build(in,po,in.length);
        preOrder(root);
    }
    public static Node build(int[] in,int[] po,int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0,h=in.length;i<h;i++){
            map.put(in[i],i);
        }
        System.out.println(map);
        //return null;
        return build(in,po,new int[]{0,in.length-1},new int[]{0,po.length-1},map);
    }
    public static Node build(int[] in, int[] po, int[] ii, int[] pi, HashMap<Integer,Integer> map){
        if(ii[1]<ii[0]||pi[1]<pi[0]) return null;
        Node root = new Node(po[pi[1]]);
        int split = map.get(po[pi[1]]);
        int left_length = split - ii[0];
        int right_length = ii[1] - split;
        root.left = build(in,po,new int[]{ii[0],split-1},new int[]{pi[0],pi[0]+left_length-1},map);
        root.right = build(in,po,new int[]{split+1,ii[1]},new int[]{pi[0]+left_length,pi[0]+left_length+right_length-1},map);
        return root;
    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
