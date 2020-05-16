import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    String solve(int[] data,int k,int n){
        int[] hash = new int[100005];
        StringBuilder sb = new StringBuilder();

        int distinct = 0;
        for(int i = 0;i<k;i++){
            if(hash[data[i]]++==0) distinct++;
            //sb.append(distinct+" "+i).append("\n");
        }
        sb.append(distinct).append(" ");
        for(int i = k,h=data.length;i<h;i++){
               if(hash[data[i-k]]--==1) distinct--;
               if(hash[data[i]]++==0) distinct++;
               sb.append(distinct).append(" ");
        }
        return sb.toString().trim();
    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int[] c = ints(2);
            int[] data = ints(c[0]);
            sb.append(solve(data,c[1],c[0])).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CountDistinctElementsInEveryWindow object;
        if (local_system) object = new CountDistinctElementsInEveryWindow(new FileInputStream("input"), System.out);
        else object = new CountDistinctElementsInEveryWindow(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CountDistinctElementsInEveryWindow(InputStream in, OutputStream out) {
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
