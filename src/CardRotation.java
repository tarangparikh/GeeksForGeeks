import java.io.*;
import java.util.ArrayDeque;

public class CardRotation {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;


    String solve(int k){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = k;i>=1;i--){
            deque.addFirst(i);
            for(int j = i%deque.size();j>0;j--){
                deque.addFirst(deque.pollLast());
            }
            //System.out.println(deque);
        }
        StringBuilder sbb = new StringBuilder();
        deque.forEach(integer -> sbb.append(integer).append(" "));
        return sbb.toString().trim();
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(getInt())).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CardRotation object;
        if (local_system) object = new CardRotation(new FileInputStream("input"), System.out);
        else object = new CardRotation(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CardRotation(InputStream in, OutputStream out) {
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
