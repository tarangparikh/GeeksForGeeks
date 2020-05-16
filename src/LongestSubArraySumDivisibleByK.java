import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArraySumDivisibleByK {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    int solve(int[] data,int k){
        int[] prefix = new int[data.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1,h=prefix.length;i<h;i++){
            int current = prefix[i-1] + data[i-1];
            prefix[i] = modulo(current,k);
            if(!map.containsKey(prefix[i])) map.put(prefix[i],i);
            map.put(prefix[i],i);
        }
        int mlen = 0;
        for(int i = 0,h=prefix.length-1;i<h;i++){
            if(map.containsKey(prefix[i])){
                mlen = Math.max(mlen,map.get(prefix[i]) - i);
            }
        }
        return mlen;
    }
    int modulo(int a,int k){
        int factor = a < 0 ? (-a) % k == 0 ? (-a) / k : (-a) / k + 1 : 0;
        return (a + (factor * k))%k;
    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int[] c = ints(2);
            int[] d = ints(c[0]);
            sb.append(solve(d,c[1])).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        LongestSubArraySumDivisibleByK object;
        if (local_system) object = new LongestSubArraySumDivisibleByK(new FileInputStream("input"), System.out);
        else object = new LongestSubArraySumDivisibleByK(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public LongestSubArraySumDivisibleByK(InputStream in, OutputStream out) {
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
