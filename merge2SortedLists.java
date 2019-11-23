/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //Splicing 2 sorted lists together. 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); //need this dummy head to build off of and not destroy any list
        ListNode head = dummy; 
        while(l1 != null && l2 !=null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next; 
            }else{
                dummy.next = l2;
                l2 = l2.next; 
            }
            dummy = dummy.next; 
        }
        ListNode rest = l1 != null ? l1 : l2;
        dummy.next = rest;
        return head.next;   
    }
}
