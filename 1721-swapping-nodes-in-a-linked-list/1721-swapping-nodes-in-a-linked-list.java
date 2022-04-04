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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode handler = head;
        ListNode result = new ListNode();
        ListNode left = null;
        result.next = head;
        int leftVal = -1;
        int rightVal = -2;
        
        int size = 0;
        while(handler != null){
            size++;
            if(size == k){
                leftVal = handler.val;
                left = handler;
            }
            handler = handler.next;
        }
        
        handler = head;
        int index = 1;
        
        while(handler != null){
            if(index == size - k + 1){
                left.val = handler.val;
                handler.val = leftVal;
            }
            index++;
            handler = handler.next;
        }

        return result.next;
    }
}