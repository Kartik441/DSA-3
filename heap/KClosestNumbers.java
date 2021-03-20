package heap;


import java.util.PriorityQueue;
import java.util.Comparator;

// find k closest number to key
class Pair
{
	int index;
	int diff;
	
	Pair(int index, int diff)
	{
		this.index = index;
		this.diff = diff;
	}
}
// One idea is to just subtract k from each no and find the min k numbers
public class KClosestNumbers {

	static void solve(int a[], int k, int key)
	{
		int n =a.length;
		// creating max heap
		// there is no meaning of max or min heap if passing the comparator
		PriorityQueue<Pair> heap= new PriorityQueue<>(new Comparator<Pair>(){
			
			public int compare(Pair p1, Pair p2)
			{
				return p2.diff - p1.diff;
			}
		});
		
		for(int i=0;i<n;i++)
		{
			Pair p = new Pair(i, Math.abs(a[i]-key));
			
			heap.add(p);
			
			if(heap.size() > k)
			{
				heap.poll();
			}
		}
		
//		Pair.forEach(System.out::println);
		while(!heap.isEmpty())
		{
			System.out.print(a[heap.poll().index] + " ");
		}
	
		System.out.println();
		
		
	}
	public static void main(String[] args) {
		int a[] = {5, 6, 7, 8, 9};
		int k = 3;
		int key = 7;
		solve(a, k, key);
		int a1[] = {10, 2, 14, 4, 7, 6};
		int k1 = 3;
		int key1 = 5;
		solve(a1,k1, key1);
		
		int a2[]=  {-10, -50, 20, 17, 80};
		int k2 = 2;
		int key2 = 20;
		solve(a2,k2, key2);

	}

}
