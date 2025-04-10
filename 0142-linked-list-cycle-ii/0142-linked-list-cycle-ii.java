/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode hasCycle = hasCycle(head);

        if(hasCycle != null){
            ListNode ptr1 = head;
            ListNode ptr2 = hasCycle;

            while(ptr1 != ptr2){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }else{
            return null;
        }

    }

    public ListNode hasCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head; // 3 2 0 -4 2
        ListNode fast = head; // 3 2 0 -4 2

        while(fast != null && fast.next != null){
            slow = slow.next; // -4 2 0 -4
            fast = fast.next.next; // -4 2 0 -4
            if(slow == fast) return fast;
        }
        return null;
    }
}