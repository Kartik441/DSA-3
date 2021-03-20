package greedy;

import java.util.Arrays;

// 1: Each student should get one packet and diff between max choc in one packet and min choc in one packet 
// should be minimum
public class ChocolateDistributionProblem {
	
	static int solve(int a[], int m)
	{
		int n = a.length;
		Arrays.parallelSort(a);
		int minDiff = Integer.MAX_VALUE;
		
		for(int i=0; i<=n- m;i++)
		{
			minDiff = Math.min(minDiff, a[i + (m-1)] - a[i]);
		}
		
		return minDiff;
	}
	
	// practice one more variation of question which can be solved using kadanes algorithms

	public static void main(String[] args) {
		int a[] = {7, 3, 2, 4, 9, 12, 56};
		System.out.println(solve(a, 3));
		
		int a1[] = {3, 4, 1, 9, 56, 7, 9, 12};
		System.out.println(solve(a1, 5));
		
		int a2[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
		System.out.println(solve(a2, 7));

	}

}
