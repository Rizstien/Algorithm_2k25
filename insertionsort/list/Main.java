package insertionsort.list;

public class Main {

    public static void main(String[] args) {
        var i = new Main();
        var head = new Node(9);
        head.next = new Node(13);
        head.next.next = new Node(4);
        head.next.next.next = new Node(-7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(0);

        System.out.println(i.sort(head));
    }

    public Node sort(Node head) {
        if(head == null || head.next == null) return head;

        Node dummy = new Node(Integer.MIN_VALUE);
        Node curr = head;

        while(curr != null){
            Node prev = dummy;
            while(prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }

            Node next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }

        return dummy.next;
    }
}


class Node {
    public int val;
    public Node next;

    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        Node ptr = this;
        var builder = new StringBuilder();
        while (ptr != null) {
            builder.append(ptr.val).append(" ");
            ptr = ptr.next;
        }
        builder.append("\n");
        return builder.toString();
    }
