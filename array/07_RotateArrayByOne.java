/**
Given an array arr, rotate the array by one position in clockwise direction.
Input: arr[] = [1, 2, 3, 4, 5]
Output: [5, 1, 2, 3, 4]
Explanation: If we rotate arr by one position in clockwise 5 come to the front and remaining those are shifted to the end.

**/
class Solution {
    public void rotate(int[] arr) {
        
      int temp = arr[arr.length-1];
  		for(int i=arr.length-1; i>0;i--) {
  			arr[i] = arr[i-1];
  		}
  		
  		arr[0] = temp;
    }
}
