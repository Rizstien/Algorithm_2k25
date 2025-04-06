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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = mid(head);
        ListNode nextToMid = mid.next;
        mid.next = null; // make mid half

        var left = sortList(head);
        var right = sortList(nextToMid);

        return merge(left, right);
    }

    private ListNode merge(ListNode first, ListNode second) {
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) current.next = first;
        if (second != null) current.next = second;

        return dummy.next;
    }

    private ListNode mid(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}