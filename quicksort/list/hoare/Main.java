package quicksort.list.hoare;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { this.val = x;}
}

public class Main {

    public static void main(String[] args) {
        // Test data
        ListNode head = new ListNode(12);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(15);

        Main instance = new Main();
        instance.sortList(head);
        instance.print(head);
    }

    // Entry function for QuickSort
    public ListNode sortList(ListNode head) {
        ListNode tail = getTail(head);
        quickSort(head, tail);
        return head;
    }

    // Get the last node in the list (tail)
    public ListNode getTail(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode start = head;
        while(start != null && start.next != null){
            start = start.next;
        }
        return start;
    }

    // Perform QuickSort with Hoare Partitioning scheme
    public void quickSort(ListNode start, ListNode end){
        if(start != null && start != end && end != null && start != end.next){
            ListNode pivot = partition(start, end);
            quickSort(start, pivot);        // Left side
            quickSort(pivot.next, end);     // Right side
        }
    }

    // Partition the list using Hoare's partitioning scheme
    public ListNode partition(ListNode start, ListNode end){
        int pivot = start.val;  // Choose the first element as pivot
        ListNode left = start;  // Left pointer starts at the beginning
        ListNode right = end;   // Right pointer starts at the end

        while(true){
            // Move left pointer to the right until it finds an element >= pivot
            while(left != right && left.val < pivot)
                left = left.next;

            // Move right pointer to the left until it finds an element <= pivot
            while(right != left && right.val > pivot)
                right = getPrev(start, right);

            // If pointers meet or cross, return the right pointer as the pivot
            if(left == right || left == end || right == start)
                return right;

            // Swap values of left and right
            int temp = left.val;
            left.val = right.val;
            right.val = temp;

            // Move the left pointer to the next node
            left = left.next;
            // Move the right pointer to the previous node
            right = getPrev(start, right);
        }
    }

    // Utility function to get the node before a target node (previous node)
    public ListNode getPrev(ListNode start, ListNode target){
        while(start != target && start.next != target){
            start = start.next;
        }
        return start;
    }

    // Helper function to print the sorted linked list
    public void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
