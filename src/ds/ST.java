package ds;

public class ST {
    private int[] t;
    public ST(int size){
        this.t = new int[size<<1];
    }
    public void add(int i,int value){
        i += t.length / 2;
        t[i] += value;
        for (; i > 1; i >>= 1)
            t[i >> 1] = Math.min(t[i], t[i ^ 1]);
    }
    public int get(int i) {
        return t[i + t.length / 2];
    }
    public int min(int a, int b) {
        int res = Integer.MIN_VALUE;
        for (a += t.length / 2, b += t.length / 2; a <= b; a = (a + 1) >> 1, b = (b - 1) >> 1) {
            if ((a & 1) != 0)
                res = Math.min(res, t[a]);
            if ((b & 1) == 0)
                res = Math.min(res, t[b]);
        }
        return res;
    }
}
