/*
Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked lists is in sorted order.
Flatten the Link List so all the nodes appear in a single level while maintaining the sorted order.

Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
*/

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if (root == null || root.next == null) {
            return root;
        }
        Node result = root;
        Node curr = root.next;
        while(curr != null) {
            result = merge(result,curr);
            curr = curr.next;
        }
        return result;
        
    }
    
    Node merge(Node left, Node right) {
        
        if(left == null) return right;
        if(right == null) return left;
        
        Node res;
        if(left.data < right.data) {
            res = left;
            res.bottom = merge(left.bottom,right);
        }else {
            res = right;
            res.bottom = merge(left,right.bottom);
        }
        
        return res;
        
    }
}
