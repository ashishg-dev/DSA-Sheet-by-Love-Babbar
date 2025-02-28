/**

Given an unsorted array arr[ ] having both negative and positive integers.
The task is to place all negative elements at one side of the array
Note: Don't return any array, just in-place on the array.

Examples:
Input : arr[] = [1, -1, 3, 2, -7, -5, 11, 6 ]
Output : [1, 3, 2, 11, 6, -1, -7, -5]
Explanation: By doing operations we separated the integers without changing the order.

**/

class MoveNegativeValues {
    public void segregateElements(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            // If negative number is present
            // swap it with arr[j]
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return arr;
        
    }
}
