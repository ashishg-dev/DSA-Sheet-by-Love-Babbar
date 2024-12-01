/* 

Given the head of a singly linked list, the task is to check if the linked list has a loop.
A loop means that the last node of the linked list is connected back to a node in the same list.
So if the next of the last node is null. then there is no loop.

Input: LinkedList: 1->3->4->1
Output: true

Input: LinkedList: 1->8->3->4
Output: false

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
