/*

Given a sorted linked list of positive distinct elements,
the task is to find pairs in a linked list whose sum is equal to given value x.

Input : head : 1 -> 2 -> 4 -> 5 -> 6 -> 8 -> 9
        x = 7
Output: (6, 1), (5,2)

*/

class Solution {
  static void findPair(Node head, int x) {
    Node curr = head;
    HashSet<Integer> seen = new HashSet<Integer>();
     
    while(curr != null) {
      int result = x - curr.data;
      if(seen.contains(result)) {
        System.out.println("("+result+","+curr.data+")");
      }
      seen.add(curr.data);
      curr = curr.next;
    }     
  }
}
