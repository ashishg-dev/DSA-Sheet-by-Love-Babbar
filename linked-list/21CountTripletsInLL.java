/*

Given a sorted linked list of distinct nodes (no two nodes have the same data) and an integer x.
Count distinct triplets in the list that sum up to a given integer x.
Note: The Linked List is sorted in descending order.

Input: LinkedList: 9->8->6->5->4->2->1,  x= 17
Output: 2
Explanation: Distinct triplets are (2, 6, 9) and (4, 5, 8) which have sum equal to x i.e 17.

Input: LinkedList: 9->8->6->5->4->2->1, x= 15
Output: 5
Explanation: (1, 5, 9), (1, 6, 8), (2, 4, 9), (2, 5, 8), (4, 5, 6) are the distinct triplets

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

*/

class Solution {
    static int countTriplets(Node head, int x) {
        // code here.
        int count = 0;
        if(head == null || head.next == null) return count;
        
        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        //Insert head node value
        mp.put(head.data, true);
        // first pointer 
        Node first = head.next;
        while(first.next != null) { 
            // second pointer
            Node second = first.next;
            while(second != null) {

                // find the number required
                // to make triplet by subtracting
                // first and second data from x
                // and store it.
                int a = x - first.data - second.data;
                // Search if that value
                // is present in the map or not
                if(mp.containsKey(a)) {
                    count++;
                }
                // Move second pointer node ahead
                second = second.next;
            }
            // Insert first pointer data into map
            mp.put(first.data,true);
          // Move first pointer node ahead
            first = first.next;
        }

        return count;
    }
}
