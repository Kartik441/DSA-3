package heap;

import java.util.Collections;
import java.util.PriorityQueue;

// find median in a stream of running integers
public class MedianInStream {
	
	static void median(int a[])
	{
		int n = a.length;

		// max heap
		PriorityQueue<Integer> maxh= new PriorityQueue<>(Collections.reverseOrder());
		// min heap
		PriorityQueue<Integer> minh= new PriorityQueue<>();
		// for first half max heap, for second min heap
		for(int i=0;i<n;i++)
		{
			if(maxh.size() == 0 || a[i] < maxh.peek())
			{
				maxh.add(a[i]);
			}
			
			else
			{
				minh.add(a[i]);
			}
				
			
			// making sure size diff is <= 1
			if(minh.size() > maxh.size() + 1)
			{
				maxh.add(minh.peek());
				minh.poll();
			}
			
			else if (maxh.size() > minh.size() + 1)
			{
				minh.add(maxh.peek());
				maxh.poll();
			}
			
			// finding median
		
			if(minh.size() == maxh.size())
				System.out.println((float)(minh.peek() + maxh.peek())/2);
			
			else if(maxh.size() > minh.size())
				System.out.println(maxh.peek());
			
			else
				System.out.println(minh.peek());
				
		}
	}

	public static void main(String[] args) {
		int a[] = {5, 2, 3, 1, 6, 4};
		median(a);
		int a1[] = {5, 15, 1, 3};
		System.out.println();
		median(a1);

	}

}
