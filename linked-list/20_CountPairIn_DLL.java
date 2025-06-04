/*

Given a sorted doubly linked list of positive distinct elements,
the task is to find pairs in a doubly-linked list whose sum is equal to given value x.

Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
        x = 7
Output: (6, 1), (5,2)

*/

class Solution {
  static void findPair(Node head, int x) {
    Node curr = head;
    while(curr.next != null){
        curr = curr.next;
    }
     
    while(head != curr) { 
       if ((head.data + curr.data) == x) {
         System.out.println("("+head.data+","+curr.data+")");
         head = head.next;
         curr = curr.prev;
       } else {
         if((head.data + curr.data) < x){
           head = head.next;
         } else {
           curr = curr.prev;
         }
       }
     }     
  }
}
