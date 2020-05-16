import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class MaximumCircularArraySum {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    int solve(int[] data){
        int[] ddata = new int[(data.length<<1) + 1];
        int len = data.length;
        System.arraycopy(data,0,ddata,1,data.length);
        System.arraycopy(data,0,ddata,data.length+1,data.length);
        for(int i = 1,h=ddata.length;i<h;i++) ddata[i] += ddata[i - 1];
        //sb.append(Arrays.toString(ddata)).append("\n");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 1,h=data.length+1;i<h;i++){
            if (!deque.isEmpty()) while (!deque.isEmpty() && ddata[deque.peekFirst()] <= ddata[i]) deque.pollFirst();
            deque.addFirst(i);
        }
        //sb.append(deque).append("\n");
        int sum = data[0];
        for(int i = 0,h=data.length;i<h;i++){
            int max = ddata[deque.peekLast()];
            //sb.append(i).append(" ").append(max).append(" ").append(deque.peekLast()).append("\n");
            sum = Math.max(sum,max-ddata[i]);
            while (!deque.isEmpty()&&deque.peekLast()<=i+1) deque.pollLast();
            while (!deque.isEmpty()&&ddata[deque.peekFirst()]<=ddata[i+len+1]) deque.pollFirst();
            deque.addFirst(i+len+1);
        }
        return sum;

    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(ints(getInt()))).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        MaximumCircularArraySum object;
        if (local_system) object = new MaximumCircularArraySum(new FileInputStream("input"), System.out);
        else object = new MaximumCircularArraySum(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public MaximumCircularArraySum(InputStream in, OutputStream out) {
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
