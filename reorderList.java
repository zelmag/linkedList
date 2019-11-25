/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // 0, n-0, 1, n-1, 2, n-2, 3, n-3
        
        // 1. split list in half
        ListNode headFirst = head;
        
        ListNode tailFirst = null; //tail first; prev
        ListNode headSec = head; //slow pointer. head second list
        ListNode fast = head; //tail of second
        
        while(fast != null && fast.next != null){
            tailFirst = headSec;
            headSec = headSec.next;
            fast = fast.next.next;
        }
        
        tailFirst.next = null; //split off the first list
        
        //2. reverse second list.
        headSec = reverse(headSec);
        
        //3. 
        merge(headFirst,headSec);
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head; 
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next; 
        }
        return prev; 
    }
    //this part is the most confusing. we are merging linked lists in place
    public void merge(ListNode l1, ListNode l2){
        /*
         L1 1 -> 2 -> 3
         L2 4 -> 5 -> 6
         
        */
        //2 connections per iteration 
        while(l1 != null){
            ListNode l1Next = l1.next; //save the rest of the list
            ListNode l2Next = l2.next;
            l1.next = l2; //point from l1 to l2
            
            if(l1Next == null){ //done with the merging
                break;
            }
            l2.next = l1Next; //point the node from l2 you just added back to l1
            l1 = l1Next; //this is now back to the og l1 list
            l2 = l2Next; //back to the og l2 list
        }
    }
}
