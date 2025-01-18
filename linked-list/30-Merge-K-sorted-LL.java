/**

Given an array of sorted linked lists of different sizes.
The task is to merge them in such a way that after merging they will be a single sorted linked list.

Input: arr = [1->2->3, 4->5, 5->6, 7->8]
Output: 1->2->3->4->5->5->6->7->8
Explanation:
The test case has 4 sorted linked 
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be 1->2->3->4->5->5->6->7->8

Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(n)
Note: n is the maximum size of all the  LinkedList

**/

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        int i = 0;
        int last = arr.size()-1;
        int temp;
        while(last != 0) {
            i = 0;
            temp = last;
            while(i<temp) {
                arr.set(i,merge(arr.get(i),arr.get(temp)));
                i++;
                temp--;
                if(i>=temp){
                    last = temp;
                }
            }
        }
        return arr.get(0);
    }
    
    Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        
        Node res;
        if(left.data < right.data) {
            res = left;
            res.next = merge(left.next,right);
        } else {
            res = right;
            res.next = merge(left,right.next);
        }
        return res;
    }
}


