//Given two sorted arrays a[] and b[] of size n and m respectively, 
//the task is to merge them in sorted order.
//Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

// Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
// Output:
// 2 2 3 4
// 7 10
// Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int firstArray[], int secondArray[]) {
        // code here
        
        int i = 0, j = 0, k = 0;
        int length1 = firstArray.length;
        int length2 = secondArray.length;
        
        // Temporary array to hold the merged elements
        int mergedArray[] = new int[length1 + length2];
        
        // Merging the elements of the two arrays
        while (i < length1 && j < length2) {
            // Pick the smaller element from the two arrays and place it in mergedArray
            if (firstArray[i] < secondArray[j]) 
                mergedArray[k++] = firstArray[i++];
            else 
                mergedArray[k++] = secondArray[j++];
        }

        // If there are remaining elements in the first array, add them to mergedArray
        while (i < length1)
            mergedArray[k++] = firstArray[i++];

        // If there are remaining elements in the second array, add them to mergedArray
        while (j < length2)
            mergedArray[k++] = secondArray[j++];
        
        // Copy merged elements back to the original arrays
        i = 0;
        j = 0;
        k = 0;
        
        // Copy elements back to the first array
        while(i < length1) { 
            firstArray[i++] = mergedArray[k++];
        }
        
        // Copy elements back to the second array
        while(j < length2) {
            secondArray[j++] = mergedArray[k++];
        }
        
    }
}
