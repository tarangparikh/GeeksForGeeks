import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CountOfSubArrays {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(int[] data,int k){
        int[][] lr = new int[2][data.length];
        for(int[] l : lr) Arrays.fill(l,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = data.length-1;i>=0;i--){
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()&&data[stack.peek()]<data[i]){
                    lr[0][stack.peek()] = i;
                    stack.pop();
                }
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i = 0; i < data.length; i++){
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()&&data[stack.peek()]<data[i]){
                    lr[1][stack.peek()] = i;
                    stack.pop();
                }
            }
            stack.push(i);
        }

        for(int i = 0,h=data.length;i<h;i++)
        {
            if(lr[0][i]!=-1) lr[0][i]+=1;
            if(lr[1][i]!=-1) lr[1][i]-=1;

            //left side
            if(lr[0][i]==-1) lr[0][i] = 0;
            //right side
            if(lr[1][i]==-1) lr[1][i] = data.length-1;

        }





        long sum = 0;
        for(int i = 0,h=data.length;i<h;i++){
            if(data[i]>k){
                sum+=(lr[1][i] - lr[0][i] + 1);
            }
        }
        for(int[] d : lr){
            System.out.println(Arrays.toString(d));
        }


        return Long.toString(sum);



    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int[] c = ints(2);
            sb.append(solve(ints(c[0]),c[1])).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CountOfSubArrays object;
        if (local_system) object = new CountOfSubArrays(new FileInputStream("input"), System.out);
        else object = new CountOfSubArrays(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CountOfSubArrays(InputStream in, OutputStream out) {
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
