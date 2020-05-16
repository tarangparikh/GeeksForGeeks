import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextElementWithGreaterFrequency {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(int[] data){
        int[] current = new int[data.length];
        Arrays.fill(current,-1);
        int[] hash = new int[10];

        for(int e : data) hash[e]++;

        //System.out.println(Arrays.toString(hash));

        Stack<Integer> stack = new Stack<>();
        for(int i = 0,h=data.length;i<h;i++){
            //System.out.println(stack);
            if(!stack.isEmpty()){
                while (!stack.isEmpty()&&hash[data[stack.peek()]] < hash[data[i]]){
                    current[stack.pop()] = data[i];
                }
            }
            stack.push(i);
        }

        StringBuilder mm = new StringBuilder();
        for(int e : current){
            mm.append(e).append(" ");
        }
        return mm.toString().trim();
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(ints(getInt()))).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        NextElementWithGreaterFrequency object;
        if (local_system) object = new NextElementWithGreaterFrequency(new FileInputStream("input"), System.out);
        else object = new NextElementWithGreaterFrequency(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public NextElementWithGreaterFrequency(InputStream in, OutputStream out) {
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
