package greedy;

import java.util.Arrays;

public class MinPlatforms {
	// idea is to sort the arrival time and departure time. No need to consider
	// train number. Than we can use two pointer approach to calculate answer

	public static void findPlatform(int arr[], int dept[], int n) {
		Arrays.parallelSort(arr);
		Arrays.parallelSort(dept);
		
		int plat_needed = 1;
		int result = 1;
		int i=1, j=0;
		while(i < n && j< n)
		{
			if(arr[i] <= dept[i])
			{
				plat_needed++;
				i++;             // move to next arriving time
			}
			
			else if(arr[i] > dept[i]) // because one train is going to leave, hence decrease platform 
			{                           // count
				plat_needed--;
				j++;     // move to next departing time
			}
			
			if(plat_needed > result)
				result = plat_needed;
		}
		System.out.println(result);
		
	}

	public static void main(String[] args) {
		 int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
	        int n = 6;
	
	        findPlatform(arr, dep, n);

	}

}
