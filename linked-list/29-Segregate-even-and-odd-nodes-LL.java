/**
Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be the same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.

Input: Linked list: 17->15->8->9->2->4->6
Output: 8->2->4->6->17->15->9

**/

class Solution {
    Node divide(Node head) {
        // code here
        
        Node even = null;
        Node odd = null;
        Node evenCurr = null;
        Node oddCurr = null;
        
        while(head != null) {
            if (head.data % 2 == 0) {
                if(even == null) {
                    even = head;
                    evenCurr = head;
                } else {
                    evenCurr.next = head;
                    evenCurr = evenCurr.next;
                }
            } else {
                if(odd == null) {
                    odd = head;
                    oddCurr = head;
                } else {
                    oddCurr.next = head;
                    oddCurr = oddCurr.next;
                }
            }
            
            head = head.next;
            
        }
        
        
        if(even != null) {
            evenCurr.next = odd;
        }
        
        if(odd != null) {
            oddCurr.next = null;
        }
        
        if(even != null) {
            return even;
        }
        
        return odd;
    }
}
