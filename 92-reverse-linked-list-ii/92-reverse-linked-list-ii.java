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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode handler = new ListNode(0); // created dummy node
        handler.next = head;
        ListNode prev = handler;
        for(int i = 0; i < left - 1; i++)
            prev = prev.next; 
        ListNode curr = prev.next;
        
        for(int i = 0; i < right - left; i++){
            ListNode forward = curr.next; // forw pointer will be after curr
            curr.next = forward.next;
            forward.next = prev.next;
            prev.next = forward;
        }
        return handler.next;
    }
}