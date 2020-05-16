import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class OccurencesOf2AsAdigit {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int[] data = new int[100005];
        for(int i = 1;i<data.length;i++){
            data[i] = data[i-1] + count(i);
        }
        int t = getInt();
        while (t-->0){
            sb.append(data[getInt()]).append("\n");
        }
        writer.println(sb.toString().trim());
    }
    int count(int n){
        int count = 0;
        while (n>0){
            int crr = n%10;
            count = crr == 2 ? count + 1 : count;
            n/=10;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        OccurencesOf2AsAdigit object;
        if (local_system) object = new OccurencesOf2AsAdigit(new FileInputStream("input"), System.out);
        else object = new OccurencesOf2AsAdigit(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public OccurencesOf2AsAdigit(InputStream in, OutputStream out) {
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
