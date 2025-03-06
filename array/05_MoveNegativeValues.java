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
        
        // This index keeps track of the position for the next non-negative number
        int j = 0;
        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {

            // If a negative number is found, swap it with the element at index j
            // j keeps the position of the last non-negative number encountered
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // Increment j to move to the next position for non-negative numbers
                j++; 
            }
        }
        
        // The array is now segregated with all negative elements at the end,
        // and non-negative elements at the front
        
    }
}
