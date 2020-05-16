import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class PhoneDirectory {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
     class TRIE {
        private final int SIZE = 26;
        private class Node{
            Node[] children;
            ArrayDeque<Integer> deque;
            boolean isEnd;
            Node(){
                this.deque = new ArrayDeque<>();
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
        void insert(String data,int data_index){
            Node curr = this.root;
            for(int i = 0,h=data.length();i<h;i++){
                int index = data.charAt(i) - 'a';
                if(curr.children[index]==null) {
                    curr.children[index] = new Node();
                }
                curr.children[index].deque.addLast(data_index);
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
        String searchPrefix(String data,String[] directory){
            Node curr = this.root;
            for(int i = 0,h=data.length();i<h;i++){
                int index = data.charAt(i) -'a';
                if(curr.children[index]==null) return "0";
                curr = curr.children[index];
            }
            StringBuilder ss = new StringBuilder();
            for(Integer i : curr.deque){
                ss.append(directory[i]).append(" ");
            }
            return ss.toString().trim();
        }
    }

    String solve(String directory,String search){
         String[] data = directory.split(" ");
         TreeSet<String> sorted = new TreeSet<>(Arrays.asList(data));
         data = new String[sorted.size()];
         int k = 0;
         for(String s : sorted){
             data[k++] = s;
         }
         TRIE trie = new TRIE();
         for(int i = 0,h=data.length;i<h;i++){
             trie.insert(data[i],i);
         }
         StringBuilder curr = new StringBuilder();
         StringBuilder bb = new StringBuilder();
         for(int i = 0,h=search.length();i<h;i++){
             curr.append(search.charAt(i));
             bb.append(trie.searchPrefix(curr.toString(),data)).append("\n");
         }
        return bb.toString().trim();
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            getInt();
            String directory = bf.readLine().trim();
            String search = bf.readLine().trim();
            sb.append(solve(directory,search)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        PhoneDirectory object;
        if (local_system) object = new PhoneDirectory(new FileInputStream("input"), System.out);
        else object = new PhoneDirectory(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public PhoneDirectory(InputStream in, OutputStream out) {
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
