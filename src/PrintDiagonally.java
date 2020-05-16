
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class PrintDiagonally {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(int[] data,int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            for(int j = 0,cu = i-1;j<i;j++,cu+=(n-1)){
                sb.append(data[cu]).append(" ");
            }
        }

        for(int i = n-1,start = (n<<1) - 1;i>=1;i--,start+=(n)){
           for(int j = 0,cu = start;j<i;j++,cu+=n-1){
               sb.append(data[cu]).append(" ");
           }
        }
        return sb.toString().trim();
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int n = getInt();
            sb.append(solve(ints(n*n),n)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        PrintDiagonally object;
        if (local_system) object = new PrintDiagonally(new FileInputStream("input"), System.out);
        else object = new PrintDiagonally(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public PrintDiagonally(InputStream in, OutputStream out) {
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
