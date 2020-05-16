import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class LongestValidParenthesis {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    int solve(String data){
        int[] hash = new int[data.length()];
        int max = 0;
        for(int i = 0,h=data.length();i<h;i++){
            if(data.charAt(i)=='('){
                hash[i] = 0;
            }else{
                int prev = i-1;
                if(prev<0) hash[i] = 0;
                else {
                    int value = hash[prev];

                    int jump = i - value - 1;


                    if (jump >= 0 && data.charAt(jump) == '(') {
                        int curr = value + 2;
                        if (jump - 1 >= 0) {
                            curr += hash[jump - 1];
                        }
                        hash[i] = curr;

                    } else {
                        hash[i] = 0;
                    }

                }
            }
            max = Math.max(hash[i],max);
        }
        //System.out.println(Arrays.toString(hash));
        return max;
    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(bf.readLine())).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        LongestValidParenthesis object;
        if (local_system) object = new LongestValidParenthesis(new FileInputStream("input"), System.out);
        else object = new LongestValidParenthesis(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public LongestValidParenthesis(InputStream in, OutputStream out) {
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
