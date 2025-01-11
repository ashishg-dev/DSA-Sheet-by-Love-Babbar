// Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place.
// The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL.
// The order of nodes in DLL must be the same as the order of the given Binary Tree.
// The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

// Note: h is the tree's height, and this space is used implicitly for the recursion stack.



//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    Node prev = null; // Keeps track of the previous node during in-order traversal
    Node head = null; // Keeps track of the head (first node) of the doubly linked list
    
    Node bToDLL(Node root) {
        // If the current root is null, return null (base case of recursion)
        if (root == null) return null;
    
        // Recursively convert the left subtree to a doubly linked list
        bToDLL(root.left);
    
        // If 'prev' is null, it means we are processing the first node
        if (prev == null) {
            head = root;  // Set the head of the doubly linked list to this node
        } else {
            // Link the previous node's right pointer to the current node
            prev.right = root;
            // Link the current node's left pointer to the previous node
            root.left = prev;
        }
    
        // Set the previous node to the current root (important for the next iteration)
        prev = root;
    
        // Recursively convert the right subtree to a doubly linked list
        bToDLL(root.right);
    
        // Return the head of the doubly linked list
        return head;
    }
}
