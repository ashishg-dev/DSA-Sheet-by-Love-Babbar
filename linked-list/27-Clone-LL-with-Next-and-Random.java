/**

You are given a special linked list where each node has a next pointer pointing to its next node. 
You are also given some random pointers, where you will be given some pairs denoting two nodes a and b i.e. a->random = b (random is a pointer to a random node).

Construct a copy of the given list. The copy should consist of the same number of new nodes,
where each new node has its value set to the value of its corresponding original node. 
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the original and copied list pointers represent the same list state. 
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes x and y in the original list, where x->random = y,
then for the corresponding two nodes xnew and ynew in the copied list, xnew->random = ynew.

Return the head of the copied linked list.

NOTE : 
1. If there is any node whose arbitrary pointer is not given then it's by default NULL. 
2. Don't make any changes to the original linked list.

*//

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // Traverse the original list and insert copied nodes after the corresponding original nodes
        Node curr = head;
        while(curr != null) {
            Node copyNode = new Node(curr.data);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
      
        // Set the random pointer of the copied nodes.
        curr = head;
        while(curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            curr = curr.next.next;
        }
      
        // Separate the original list and the copied list.
      
        Node original = head;
        Node copyHead = head.next;
        curr = copyHead;
        while(original != null && curr != null) {
            original.next = curr.next;
            curr.next = (curr.next != null) ? curr.next.next : curr.next;
            original = original.next;
            curr = curr.next;
        }
        
        return copyHead;
    }
}
