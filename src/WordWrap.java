import java.io.*;

public class WordWrap {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;

    String solve(int[] data,int k){
        int p[] = new int[data.length+1];
        for(int i = 1,h=p.length;i<h;i++){
            p[i] = p[i-1]+data[i-1]+1;
        }
        //System.out.println(Arrays.toString(data)+" "+k+" "+Arrays.toString(p));
        StringBuilder mm = new StringBuilder();
        int c = 0;
        int ct = 0;
        for(int i = 0;i<data.length;i++){
            ct = p[i+1] - p[c] -1;
            if(i==data.length-1){
                if(ct<=k)
                mm.append(c+1).append(" ").append(i+1).append(" ");
                else{
                    mm.append(c+1).append(" ").append(i).append(" ");
                    mm.append(i+1).append(" ").append(i+1).append(" ");
                }
            }else{
                ct = p[i+1] - p[c] -1;
                //System.out.println(i+" "+ct+" "+c);
                if(ct>k){
                    mm.append(c+1).append(" ").append(i).append(" ");
                    c = i;
                }
               // if(ct==k){
               //     mm.append(c+1).append(" ").append(i+1).append(" ");
               //     c = i+1;
               // }
            }
        }

        return mm.toString().trim();
    }


    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            sb.append(solve(ints(getInt()),getInt())).append("\n");
        }
        writer.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        long start_time = System.currentTimeMillis();
        WordWrap object;
        if (local_system) object = new WordWrap(new FileInputStream("input"), System.out);
        else object = new WordWrap(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public WordWrap(InputStream in, OutputStream out) {
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
