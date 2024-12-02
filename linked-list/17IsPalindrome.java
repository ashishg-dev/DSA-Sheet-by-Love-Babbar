/*

Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

Input: LinkedList: 1->2->1->1->2->1
Output: true

Input: LinkedList: 1->2->3->4
Output: false

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1) 

*/

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // traverse till middle
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the 2nd half of LL
        Node prev = null;
        Node curr = slow;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // compare the value
        while(prev != null){
            if(prev.data != head.data){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
        
    }
}
