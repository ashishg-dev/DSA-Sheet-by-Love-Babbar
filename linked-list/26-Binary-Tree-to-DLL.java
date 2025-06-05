// Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place.
// The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL.
// The order of nodes in DLL must be the same as the order of the given Binary Tree.
// The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

// Note: h is the tree's height, and this space is used implicitly for the recursion stack.

/*
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

// Inorder Traversal (Left -> Root -> Right)
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

//https://www.youtube.com/watch?v=nGNoTdav5bQ

// ---------------------------------------------------------------------------------------------------------------------------------------

// Bonus

// Preorder Traversal (Root -> Left -> Right)
class SolutionPreOrder
{
    Node prev = null; // Keeps track of the previous node 
    Node head = null; // Keeps track of the head (first node) of the doubly linked list
    
    Node bToDLL(Node root) {
        // If the current root is null, return null (base case of recursion)
        if (root == null) return null;

	Node left = root.left;
	Node right = root.right;
    
        // If 'head' is null, it means we are processing the first node
        if (head == null) {
            head = root;  // Set the head of the doubly linked list to this node
        } else {
            // Link the previous node's right pointer to the current node
            prev.right = root;
            // Link the current node's left pointer to the previous node
            root.left = prev;
        }
    
        // Set the previous node to the current root (important for the next iteration)
        prev = root;

        // Recursively convert the left subtree to a doubly linked list
        bToDLL(left);	    
        // Recursively convert the right subtree to a doubly linked list
        bToDLL(right);
    
        // Return the head of the doubly linked list
        return head;
    }
}

// Postorder Traversal (Left -> Right -> Root)
class SolutionPostOrder
{
    Node head = null; // Keeps track of the head (first node) of the doubly linked list
    
    Node bToDLL(Node root) {
        // If the current root is null, return null (base case of recursion)
        if (root == null) return null;

        // Recursively convert the left subtree to a doubly linked list
        bToDLL(root.left);	    
        // Recursively convert the right subtree to a doubly linked list
        bToDLL(root.right);

	// Link the current node's right pointer to the head node
	root.right = head;
        if (head != null) {
	    // Link the head node's left pointer to the current node	
            head.left = root; 
        }
	
        // Set the current (root) node as the head node
        head = root;
	    
        // Return the head of the doubly linked list
        return head;
    }
}
