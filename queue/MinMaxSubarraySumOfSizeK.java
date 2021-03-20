package queue;
import java.util.Deque;
import java.util.LinkedList;

// sum of minimum and maximum elements of all subarrays of size k
// the idea is to use sliding window protocol using deque
// code in progress
public class MinMaxSubarraySumOfSizeK {
	
	static void minMaxSum(int a[], int k)
	{
		int n = a.length;
		
		Deque<Integer> mind = new LinkedList<>();
		Deque<Integer> maxd = new LinkedList<>();
		int i=0;
		mind.add(i);        // we will store indexes
		maxd.add(i);
		// processing first window of  array
		for(i=1;i<k;i++)
		{
			while(!mind.isEmpty() && a[i] <= a[mind.peekLast()] )
			{
				mind.removeLast();
			}
			while(!maxd.isEmpty() && a[i] >= a[maxd.peekLast()] )
			{
				maxd.removeLast();
			}
			mind.addLast(i);
			maxd.addLast(i);
		}
		
		for(i=k ; i<n;i++)
		{
			System.out.println( a[mind.peekFirst()] + a[maxd.peekFirst()] );
			
			if(!mind.isEmpty() && mind.peekFirst() <= i-k)
			{
				mind.removeFirst();
			}
			if(!maxd.isEmpty() && maxd.peekFirst() <= i-k)
			{
				maxd.removeFirst();
			}
			
			while(!mind.isEmpty() && a[mind.peekLast()] >= a[i])
			{
				mind.removeLast();
			}
			while(!maxd.isEmpty() && a[maxd.peekLast()] <= a[i])
			{
				maxd.removeLast();
			}
			mind.addLast(i);
			maxd.addLast(i);
		}
		System.out.println( a[mind.peekFirst()] + a[maxd.peekFirst()] );
		
	}

	public static void main(String[] args) {
		int a[] = {2, 5, -1, 7, -3, -1, -2};
		int k=4;
		
		minMaxSum(a, k);
		
		

	}

}
