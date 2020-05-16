

import java.io.*;
import java.util.Arrays;


public class Trie {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    class TRIE {
        private final int SIZE = 26;
        private class Node{
            Node[] children;
            boolean isEnd;
            Node(){
                this.children = new TRIE.Node[SIZE];
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
                if(curr.children[index]==null) curr.children[index] = new TRIE.Node();
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

    int solve(String data,String search){
        TRIE trie = new TRIE();
        String[] tokens = data.split(" ");
        Arrays.stream(tokens).forEach(trie::insert);
        return trie.contains(search) ? 1 : 0;


    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            getInt();
            String data = bf.readLine().trim();
            String search = bf.readLine().trim();
            sb.append(solve(data,search)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        Trie object;
        if (local_system) object = new Trie(new FileInputStream("input"), System.out);
        else object = new Trie(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public Trie(InputStream in, OutputStream out) {
        this.writer = new PrintWriter(out);
        this.bf = new BufferedReader(new InputStreamReader(in));
        this.sb = new StringBuilder();
    }

    public int getInt() throws IOException {
        return Integer.parseInt(bf.readLine());
    }

    public long getLong() throws IOException {
        return Long.parseLong(bf.readLine());
    }

    public int[] ints(int size) throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Integer.parseInt(data[i]);
        return send;
    }

    public long[] longs(int size) throws IOException {
        String[] data = bf.readLine().split(" ");
        long[] send = new long[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = Long.parseLong(data[i]);
        return send;
    }

    public void close() {
        this.writer.flush();
        this.writer.close();
    }
}
