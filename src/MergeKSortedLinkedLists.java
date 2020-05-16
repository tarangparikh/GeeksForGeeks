import java.util.Arrays;

class List{
    private class Node{
        Integer data;
        Node next;
        Node(){
            this.data = null;
            this.next = null;
        }

    }
    private Node last;
    private Node head;
    List(){
        this.head = new Node();
        this.last = this.head;
    }
    boolean isEmpty(){
        return this.head.data == null;
    }
    void add(int data){
        if (this.last.data != null) {
            this.last.next = new Node();
            this.last = this.last.next;
        }
        this.last.data = data;
    }
    public static List merge(List[] data){
        return merge(data,0,data.length-1);
    }
    public static List merge(List[] data,int start,int end){
        if(start == end) return data[start];
        int mid = (start + end) / 2;
        List p1 = merge(data,start,mid);
        List p2 = merge(data,mid+1,end);
        return merge(p1,p2);
    }
    public static List merge(List aa,List bb){
        Node a = aa.head;
        Node b = bb.head;
        Node temp = null;
        Node head = null;
        while (a!=null&&b!=null&&a.data!=null&&b.data!=null){
            if(a.data<=b.data){
                if(temp == null){
                    temp = a;
                    head = temp;
                }else {
                    temp.next = a;
                    temp = temp.next;
                }

                a = a.next;
            }else{
                if(temp == null){
                    temp = b;
                    head = temp;
                }else {
                    temp.next = b;
                    temp = temp.next;
                }
                b = b.next;
            }
        }
        while (a!=null&&a.data!=null){
            if(temp == null){
                temp = a;
                head = temp;
            }else {
                temp.next = b;
                temp = temp.next;
            }
            a = a.next;
        }
        while (b!=null&&b.data!=null){
            if(temp == null){
                temp = b;
                head = temp;
            }else {
                temp.next = b;
                temp = temp.next;
            }
            b = b.next;
        }
        if(head == null){
            head = a;
        }
        List send = new List();
        send.head = head;
        return send;
    }

    public void addAll(int[] data){
        Arrays.stream(data).forEach(this::add);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = this.head;
        while (temp!=null&&temp.data!=null&&temp.next!=null){
            sb.append(temp.data);
            sb.append(" ");
            temp = temp.next;
        }
        if(temp.next==null){
            sb.append(temp.data);
        }
        sb.append("]");
        return sb.toString();
    }
}

public class MergeKSortedLinkedLists {
    public static void run(){
        List[] lists = new List[4];
        for(int i = 0,h=lists.length;i<h;i++){
            lists[i] = new List();
        }
        lists[0].addAll(new int[]{1,2,3});
        lists[1].addAll(new int[]{4,5});
        lists[2].addAll(new int[]{5,6});
        lists[3].addAll(new int[]{6,7});

        System.out.println(List.merge(lists));
    }

}
