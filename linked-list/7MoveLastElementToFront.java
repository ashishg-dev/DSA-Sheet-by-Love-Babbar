/*
You are given the head of a Linked List.
You have to move the last element to the front of the Linked List and return the head the modified linked list.

Input: Linked List: 2->5->6->2->1
Output: 1->2->5->6->2

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

class Node {
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

*/

class Solution {
    public static Node moveToFront(Node head) {        
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}
