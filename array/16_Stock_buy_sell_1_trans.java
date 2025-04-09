class Solution {
    // Function to find the days of buying and selling stock for max profit.
    int stockBuySell(int arr[]) {
        
        int profit = 0;
        int curr = Integer.MAX_VALUE;
        
        for(int i=1; i<arr.length; i++) {
            
            if(arr[i] > arr[i-1]) {
                profit += arr[i] - arr[i-1];
            }
            
        }
        
        return profit;
        
    }
}
