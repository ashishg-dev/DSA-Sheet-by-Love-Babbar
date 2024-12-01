/*

Given the head of a linked list that may contain a loop.  
A loop means that the last node of the linked list is connected back to a node in the same list.
So if the next of the previous node is null. then there is no loop.
Remove the loop from the linked list, if it is present (we mainly need to make the next of the last node null). Otherwise, keep the linked list as it is.

Input: Linked list: 1->3->4->1
Output: 1->3->4

Input: Linked list: 1->8->3->4
No changes in Output: 1->8->3->4

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

class Node {
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == head && fast == head) {
            while (slow != fast.next) {
                fast = fast.next;
            }
            fast.next = null;
        } else if (slow == fast) {
            slow = head;
            while(slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }

    }
}
