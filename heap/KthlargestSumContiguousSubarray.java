package heap;

import java.util.PriorityQueue;

public class KthlargestSumContiguousSubarray {
	
	// idea is to use min heap to store all the k largest subarray sum
	// to calculate subarray sum we use prefix array
	
	static void solve(int a[], int k)
	{
		int n = a.length;
		// array to store prefix sum
		int prefix[] = new int[n];
		prefix[0] = a[0];
		for(int i=1;i<n;i++)
		{
			prefix[i] = a[i] + prefix[i-1];
		}
		// create a min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// loop to calculate contiguous subarray sum position wise
		for(int i=0;i<n;i++)
		{
			for(int j = i;j<n;j++)
			{
				int sum = prefix[j] - prefix[i] + a[i];
				pq.add(sum);
				
				if(pq.size() > k)
					pq.poll();
				
			}
			
		}
		
//		for(int i=0;i<pq.size();i++)
//		{
//			System.out.print(pq.poll()+" ");
//		}
		if(pq.size()!=0)
			System.out.println(pq.poll());
		
	}

	public static void main(String[] args) {
		int a[] = {20,-5, -1};
		solve(a, 3);
		
		int a1[] = {10, -10, 20, -40};
		solve(a1, 6);
	}

}
