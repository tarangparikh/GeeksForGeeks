import java.io.*;
import java.util.PriorityQueue;


public class MinimumCostOfRopes {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    public void solve(long[] data){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(long d : data) queue.add(d);
        long count = 0;
        //sb.append(queue).append("\n");
        while (queue.size() > 1){
             long a = queue.poll();
             long b = queue.poll();
             queue.add(a+b);
             count+=(a+b);
        }
        sb.append(count).append("\n");
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            solve(longs(getInt()));
        }
        writer.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MinimumCostOfRopes object;
        if (local_system)
            object = new MinimumCostOfRopes(new FileInputStream("input"), System.out);
        else object = new MinimumCostOfRopes(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public MinimumCostOfRopes(InputStream in, OutputStream out) {
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
