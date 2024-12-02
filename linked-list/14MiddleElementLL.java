/*
Given a singly linked list of 'N' nodes.
The objective is to determine the middle node of a singly linked list.
However, if the list has an even number of nodes, we return the second middle node.

Input: LinkedList: 3->5->2->4->1
Output: 2

Input: LinkedList: 9->15->0->10
Output: 0

*/

class Solution {

   static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
