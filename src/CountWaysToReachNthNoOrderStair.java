import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class CountWaysToReachNthNoOrderStair {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(getInt()/2+1).append("\n");
        }
        writer.println(sb.toString().trim());
    }


    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CountWaysToReachNthNoOrderStair object;
        if (local_system) object = new CountWaysToReachNthNoOrderStair(new FileInputStream("input"), System.out);
        else object = new CountWaysToReachNthNoOrderStair(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CountWaysToReachNthNoOrderStair(InputStream in, OutputStream out) {
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
