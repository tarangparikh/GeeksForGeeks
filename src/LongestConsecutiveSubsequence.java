import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSubsequence {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    int solve(int[] data){
        Arrays.sort(data);
        int mlen = 1;
        int clen = 1;
        int prev = data[0];
        //sb.append(Arrays.toString(data)).append("\n");
        for(int i = 1 , h = data.length ;i<h;i++ ){
            if(prev==data[i]) continue;
            if(prev == data[i]-1){
                clen++;
                mlen = Math.max(mlen,clen);
            }else{
                clen = 1;
            }
            prev = data[i];
        }
        return mlen;
    }
    int[] scaleLength(int[] data){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0,h=data.length;i<h;i++){
            max = Math.max(max,data[i]);
            min = Math.min(min,data[i]);
        }
        return new int[]{max,min};
    }
    int solve1(int[] data){
        int[] mm = scaleLength(data);
        int scale = mm[1];
        int[] hash = new int[mm[0] - mm[1] + 1];
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int datum = data[i];
            hash[datum - scale]++;
        }
        int clen = 0;
        int mlen = 0;
        for(int h = hash.length,i=0;i<h;i++){
            if(hash[i]>0){
                clen++;
                mlen = Math.max(mlen,clen);
            }else{
                clen = 0;
            }
        }
        return mlen;
    }
    int solve2(int[] data,int n){
        int[] hash = new int[100005];
        int hash_len = 100005;
        for(int i = 0;i<n;i++) hash[data[i]] = 1;
        int mlen = 0;
        int clen = 0;
        for(int i = 0;i<hash_len;i++){
            if(hash[i]==1){
                clen++;
                mlen = clen > mlen ? clen : mlen;
            }else clen = 0;
        }
        return mlen;
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int s = getInt();
            int d[] = ints(s);
            sb.append(solve2(d,s)).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        LongestConsecutiveSubsequence object;
        if (local_system) object = new LongestConsecutiveSubsequence(new FileInputStream("input"), System.out);
        else object = new LongestConsecutiveSubsequence(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public LongestConsecutiveSubsequence(InputStream in, OutputStream out) {
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
