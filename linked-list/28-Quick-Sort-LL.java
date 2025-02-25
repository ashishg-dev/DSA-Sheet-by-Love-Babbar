/**
You are given a Linked List. Sort the given Linked List using quicksort. 

Input: Linked list: 1->6->2
Output: 1->2->6

**/

class GfG {
    public static Node quickSort(Node node) {
        
        if (node == null || node.next == null) {
            return node;
        }
         // Find the tail of the list
        Node tail = getTail(node);
        quickSortHelper(node, tail);
        return node;
    }
    
    // Helper function to find the last node (tail) of the linked list
    private static Node getTail(Node node) {
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }
    
    // Recursive function to apply quicksort on the linked list
    private static void quickSortHelper(Node head,Node tail) {
        if(head == tail || head == null || tail == null){
            return;
        }
        
        Node pivot = partition(head,tail);
        quickSortHelper(head,pivot);
        quickSortHelper(pivot.next,tail);
    }
    
    // Partition the list around a pivot element and return the pivot node
    private static Node partition(Node head,Node tail) {
        // Initialize pointers for traversing the list
        Node curr = head.next; // Start from the second element (next to pivot)
        Node prev = head;      // The pivot is initially the head node
        Node pivot = head;     // The pivot is the first element of the partition
        
        while(curr != tail.next) {
            if(curr.data < pivot.data) {
                // Swap data between prev and curr nodes
                int temp = curr.data;
                curr.data = prev.next.data;
                prev.next.data = temp;
                // Move prev pointer forward
                prev = prev.next;
            }
            // Move the current pointer forward
            curr = curr.next;
        }
        // After traversal, swap the pivot element with the element at the 'prev' position
        int temp = pivot.data;
        pivot.data = prev.data;
        prev.data = temp;
        return prev;
    }
    
}

