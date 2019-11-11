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
        if(head == null){
            return null;
        }
        ListNode newList = new ListNode (head.val);
        while(head.next != null){ //bc i dont wanna copy the null value
            ListNode first = new ListNode (head.next.val); //new first 
            head =  head.next; //move the temp in original list
            first.next = newList; //insert this at the beginning. 
            newList = first; //fix the pointer to the beginning of the new list
        }
        return newList;
    }
}
