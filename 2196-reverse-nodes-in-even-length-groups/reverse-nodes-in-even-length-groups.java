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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode tempTraverse = newHead;

        int k = 1;
        while (head != null) {
            int count = 0;
            ListNode temp = head;
            while (count < k && temp != null) {
                count++;
                temp = temp.next;
            }

            if (count % 2 == 0) {
                ListNode prev = null, curr = head, next;
                for (int i = 0; i < count; i++) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                tempTraverse.next = prev;   
                tempTraverse = head;       
                head = temp;                
            } else {
                tempTraverse.next = head;  
                for (int i = 0; i < count; i++) {
                    tempTraverse = head;    
                    head = head.next;
                }
            }
            k++;
        }
        return newHead.next;
    }
}