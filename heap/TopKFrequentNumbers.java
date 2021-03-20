package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

class Pair1
{
	int n;
	int freq;
	
	Pair1(int n, int freq)
	{
		this.n = n;
		this.freq = freq;
	}
}


public class TopKFrequentNumbers {
	
	
	static void solve(int []a, int k)
	{
		int n = a.length;
		// create a hashmap to store freq
		HashMap<Integer, Integer> hm =new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(!hm.containsKey(a[i]))
			{
				hm.put(a[i], 1);
			}
			else
			{
				int f = hm.get(a[i]);
				hm.put(a[i], ++f);
			}
		}
		
		// create a min heap
		PriorityQueue<Pair1> heap = new PriorityQueue<>( (Pair1 p1, Pair1 p2) -> {
			return p1.freq - p2.freq; 
		});                  // Lambda function
		
		for(int x : hm.keySet())
		{
			Pair1 p = new Pair1(x, hm.get(x));
			heap.add(p);
			if(heap.size() > k)
			{
				heap.poll();
			}
		}
		
		while(!heap.isEmpty())
		{
			System.out.print(heap.poll().n +" ");
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		int a[] = {1, 1, 1, 3, 2, 2, 4, 5, 5, 5, 5, 5};
		int k = 2;
		solve(a, 2);

	}

}
