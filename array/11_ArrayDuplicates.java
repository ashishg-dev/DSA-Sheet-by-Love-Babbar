// Given an array arr of integers, find all the elements that occur more than once in the array.
// If no element repeats, return an empty array.

// Input: arr[] = [2, 3, 1, 2, 3]
// Output: [2, 3] 
// Explanation: 2 and 3 occur more than once in the given array.

// Input: arr[] = [2]
// Output: [] 
// Explanation: There is single element in the array. Therefore output is empty.

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // If the number is already in the set, it is a duplicate
            if (!seen.add(num)) {
                result.add(num); // Add to the result if it's a duplicate
            }
        }
            return result;
    }
        
}
