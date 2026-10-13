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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;

        while (true) {
            // Check if there are at least k nodes remaining
            ListNode kthNode = getKthNode(prevGroupTail, k);
            if (kthNode == null) break;

            ListNode nextGroupHead = kthNode.next;
            ListNode groupHead = prevGroupTail.next;

            // Reverse current k-group
            ListNode prev = nextGroupHead;
            ListNode curr = groupHead;
            while (curr != nextGroupHead) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group tail to the new head of reversed group
            prevGroupTail.next = kthNode;
            // Move pointer to the end of the newly reversed group
            prevGroupTail = groupHead;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}