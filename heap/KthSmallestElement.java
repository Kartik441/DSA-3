package heap;

import java.util.PriorityQueue;

import java.util.Collections;

// a variation could be sum of elements between k1 smallest and k2 smallest

public class KthSmallestElement {
	
	static int smallest(int a[], int k)
	{
		int n = a.length;
		// creating max heap
		PriorityQueue<Integer> heap= new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int i=0; i<n;i++)
		{
			heap.add(a[i]);
			
			// remove top element if size exceeds k
			if(heap.size() > k)
			{
				heap.poll();
			}
			
		}

		return heap.poll();
	}
	
	// Kth largest element 
	static int largest(int a[], int k)
	{
		int n = a.length;
		// creating a min heap
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i = 0;i<n;i++)
		{
			heap.add(a[i]);
			
			if(heap.size() > k)
			{
				heap.poll();
			}
		}
		return heap.poll();
		// for printing k largest elements just print the heap
	}

	public static void main(String[] args) {
		int a[] = {7, 10, 4, 3, 20, 15};
		int k = 6;
		System.out.println(smallest(a,k));
		System.out.println(largest(a, k));
	}
}
// Method 2: Using HashTable (also works if rows not sorted)
// simply traverse all elements and store frequency
// 
