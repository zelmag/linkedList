/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       //so need a prev, curr, and next pointer
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            //store next
            next = curr.next;
            //change curr's next to prev
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return prev; 
    }
}
