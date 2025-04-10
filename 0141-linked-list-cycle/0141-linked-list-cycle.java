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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head; // 3 2 0 -4
        ListNode fast = head; // 3 2 0 -4

        while(fast != null && fast.next != null){
            slow = slow.next; // 0 -4
            fast = fast.next.next; // null
            if(slow == fast) return true;
        }
        return false;
    }
}