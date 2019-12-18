/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNewL = new ListNode(-1); //dummy
        ListNode res = headNewL;
        int carry = 0; 
        while(l1 != null || l2 != null || carry>0){
            int l1Val = l1!=null ? l1.val : 0;
            int l2Val = l2!=null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum/10;
            res.next = new ListNode(sum%10);
            res = res.next;
            l1 = l1!= null ? l1.next : null;
            l2 = l2!= null ? l2.next : null;
        }
        return headNewL.next; 
    }
}
