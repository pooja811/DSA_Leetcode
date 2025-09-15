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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            if(curr != null && curr.val==val){
                while(curr != null && curr.val==val){
                    curr= curr.next;
                }
                if(prev != null){
                    prev.next = curr;
                }else{
                    head = curr;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head; 
    }
}