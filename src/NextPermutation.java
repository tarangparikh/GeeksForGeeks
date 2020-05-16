import sun.awt.X11.XStateProtocol;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextPermutation {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    private String solve(int[] data){
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[data.length];
        Arrays.fill(min,-1);
        for(int i = data.length-1;i>=0;i--){
            if(!stack.isEmpty()){
                while (!stack.isEmpty()&&data[stack.peek()]>data[i]){
                    min[stack.pop()] = i;
                }
            }
            stack.push(i);
        }
        int m = -1;
        for(int i=data.length-1;i>=0;i--){
            if(m==-1){
                if(min[i]>-1){
                    m = i;
                }
            }
            else if(min[i]>min[m]){
                m = i;
            }
        }
        //System.out.println(Arrays.toString(min));
        if(m == -1){
            Arrays.sort(data);
            makeString(data);
        }else{
            int temp = data[m];
            data[m] = data[min[m]];
            data[min[m]] = temp;
            Arrays.sort(data,min[m]+1,data.length);
        }
        return makeString(data);
    }
    private String solve1(int[] data){
        int j = -1;
        for(int i = data.length-2;i>=0;i--){
            if(data[i]<data[i+1]){
                j = i;
                break;
            }
        }
        if(j==-1){
            Arrays.sort(data);
            return makeString(data);
        }
        int max = j+1;
        for(int i = j+1, h=data.length;i<h;i++){
            if(data[i] > data[j] && data[i] < data[max] ){
                max = i;
            }
        }
        int[] d = new int[50];
                
        int temp = data[j];
        data[j] = data[max];
        data[max] = temp;
        Arrays.sort(data,j+1,data.length);
        return makeString(data);
    }
    void run() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int t = getInt();
        while (t-->0){
            stringBuilder.append(solve1(ints(getInt()))).append("\n");
        }
        writer.println(stringBuilder.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        NextPermutation object;
        if (local_system) object = new NextPermutation(new FileInputStream("input"), System.out);
        else object = new NextPermutation(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public NextPermutation(InputStream in, OutputStream out) {
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

    public String makeString(int[] data){
        StringBuilder sb = new StringBuilder();
        for(int e : data) sb.append(e).append(" ");
        return sb.toString().trim();
    }

    public void close() {
        this.writer.flush();
        this.writer.close();
    }
}
