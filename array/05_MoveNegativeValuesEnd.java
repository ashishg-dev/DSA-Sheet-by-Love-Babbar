/**

Given an unsorted array arr[ ] having both negative and positive integers.
The task is to place all negative elements at the end of the array without changing the order of positive elements and negative elements.
Note: Don't return any array, just in-place on the array.

Examples:
Input : arr[] = [1, -1, 3, 2, -7, -5, 11, 6 ]
Output : [1, 3, 2, 11, 6, -1, -7, -5]
Explanation: By doing operations we separated the integers without changing the order.

**/

class MoveNegativeValuesEnd {
    public void segregateElements(int[] arr) {
        // Your code goes here
        int copy [] = new int[arr.length];
        int j = 0;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] >= 0) {
                copy[j] = arr[i];
                j++;
            }
        }
        
        for(int i=0; i < arr.length; i++) {
            if(arr[i] < 0) {
                copy[j] = arr[i];
                j++;
            }
        }
        
        for(int i=0; i < arr.length; i++) {
            arr[i] = copy[i];
        }
        
    }
}
