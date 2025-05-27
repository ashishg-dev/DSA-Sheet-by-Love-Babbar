/*
Given that two linked lists are sorted in increasing order,
create a new linked list representing the intersection of the two linked lists.
The new linked list should be made without changing the original lists.

Input: LinkedList1 = 1->2->3->4->6, LinkedList2 = 2->4->6->8
Output: 2->4->6

Input: LinkedList1 = 10->20->40->50, LinkedList2 = 15->40
Output: 40

Expected Time Complexity: O(n+m)
Expected Space Complexity: O(n+m)

 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        
        Node curr1 = head1;
        Node curr2 = head2;
        Node res = null;
        Node temp = null;
        while(curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data){
                curr1 = curr1.next;
            } else if (curr2.data < curr1.data) {
                curr2 = curr2.next;
            } else {
                Node node = new Node(curr1.data);
                if (res == null) {
                    res = node;
                    temp = res;
                } else {
                    temp.next = node;
                    temp = node;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
        return res;
    }
}
