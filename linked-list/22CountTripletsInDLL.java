/*
Count triplets in a sorted doubly linked list whose sum is equal to a given value x

Sample Input 1:
3
1<->2<->3<->8<->9
output: 2
We can clearly see that 2 triplets exist for this case, i.e., (2,3,8) and (1,3,9)

Sample Input 2:
13
1<->2<->3<->4<->5<->6<->7<->8<->9
output: 8
For this case we can see that there are total of eight triplets i.e. (2,4,9),(4,5,6),(2,6,7),(3,4,8),(1,5,9),(1,6,8),(2,5,8)and (3,5,7)
*/

public class Solution {
    public static int countTriplets(DLLNode head,int x) {
        
        int count = 0;
        DLLNode curr = head;
        DLLNode lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        while(curr.next != null) {
            DLLNode first = curr.next;
            DLLNode last = lastNode;
            while (first != null && last != null && first != last && last.next != first) {
                int result = curr.data + first.data + last.data;
                if(result == x) {
                    count++;
                    first = first.next;
                    last = last.prev;
                } else {
                    if(result < x) {
                        first = first.next;
                    } else {
                        last = last.prev;
                    }
                }

            }
            curr = curr.next;
        }
        return count;
    }
}

