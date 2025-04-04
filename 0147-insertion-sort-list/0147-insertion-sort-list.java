/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

 if (head == null || head.next == null) return head;

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;

    ListNode lastSorted = head;     // Points to the last sorted node
    ListNode curr = head.next;      // The node to be inserted

    while (curr != null) {
        if (curr.val >= lastSorted.val) {
            // Current node is already in correct order
            lastSorted = curr;
        } else {
            // Need to find the insertion point from the beginning
            ListNode prev = dummy;
            while (prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            lastSorted.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
        }

        curr = lastSorted.next;
    }

    return dummy.next;
        
    }
}