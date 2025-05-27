/*

You are given a linked list where each element in the list is a node and have an integer data.
You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list.

Input: LinkedList: 4->5->6
Output: 4->5->7

Input: LinkedList: 9->9
Output: 1->0->0

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)


class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        Node head1 = reverse(head); 
        Node curr = head1;
        Node prev = null;
        
        while(curr != null && curr.data == 9) {
            curr.data = 0;
            prev = curr;
            curr = curr.next;
        }
        
        if (curr == null) {
            prev.next = new Node(1);
        } else {
            curr.data += 1;
        }
        
        return reverse(head1);
    }
    
    Node reverse(Node head) {
        
        Node prev = null;
        Node curr = head;
        
        while(curr!=null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
        
    }
}

