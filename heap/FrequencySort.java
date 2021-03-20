package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {
	
	// a slight variation of Top k frequent Numbers
	
	static void sort(int a[])
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
		
		// create a max heap because we will not remove maximum value instead we need it
		PriorityQueue<Pair1> heap = new PriorityQueue<>( (Pair1 p1, Pair1 p2) -> {
			return p2.freq - p1.freq;               // IMP statement
		});                  // Lambda function
		
		for(int x : hm.keySet())
		{
			Pair1 p = new Pair1(x, hm.get(x));
			heap.add(p);
			
		}
		
		int index=0;// for maintaining index till the values are filled
		
		while(!heap.isEmpty())
		{
			int freq = heap.peek().freq;
			int no = heap.poll().n;
			for(int i=0;i<freq;i++)
			{
				a[index] = no;
				index++;
			}		
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		int a[] = {1, 1, 1, 3, 2, 2, 4, 5, 5, 5, 5, 5};
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		
		sort(a);
		
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		

	}

}
