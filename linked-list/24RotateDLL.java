/*
Given a doubly linked list, rotate the linked list counter-clockwise by P nodes.
Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.

Input: Doubly Linkedlist: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 ,p = 2
Output: 3 <-> 4 <-> 5 <-> 6 <-> 1 <-> 2
Explanation: Doubly linked list after rotating
2 nodes is: 3 4 5 6 1 2.

Input: Doubly Linkedlist: 3 <-> 4 <-> 5 <-> 1 ,p = 3
Output: 1 <-> 3 <-> 4 <-> 5

*/

class Solution {
    public Node rotateDLL(Node head, int p) {
        Node tail = head;
        // Find the last node
        while (tail.next != null) {
            tail = tail.next;
        }

        // Make the list circular
        tail.next = head;
        head.prev = tail;

        // Move head and tail by the given position
        for (int count = 1; count <= p; count++) {
            head = head.next;
            tail = tail.next;
        }

        // Break the circular connection
        tail.next = null;
        head.prev = null;

        return head;
        
    }
}
