/*
Given a linked list, the task is to reverse every k node (where k is an input to the function) in the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed

Input: Linked List: 1->2->2->4->5->6->7->8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5 

Input: LinkedList: 1->2->3->4->5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

class Node{
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverse(Node node, int k) {
        
        Node next = null;
        Node prev = null;
        Node curr = node;
        int counter = 0;
        
        while(curr != null && counter != k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            ++counter;
        }
        
        if (next != null){
            node.next = reverse(next,k);
        }
        
        return prev;
        
    }
}
