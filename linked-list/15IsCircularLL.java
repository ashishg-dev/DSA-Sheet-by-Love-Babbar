/*

Given the head, the head of a singly linked list, Returns true if the linked list is circular & false if it is not circular.
A linked list is called circular if it is not NULL terminated and all nodes are connected in the form of a cycle. 
Note: The linked list does not contain any inner loop.

Input: LinkedList: 3->5->2->4->1->(3) 
Output: true
Last Node is connected to head

Input: LinkedList: 12->9->3->1
Output: false

*/

class Solution {
    boolean isCircular(Node head) {
        
        if (head == null) return true;
        
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
