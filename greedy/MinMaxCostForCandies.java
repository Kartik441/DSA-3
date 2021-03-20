package greedy;

import java.util.Arrays;

//In a candy store there are N different types of candies available and the prices of all 
//the N different types of candies are provided. There is also an attractive offer by candy store.
// We can buy a single candy from the store and get at-most K other candies (all are different types)
// for free.

//Find minimum amount of money we have to spend to buy all the N different candies.
//Find maximum amount of money we have to spend to buy all the N different candies.

public class MinMaxCostForCandies {
	
//	One important thing to note is, we must use the offer and get maximum candies back 
//	for every candy purchase. So if we want to minimize the money, we must buy candies at 
//	minimum cost and get candies of maximum costs for free. To maximize the money, we must do
//	the reverse.
	
	// TC: O(nlogn)
	static int findMinimum(int arr[], int n, int k)
    {
		Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < n; i++) {
            // Buy current candy
            res += arr[i];
 
            // And take k candies for free
            // from the last
            n = n - k;
        }
        System.out.println(res);
        return res;
    }
	
	// Function to find the maximum
    // amount to buy all candies
    static int findMaximum(int arr[], int n, int k)
    {
    	Arrays.sort(arr);
    	
        int res = 0, index = 0;
 
        for (int i = n - 1; i >= index; i--) 
        {
            // Buy candy with maximum amount
            res += arr[i];
 
            // And get k candies for free from
            // the starting
            index += k;
        }
        System.out.println(res);
        return res;
    }

	public static void main(String[] args) {
		 int arr[] = { 3, 2, 1, 4 };
	        int n = arr.length;
	        int k = 2;
	        
	        findMinimum(arr, n, k);
	        findMaximum(arr, n, k);

	}

}
