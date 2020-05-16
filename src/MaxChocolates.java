import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class MaxChocolates {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;


    int solve(int[] data,int n,int k){
        int[] prefix = new int[data.length + 1];

        for(int i = 1,h=prefix.length;i<h;i++){
            prefix[i] = (prefix[i-1] + data[i-1]);
        }

        HashMap<Integer,Integer> farthest = new HashMap<Integer,Integer>();

        for(int i = 1,h=prefix.length;i<h;i++){
            farthest.put(prefix[i]%k,i);
        }
        int found = -1;
        for(int i = 0,h=prefix.length - 1;i<h;i++){
            int search = (prefix[i]%k);
            if(farthest.containsKey(search)){
                int end = farthest.get(search);

                int sum = prefix[end] - prefix[i];

                if(end!=i+1)
                    found = Math.max(sum/k,found);

            }
        }
        return found;
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int[] c = ints(2);
            sb.append(solve(ints(c[0]),c[0],c[1])).append("\n");
        }
        writer.println(sb.toString().trim());

        System.out.println(5%1);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MaxChocolates object;
        if (local_system) object = new MaxChocolates(new FileInputStream("input"), System.out);
        else object = new MaxChocolates(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public MaxChocolates(InputStream in, OutputStream out) {
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
