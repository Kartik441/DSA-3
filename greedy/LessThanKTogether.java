package greedy;
// minimum swaps required to bring all elements less than or equal to k together
public class LessThanKTogether {
	// idea is to count bad count in every window of element less than equal to k
	static void solve(int a[], int k)
	{
		int n = a.length;
		// count of elements less than or equal to k
		int count = 0;
		for(int i=0;i<n;i++)
		{
			if(a[i] <= k)
				count += 1;
		}
		int badCount = 0;
		int i=0;
		for(i=0;i<count;i++)
		{
			if(a[i] > k)
				badCount += 1;
		}
		int minSwap = badCount;
		//System.out.println(minSwap);
		for(i=1; i <= n-count;i++)
		{
			if(a[i-1] > k)
				badCount--;
			if(a[i+count-1] > k)
				badCount++;
			
			minSwap = Math.min(minSwap, badCount);
		}
		System.out.println( minSwap);
		
	}

	public static void main(String[] args) {
		
		int a[] = {2, 1, 5, 6, 3};
		solve(a, 3);
		
		int a1[] = {2, 7, 9, 5, 8, 7,4};
		solve(a1,5);
		
		int a2[] = {2, 5, 8, 1, 6, 3};
		solve(a2, 3);

	}

}
