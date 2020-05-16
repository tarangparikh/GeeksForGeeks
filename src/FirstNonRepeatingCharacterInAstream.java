import java.io.*;
import java.util.Arrays;

public class FirstNonRepeatingCharacterInAstream {
    BufferedReader bf;
    PrintWriter writer;
    StringBuilder sb;
    static boolean local_system = true;
    String solve(int[] data){
        int[][] hash = new int[26][2];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0,h=26;i<h;i++){
            hash[i][0] = -1;
        }
        for(int i = 0,h=data.length;i<h;i++){
            if(hash[data[i] - 'a'][0] == -1){
                hash[data[i] - 'a'][0] = i;
            }
            hash[data[i] - 'a'][1]++;

            writer.println(Arrays.deepToString(hash));

            int index = find(hash);

            if(index == -1){
                stringBuilder.append(index).append(" ");
            }else{
                stringBuilder.append(getChar(index)).append(" ");
            }
        }
        return stringBuilder.toString();
    }
    char getChar(int value){
        return (char)(value + 97);
    }
    int find(int[][] hash){
        boolean found = false;
        int time = -1;
        int index = -1;
        for(int i = 0,h=26;i<h;i++){
            if(hash[i][0] != -1 && hash[i][1] == 1){
                if(!found){
                    found = true;
                    time = hash[i][0];
                    index = i;
                }else{
                    if(time > hash[i][0]){
                        index = i;
                        time = hash[i][0];
                    }
                }
            }
        }
        return index;
    }
    void run() throws IOException {
        int t = getInt();
        while (t-->0){
            int[] data = chars(getInt());
            sb.append(solve(data)).append("\n");
        }
        writer.println(sb.toString());
    }

    public static void main(String... args) throws IOException {
        long start_time = System.currentTimeMillis();
        FirstNonRepeatingCharacterInAstream object;
        if (local_system)
            object = new FirstNonRepeatingCharacterInAstream(Thread.currentThread().getContextClassLoader().getResourceAsStream("input"), System.out);
        else object = new FirstNonRepeatingCharacterInAstream(System.in, System.out);
        object.run();
        long end_time = System.currentTimeMillis();
        if (local_system) object.writer.println("Time : " + (end_time - start_time));
        object.close();
    }

    public FirstNonRepeatingCharacterInAstream(InputStream in, OutputStream out) {
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

    public int[] chars(int size) throws IOException {
        String[] data = bf.readLine().split(" ");
        int[] send = new int[data.length];
        for (int i = 0, h = data.length; i < h; i++) send[i] = (int)(data[i].charAt(0));
        return send;
    }
}
