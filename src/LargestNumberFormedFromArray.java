
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LargestNumberFormedFromArray {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(int[] data){
        StringBuilder sb = new StringBuilder();
        Integer[] box = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int len(int num){
                if(num==0) return 1;
                int len = 0;
                while (num/10>0){
                    len++;
                    num/=10;
                }
                return ++len;
            }
            @Override
            public int compare(Integer o1, Integer o2) {
                int lenA = len(o1);
                int lenB = len(o2);
               int compA,compB;
               int mul,i;
               for(i = 0,mul = 1;i<lenA;i++,mul*=10);
                compB = o2  * mul + o1;
               for(i = 0,mul=1;i<lenB;i++,mul*=10);
               compA = o1 * mul + o2;
               return Integer.compare(compB,compA);
            }
        };
        Arrays.sort(box,comparator);
        //System.out.println(Arrays.toString(box));
        Arrays.stream(box).forEach(sb::append);
        return sb.toString();
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
        LargestNumberFormedFromArray object;
        if (local_system) object = new LargestNumberFormedFromArray(new FileInputStream("input"), System.out);
        else object = new LargestNumberFormedFromArray(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public LargestNumberFormedFromArray(InputStream in, OutputStream out) {
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
