/*

Given a pointer/reference to the head of the linked list, the task is to sort the given linked list using Merge Sort.
Note: If the length of the linked list is odd, then the extra node should go into the first list while splitting

Input: LinkedList: 3->5->2->4->1
Output: 1->2->3->4->5

Input: LinkedList: 9->15->0
Output: 0->9->15

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        // add your code here
        
        if (head == null || head.next == null) return head;
        
        Node middle = getMiddle(head);
        Node middleNext = middle.next;
        middle.next = null;
        
        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);
        
        return merge(left,right);
        
    }
    
    static Node getMiddle(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    static Node merge(Node node1, Node node2){
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        Node res;
        if (node1.data <= node2.data) {
            res = node1;
            res.next = merge(node1.next,node2);
        } else {
            res = node2;
            res.next = merge(node1,node2.next);
        }
        return res;
    }
}
