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

    private static ListNode getKthNode(ListNode temp, int k){
        k--;
        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private static ListNode reverseLL(ListNode head){
        ListNode prev = null, curr = head, front = head;
        while(curr != null){
            front = front.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevGroupLast = null;
        while(temp != null){
            ListNode kThNode = getKthNode(temp, k);
            if(kThNode == null){
                if(prevGroupLast != null) prevGroupLast.next = temp;
                break;
            }
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = kThNode;
            }else{
                prevGroupLast.next = kThNode;
            }
            prevGroupLast = temp;
            temp = nextNode;
        }
        return head;
    }
}