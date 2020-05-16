import java.io.*;
import java.util.*;

public class BooleanParenthesization {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    private int solve(String data){
        int[][][] dp = new int[2][data.length()][data.length()];
        for(int[][] dpp : dp){
            for(int[]  dppp : dpp){
                Arrays.fill(dppp,-1);
            }
        }
        int truep = solveTrue(data,0,data.length()-1,dp);
        return truep;
    }
    private int solveTrue(String data,int start,int end,int[][][] dp){
        if(dp[0][start][end]!=-1) return dp[0][start][end];
        if(start==end){
            return dp[0][start][end] = data.charAt(start) == 'F' ? 0 : 1;
        }
        int sum = 0;
        char current = '0';
        for(int i = start;i<=end;i+=2){


            if(current=='0') current = data.charAt(i);
            else if(data.charAt(i)=='T'){
                if(data.charAt(i-1)=='^'){
                    if(current=='T') current = 'F';
                    else current = 'T';
                }else if(data.charAt(i-1)=='|'){
                    current = 'T';
                }else{
                    if (current != 'T') {
                        current = 'F';
                    }
                }
            }else{
                if(data.charAt(i-1)=='^'){

                }else if(data.charAt(i-1)=='|'){

                }else{

                }
            }


            if(data.charAt(i)=='T'){
                if(i==end){
                  ///  sum += solveTrue(data,i,end,dp);
                }else if(data.charAt(i+1)=='^'){
                     sum += solveFalse(data,i+2,end,dp);
                }else if(data.charAt(i+1)=='|'){
                    sum += solveTrue(data,i+2,end,dp) + solveFalse(data,i+2,end,dp);
                }else{
                    sum += solveTrue(data,i+2,end,dp);
                }
            }else{
                if(i==end){
                  ///  sum += solveFalse(data,i,end,dp);
                }else if(data.charAt(i+1)=='^'){
                    sum += solveTrue(data,i+2,end,dp);
                }else if(data.charAt(i+1)=='|'){
                    sum += solveTrue(data,i+2,end,dp);
                }
            }
        }
        return dp[0][start][end] = sum;
    }
    private int solveFalse(String data,int start,int end,int[][][] dp){
        if(dp[1][start][end]!=-1) return dp[1][start][end];
        if(start==end){
            return dp[1][start][end] = data.charAt(start) == 'T' ? 0 : 1;
        }
        int sum = 0;
        for(int i = start;i<=end;i+=2){
            if(data.charAt(i)=='T'){
                if(i==end){
                   /// sum += solveTrue(data,i,end,dp);
                }else if(data.charAt(i+1)=='^'){
                    sum += solveTrue(data,i+2,end,dp);
                }else if(data.charAt(i+1)=='&'){
                    sum += solveFalse(data,i+2,end,dp);
                }
            }else{
                if(i==end){
                   /// sum += solveFalse(data,i,end,dp);
                }else if(data.charAt(i+1)=='^'){
                    sum += solveFalse(data,i+2,end,dp);
                }else if(data.charAt(i+1)=='|'){
                    sum += solveFalse(data,i+2,end,dp);
                }else{
                    sum += solveTrue(data,i+2,end,dp) + solveFalse(data,i+2,end,dp);
                }
            }
        }
        return dp[1][start][end] = sum;
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
        BooleanParenthesization object;
        if (local_system) object = new BooleanParenthesization(new FileInputStream("input"), System.out);
        else object = new BooleanParenthesization(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public BooleanParenthesization(InputStream in, OutputStream out) {
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
