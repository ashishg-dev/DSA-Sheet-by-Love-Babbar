/*
Given the head of a linked list, the task is to reverse this list and return the reversed head.

Input: Linked list: 1->2->3->4->5->6
Output: 6->5->4->3->2->1
*/

class ReverseALinkedList {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        // code here
        
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
        
    }
}
