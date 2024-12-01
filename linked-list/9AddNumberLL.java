/*

Given two numbers, num1, and num2, represented by linked lists.
The task is to return the head of the linked list representing the sum of these two numbers.

Input: num1 = 45 (4->5->null), num2 = 345 (3->4->5->null)
Output:  3->9->0->null 

Expected Time Complexity: O(n+m)
Expected Space Complexity: O(max(n,m)) for the resultant list.

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
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node pointer1 = reverse(num1);
        Node pointer2 = reverse(num2);
        Node res = null;
        Node curr = null;
        int c = 0;
        while(pointer1 != null || pointer2 != null) {
            
            int a = (pointer1 != null) ? pointer1.data : 0;
            int b = (pointer2 != null) ? pointer2.data : 0;
            int sum = c + (a + b);
            c = (sum > 9) ? (sum / 10) : 0;
            sum = sum % 10;
            Node newNode = new Node(sum);
            if (res == null) {
                res = newNode;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
            if (pointer1 != null){
                pointer1 = pointer1.next;                
            }
            
            if (pointer2 != null){
                pointer2 = pointer2.next;
            }
            
        }
        
        if(c > 0) {
            Node newNode = new Node(c);
            curr.next = newNode;
            curr = newNode;
        }
        
        // return head of sum list
        return reverse(res);
    }
    
    static Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
