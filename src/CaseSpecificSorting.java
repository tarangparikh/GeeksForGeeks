import java.io.*;
import java.util.*;

public class CaseSpecificSorting {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(String data){
        PriorityQueue<Character> low = new PriorityQueue<>();
        PriorityQueue<Character> upp = new PriorityQueue<>();
        for(int i = 0,h=data.length();i<h;i++){
            if(data.charAt(i)>='a'&&data.charAt(i)<='z') low.add(data.charAt(i));
            else upp.add(data.charAt(i));
        }
        //System.out.println(low+" "+upp);
        char[] send = new char[data.length()];
        for(int i = 0,h=send.length;i<h;i++){
            if(data.charAt(i)>='a'&&data.charAt(i)<='z'){
                send[i] = (char)low.poll();
            }else{
                send[i] = (char)upp.poll();
            }
        }
        return new String(send);
    }

    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            getInt();
            sb.append(solve(bf.readLine())).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        CaseSpecificSorting object;
        if (local_system) object = new CaseSpecificSorting(new FileInputStream("input"), System.out);
        else object = new CaseSpecificSorting(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CaseSpecificSorting(InputStream in, OutputStream out) {
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
