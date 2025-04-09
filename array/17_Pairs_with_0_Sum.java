/**

Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.

Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.

Examples:

Input: arr = [-1, 0, 1, 2, -1, -4]
Output: [[-1, 1]]
Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
arr[2] + arr[4] = 1 + (-1) = 0.
The distinct pair are [-1,1].

Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
Output: [[-6, 6],[-1, 1]]
Explanation: The distinct pairs are [-1, 1] and [-6, 6].
Expected Time Complexity: O(n log n)
Expected Auxiliary Space: O(n).

Constraints:
3 <= arr.size <= 105
-105 <= arr[i] <= 105

**/

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        
        
        Set<ArrayList<Integer>> resultSet = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // If the complement (-num) has been seen, then it's a valid pair
            if (seen.contains(-num)) {
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(num, -num));
                Collections.sort(pair); // Ensure pairs are sorted
                resultSet.add(pair);     // Add the sorted pair to the result set
            }
            seen.add(num); // Add the current number to 'seen'
        }
        
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>(resultSet);
        // Sort pairs by their first element
        resultList.sort((a, b) -> a.get(0) - b.get(0)); 
        
        return resultList;
        
    }
}
