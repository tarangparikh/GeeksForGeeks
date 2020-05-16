import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class NumberFormation {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    long[][][] dp;
    long[][] precompute;
    long mod = 1000000007;
    void initialize(){
        dp = new long[][][]{};
        precompute = new long[3][101];
        precompute[0][0] = 4;
        precompute[1][0] = 5;
        precompute[2][0] = 6;
        for(int i = 1;i<101;i++){
            precompute[0][i] = (precompute[0][i-1] * 10)%mod;
            precompute[1][i] = (precompute[1][i-1] * 10)%mod;
            precompute[2][i] = (precompute[2][i-1] * 10)%mod;
        }
        System.out.println(Arrays.deepToString(precompute));
    }
    void solve(int x, int y, int z, long[][][] dps0){

    }

    void run() throws IOException {
        initialize();
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        NumberFormation object;
        if (local_system) object = new NumberFormation(new FileInputStream("input"), System.out);
        else object = new NumberFormation(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public NumberFormation(InputStream in, OutputStream out) {
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
