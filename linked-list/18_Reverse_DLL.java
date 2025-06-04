/*
Given a doubly linked list. Your task is to reverse the doubly linked list and return its head.

Input: LinkedList: 3 <-> 4 <-> 5
Output: 5 <-> 4 <-> 3

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // reach to last node
        DLLNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        // update the head with last node        
        head = curr;
        // reverse
        while(curr != null) {
            DLLNode temp = curr.next; // will be null at the beginning 
            curr.next = curr.prev; 
            curr.prev = temp;
            curr = curr.next;
        }
        return head;
    }
}
