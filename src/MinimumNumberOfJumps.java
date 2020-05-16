import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

public class MinimumNumberOfJumps {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    class ST {
        private int[] t;
        public ST(int size){
            this.t = new int[size<<1];
        }
        public void add(int i,int value){
            i += t.length / 2;
            t[i] += value;
            for (; i > 1; i >>= 1)
                t[i >> 1] = Math.min(t[i], t[i ^ 1]);
        }
        public int get(int i) {
            return t[i + t.length / 2];
        }
        public int min(int a, int b) {
            int res = Integer.MAX_VALUE;
            for (a += t.length / 2, b += t.length / 2; a <= b; a = (a + 1) >> 1, b = (b - 1) >> 1) {
                if ((a & 1) != 0)
                    res = Math.min(res, t[a]);
                if ((b & 1) == 0)
                    res = Math.min(res, t[b]);
            }
            return res;
        }
    }

    static boolean local_system = true;
    private String solve(int[] data){
        ST st = new ST(data.length);
        for(int i = data.length-2,h=data.length-1;i>=0;i--){
            if(data[i]!=0) {
                if(i + data[i] > h) st.add(i,1);
                else{
                    int value = st.min(i + 1,i + data[i]);
                    st.add(i,value == Integer.MAX_VALUE ? Integer.MAX_VALUE : value + 1);
                }
            }else{
                st.add(i,Integer.MAX_VALUE);
            }
        }
        return st.get(0) == Integer.MAX_VALUE ? "-1" : Integer.toString(st.get(0));
    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(ints(getInt()))).append("\n");
        }
        writer.println(sb.toString());
    }

    public static void main(String... args) throws IOException {
        long start_time = System.currentTimeMillis();
        MinimumNumberOfJumps object;
        if (local_system)
            object = new MinimumNumberOfJumps(new FileInputStream("input"), System.out);
        else object = new MinimumNumberOfJumps(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public MinimumNumberOfJumps(InputStream in, OutputStream out) {
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
