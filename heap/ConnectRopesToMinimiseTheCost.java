package heap;

import java.util.PriorityQueue;

public class ConnectRopesToMinimiseTheCost {
	
	static int min(int []a)
	{
		int n = a.length;
		// creating min heap
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int i=0;i<n;i++)
		{
			heap.add(a[i]);
		}
		
		int cost = 0;
		cost = heap.poll() + heap.poll();      // adding first two parts
		heap.add(cost);
		while(heap.size() > 1)
		{
			int newCost = heap.poll() + heap.poll();      // creating new rope by adding 2 parts
			cost += newCost; 
			heap.add(newCost);                   
		}
		
		return cost;
	}

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5};
		int a1[] = {4, 3, 2, 6};
		System.out.println(min(a));

	}

}
