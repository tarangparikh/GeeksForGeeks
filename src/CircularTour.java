import java.io.*;
import java.util.Arrays;

public class CircularTour {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    int solve(int[] petrol,int[] distance){
        int n = petrol.length;
        int[] prefix = new int[(n<<1)];
        for(int i = 0;i<n;i++){
            prefix[i] = petrol[i] - distance[i];
            prefix[i+n] = prefix[i];
        }
        int sum = 0;
        int index = -1;
        int len = 0;
        for(int i = 0,h=prefix.length;i<h;i++){
            if(index > n-1){
                index = -1;
                break;
            }
            if(index == -1){
                if(sum + prefix[i] > 0){
                    index = i;
                    sum+=prefix[i];
                    len+=1;
                }
            }else{
                if(len==n) break;
                sum+=prefix[i];
                if(sum < 0){
                    index = -1;
                    sum = 0;
                }
            }
        }

        return index;
    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int n = getInt();
            int[] data = ints(n<<1);
            int[] petrol = new int[n];
            int[] distance = new int[n];
            for(int i = 0;i<n;i++){
                petrol[i] = data[i*2];
                distance[i] = data[i*2 + 1];
            }
            System.out.println(Arrays.toString(petrol)+"\n"+ Arrays.toString(distance));
            sb.append(solve(petrol,distance)).append("\n");
        }
        writer.println(sb.toString());
    }

    public static void main(String... args) throws IOException {
        long start_time = System.currentTimeMillis();
        CircularTour object;
        if (local_system)
            object = new CircularTour(Thread.currentThread().getContextClassLoader().getResourceAsStream("input"), System.out);
        else object = new CircularTour(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public CircularTour(InputStream in, OutputStream out) {
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
