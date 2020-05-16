import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class SubArrayWithEqualZeroAndOne {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    int solve(int[] data){
        int[] prefix = new int[data.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1,h=prefix.length;i<h;i++){
            prefix[i] = prefix[i-1] + (data[i-1] == 0 ? -1 : data[i-1]);
            if(!map.containsKey(prefix[i])) map.put(prefix[i],0);
            map.put(prefix[i],map.get(prefix[i]) + 1);
        }
        int count = 0;
        for(int i = 0,h=prefix.length - 1;i<h;i++){
            if(map.containsKey(prefix[i])) count+=map.get(prefix[i]);
            if(map.containsKey(prefix[i+1])){
                map.put(prefix[i+1],map.get(prefix[i+1]) - 1);
            }
        }
        return count;
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
        SubArrayWithEqualZeroAndOne object;
        if (local_system) object = new SubArrayWithEqualZeroAndOne(new FileInputStream("input"), System.out);
        else object = new SubArrayWithEqualZeroAndOne(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public SubArrayWithEqualZeroAndOne(InputStream in, OutputStream out) {
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
