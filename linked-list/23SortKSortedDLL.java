/*

Given a doubly linked list, each node is at most k-indices away from its target position.
The problem is to sort the given doubly linked list.
The distance can be assumed in either of the directions (left and right).

Input: Doubly Linked List : 3 <-> 2 <-> 1 <-> 5 <-> 6 <-> 4 , k = 2
Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
Explanation: After sorting the given 2-sorted list is 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6.

Input: Doubly Linked List : 5 <-> 6 <-> 7 <-> 3 <-> 4 <-> 4 , k = 3
Output: 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7
Explanation: After sorting the given 3-sorted list is 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7.

Expected Time Complexity: O(nlogk)
Expected Auxiliary Space: O(k)

*/

class Compare implements java.util.Comparator<DLLNode> {
    public int compare(DLLNode a, DLLNode b) {
        return a.data - b.data;
    }
}

class Solution {
    
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        
        if (head == null) return null;

        // priority queue 'pq' implemented as min 
        // heap with the help of 'compare' function
        PriorityQueue<DLLNode> pq = new PriorityQueue<>(new Compare());

        // Create a Min Heap of first (k+1) elements
        for(int i=0; head != null && i<k+1; i++) {
            pq.add(head);
            head = head.next;
        }
        
        DLLNode newHead = null;
        DLLNode curr = null;
        
        while(!pq.isEmpty()) {
            if(newHead == null) {
                newHead = pq.poll(); // get the top element and remove it
                newHead.prev = null;
                curr = newHead;
            } else {
                DLLNode temp = pq.poll(); // get the top element and remove it
                curr.next = temp;
                temp.prev = curr;
                curr = temp;
            }
            // Add the node in priority queue if there are more nodes left
            if(head != null){
                pq.add(head);
                head = head.next;
            }
        }
        // making 'next' of last node point to NULL
        curr.next = null;
        return newHead;
    }
}
