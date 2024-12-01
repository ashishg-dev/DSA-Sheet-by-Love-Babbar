/*
Given two singly linked lists, return the point where two linked lists intersect.
Note: If the linked lists do not merge at any point, return -1.

 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        // code here
        int counter1 = 0;
        int counter2 = 0;
        
        Node curr1 = head1;
        Node curr2 = head2;
        
        while(curr1 != null) {
            curr1 = curr1.next;
            ++counter1;
        }
        while(curr2 != null) {
            curr2 = curr2.next;
            ++counter2;
        }
    
        int diff = Math.abs(counter1 - counter2);
        
        curr1 = head1;
        curr2 = head2;
        
        if (counter1 > counter2){
            while(curr1 != null && diff != 0) {
                --diff;
                curr1 = curr1.next;
            }
        } else if (counter1 < counter2) {
            while(curr2 != null && diff != 0) {
                --diff;
                curr2 = curr2.next;
            }
        }
        
        while(curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
            if (curr1 == curr2) {
                return curr1.data;
            }
        }
        return -1;
    }
    
}
