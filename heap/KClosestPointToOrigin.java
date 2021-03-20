package heap;

import java.util.PriorityQueue;

class Pair3
{
	int index;
	double dist;
	
	Pair3(int index, double dist)
	{
		this.index = index;
		this.dist = dist;
	}
}

public class KClosestPointToOrigin {
	
	static void solve(int [][]a, int k)
	{
		int n = a.length;         // rows
		// columns would always be 2(x, y)
		
		
		// creating maxheap
		
//		PriorityQueue<Pair3> heap = new PriorityQueue<>( (Pair3 p1, Pair3 p2) -> {
//			return p1.dist - p2.dist;
//		});
		
		PriorityQueue<Pair3> heap = new PriorityQueue<>( ( p1,  p2) -> {
			if(p1.dist < p2.dist)
				return 1;
			else if(p1.dist > p2.dist)
				return -1;
			else
				return 0;
		});                  // Lambda function
		
		
		for(int i=0;i<n;i++)
		{
			// calculating dist from origin
			double dist = Math.sqrt(Math.pow(a[i][0], 2) + Math.pow(a[i][1], 2));
			
			Pair3 p = new Pair3(i, dist);
			
			heap.add(p);
			
			if(heap.size() > k)
			{
				heap.poll();
			}
		}
		
		
		while(!heap.isEmpty())
		{
			System.out.print(heap.poll().index+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {
				{1, 3},
				{-2, 2},
				{5, 8},
				{0, 1},
				{0, 0}
		};
		
		solve(a, 2);

	}

}
