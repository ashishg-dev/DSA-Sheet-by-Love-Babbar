/**

Given an array of Intervals arr[][], where arr[i] = [starti, endi].
The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4].
Therefore we will return [[1,4], [6,8], [9,10]].

Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].


Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ starti ≤ endi ≤ 105

**/

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        
        // Sort the intervals by ascending order (we use a lambda comparator)
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // List to store merged intervals
        List<int[]> merged = new ArrayList();
        
        // Start by adding the first interval to the merged list
        merged.add(arr[0]);
        
        // Iterate through the rest of the intervals
        for(int i = 0; i < arr.length; i++) {
            // Get the current interval and the last merged interval
            int[] curr = arr[i];
            int lastMerged[] = merged.get(merged.size() - 1);
            
            if(curr[0] <= lastMerged[1]) {
                 // Merge the two intervals by updating the end time of the last merged interval
                 lastMerged[1] = Math.max(lastMerged[1],curr[1]);
            } else {
                // If no overlap, simply add the current interval to the list
                merged.add(curr);
            }
            
        }
        
        return merged;
        
    }
}
