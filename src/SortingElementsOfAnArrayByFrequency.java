import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortingElementsOfAnArrayByFrequency {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String sort(int[] data){
        int[][] hash = new int[11][2];
        for(int i = 0,h=data.length;i<h;i++){
            hash[data[i]][0] = data[i];
            hash[data[i]][1]++;
        }
        StringBuilder ssb = new StringBuilder();
        Arrays.sort(hash,(o1, o2) -> {
            if(o1[1]!=o2[1]) return Integer.compare(o2[1],o1[1]);
            return Integer.compare(o1[0],o2[0]);
        });
        //System.out.println(Arrays.deepToString(hash));
        for(int i = 0,h=hash.length;i<h;i++){
            if(hash[i][1]!=0)
            for(int j = 0,v=hash[i][1];j<v;j++){
                ssb.append(hash[i][0]).append(" ");
            }
        }
        return ssb.toString().trim();
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(sort(ints(getInt()))).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        SortingElementsOfAnArrayByFrequency object;
        if (local_system) object = new SortingElementsOfAnArrayByFrequency(new FileInputStream("input"), System.out);
        else object = new SortingElementsOfAnArrayByFrequency(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public SortingElementsOfAnArrayByFrequency(InputStream in, OutputStream out) {
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
