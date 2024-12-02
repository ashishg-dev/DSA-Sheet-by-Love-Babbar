/*
Given a Circular linked list.The task is split into two Circular Linked lists. 
If there are an odd number of nodes in the given circular linked list then out of the resulting two halved lists,
the first list should have one node more than the second list.

Input: LinkedList : 10->4->9->10
Output: 10->4 , 9->10
Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain 9, 10.

*/

class Solution {
    public Pair<Node,Node> splitList(Node head) {
        // Code here
        
        Node slow = head;
        Node fast = head.next;
        while(fast != head && fast.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        Node first = head;
        Node second = slow.next;
        slow.next = head;
        
        Node curr = second;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = second;

        return new Pair(first,second);
        
    }
}
