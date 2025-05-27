/*

Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List.
When a value appears in multiple nodes, the node which appeared first should be kept,
all other duplicates are to be removed.

Input: LinkedList: 5->2->2->4
Output: 5->2->4

Input: LinkedList: 2->2->2->2->2
Output: 2

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        Node curr = head;
        Node prev = null;
        HashSet<Integer> map = new HashSet<Integer>();
        while(curr != null) {
            if (map.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                map.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
