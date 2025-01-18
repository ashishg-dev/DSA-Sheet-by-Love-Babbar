/**

Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.

Note:

You don't have to print anything, just return the head of the modified list in each function.
Nodes may consist of Duplicate values.
The key may or may not be present.

Input: Linked List: 2->5->7->8->10, key = 8
Output: 10->7->5->2 
Explanation: After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10.
Now, reversing this list will result in 10, 7, 5, 2 & the resultant list is also circular.

Expected Time Complexity: O(n)
Expected Auxillary Space: O(1)

*/

class Solution {

    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        Node prev = null;
        Node temp;
        
        do {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } while (curr != head);
        
        // The last node points to the first node (i.e., the new head)
        head.next = prev;
        
        return prev;  // prev will now be the new head of the list
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null) return null; // If the list is empty, return null
        
        Node curr = head;
        Node prev = null;
        
        // If the list contains only one node and it's the one to be deleted
        if (curr.next == head && curr.data == key) {
            return null;  // Only one node in the list, delete it
        }

        // If the node to be deleted is the head node
        if (curr.data == key) {
            // Find the last node
            while (curr.next != head) {
                curr = curr.next;
            }
            // Now, curr is the last node
            curr.next = head.next;  // Last node's next points to the second node
            head = head.next;  // New head is the second node
            return head;
        }

        // Traverse the list to find the node to be deleted
        prev = head;
        curr = head.next;
        
        while (curr != head && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }
        
        // If the node is found, delete it
        if (curr.data == key) {
            prev.next = curr.next;  // Remove the node from the list
        }
        
        return head;
    }
}
