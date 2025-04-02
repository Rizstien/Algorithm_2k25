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
        if(head == null || head.next == null) return head;

        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);

        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1); // Dummy node for result list
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Attach the remaining elements (only one of these will execute)
        if (left != null) tail.next = left;
        if (right != null) tail.next = right;

        return dummy.next; // Return merged list (excluding dummy head)
    }

    ListNode getMiddle(ListNode head){
        if(head == null) return head;

        ListNode slow = head, fast = head;
        if(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}