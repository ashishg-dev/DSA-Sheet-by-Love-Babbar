/*

Given a singly linked list. The task is to remove duplicates (nodes with duplicate values) from the given list (if it exists).

Input:
LinkedList: 2->2->4->5
Output: 2 -> 4 -> 5

Input:
LinkedList: 2->2->2->2->2
Output: 2

Expected Time Complexity : O(n)
Expected Space Complexity: O(1)

class Node    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        
        Node prev = head;
        Node curr = head.next;
        while(curr != null) {
            if (curr.data == prev.data) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
