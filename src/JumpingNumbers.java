import java.io.*;
import java.util.*;

public class JumpingNumbers {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    void run() throws IOException {
        int t = getInt();
        TreeSet<Long> m = new TreeSet<>();
        ArrayDeque<Long> d = new ArrayDeque<>();
        m.add(0L);
        long limit = Integer.MAX_VALUE;
        int i = 1;
        while (i<=9) {
            d.addLast((long)i);
            while (!d.isEmpty()){
                long curr = d.pollFirst();
                long a = curr*10 + (curr%10) + 1;
                long b = curr*10 + (curr%10) - 1;


                //System.out.println(curr);
                if(curr%10==0){
                    m.add(curr);
                    if(a<=limit)
                        d.addLast(a);
                }else if(curr%10==9){
                    m.add(curr);
                    if(b<=limit)
                        d.addLast(b);
                }else{
                    m.add(curr);
                    if(a<=limit)
                        d.addLast(a);
                    if(b<=limit)
                        d.addLast(b);
                }
            }
            i++;
        }
        while (t-->0){
            for(Long e : m.headSet(getLong()+1)){
                sb.append(e).append(" ");
            }
            sb.append("\n");
        }
        writer.println(sb.toString().trim());
        //System.out.println(m);
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        JumpingNumbers object;
        if (local_system) object = new JumpingNumbers(new FileInputStream("input"), System.out);
        else object = new JumpingNumbers(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public JumpingNumbers(InputStream in, OutputStream out) {
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
