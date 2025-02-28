/*
Given an integer array arr[]. You need to find the maximum sum of a subarray.

Examples:

Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray {-2} has the largest sum -2.
*/

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        
        int max = Integer.MIN_VALUE;
        
         // Initialize 'max_till_here' to 0, which stores the sum of the current subarray.
        // If this sum becomes negative, we reset it to start a new subarray.
        int max_till_here = 0;
        
        for (int i=0; i < arr.length; i++) {
            
            max_till_here += arr[i];
            
            // If the sum of the current subarray is greater than the maximum found so far,
            // update 'max' to the new maximum sum.
            if(max_till_here > max) {
                max = max_till_here;
            }
            
            // If the sum of the current subarray becomes negative,
            // it is better to start a new subarray. Reset 'max_till_here' to 0.
            if(max_till_here < 0){
                max_till_here = 0;
            }
        }
        
        return max;
    }
}
