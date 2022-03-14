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
    public void reorderList(ListNode head) {
        ListNode originalHead = head;
        ListNode reverseHead = new ListNode(head.val);
        
        // Reverse the LinkedList
        ListNode prev = null; 
        int size = 1;
        while(head.next != null){
            ListNode temp = new ListNode(head.next.val);
            reverseHead.next = prev;
            prev = reverseHead;
            reverseHead = temp;
            head = head.next;
            size++;
        }
        reverseHead.next = prev;
        
        
        ListNode iterator = new ListNode();
        ListNode pointer = new ListNode();
        pointer = iterator;
        
        boolean forward = true;
        int newSize = 0;
        while(newSize < size){
            iterator.next = forward ? originalHead : reverseHead;
            originalHead = forward ? originalHead.next : originalHead;
            reverseHead = forward ? reverseHead : reverseHead.next;
            forward = !forward;
            iterator = iterator.next;
            newSize++;
        }
        iterator.next = null;
        head = pointer.next;
    }
}