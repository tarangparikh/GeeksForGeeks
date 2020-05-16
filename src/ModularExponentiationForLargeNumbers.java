import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class ModularExponentiationForLargeNumbers {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    long solve(long[] data){
        return power(data[0],data[1],data[2]);
    }

    long power(long a,long b,long c){
        if(b==0) return 1L;
        long temp = power(a,b/2,c);
        if(b%2==0) return (temp*temp)%c;
        return (((temp*temp)%c)*a)%c;
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(longs(1))).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        ModularExponentiationForLargeNumbers object;
        if (local_system) object = new ModularExponentiationForLargeNumbers(new FileInputStream("input"), System.out);
        else object = new ModularExponentiationForLargeNumbers(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public ModularExponentiationForLargeNumbers(InputStream in, OutputStream out) {
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
