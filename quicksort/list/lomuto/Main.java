package quicksort.list.lomuto;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(15);

        Main instance = new Main();
        instance.sortList(head);
        instance.print(head);
    }

    public ListNode sortList(ListNode head) {
        ListNode tail = getTail(head);
        quickSort(head, tail);
        return head;
    }

    public ListNode getTail(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode start = head;
        while(start != null && start.next != null){
            start = start.next;
        }
        return start;
    }

    public void quickSort(ListNode start, ListNode end){
        if(start != null && start != end && start != end.next ){
            ListNode pivot = partition(start, end);
            quickSort(start, getPrev(start, pivot));
            quickSort(pivot.next, end);
        }
    }

    public ListNode partition(ListNode start, ListNode end){
        int pivot = end.val;
        ListNode pIndex = start;
        ListNode curr = start;

        while(curr != end){
            if(curr.val <= pivot){
                int temp = curr.val;
                curr.val = pIndex.val;
                pIndex.val = temp;

                pIndex = pIndex.next;
            }
            curr = curr.next;
        }

        int temp = pIndex.val;
        pIndex.val = end.val;
        end.val = temp;

        return pIndex;
    }

    public ListNode getPrev(ListNode start, ListNode target){
        while(start != target && start.next != target){
            start = start.next;
        }
        return start;
    }

    public void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
