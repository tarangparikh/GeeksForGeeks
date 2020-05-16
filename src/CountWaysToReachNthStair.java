import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class CountWaysToReachNthStair {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    long[] value;
    void precompute(){
        long mod = 1000000007;
        value = new long[105];
        value[1] = 1;
        for(int i = 2,h=value.length;i<h;i++){
            value[i] = (value[i-1] + value[i-2]) % mod;
        }

    }


    void run() throws IOException {
        precompute();
        for(int t = getInt();t>0;t--){
            sb.append(value[getInt()+1]).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CountWaysToReachNthStair object;
        if (local_system) object = new CountWaysToReachNthStair(new FileInputStream("input"), System.out);
        else object = new CountWaysToReachNthStair(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CountWaysToReachNthStair(InputStream in, OutputStream out) {
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
