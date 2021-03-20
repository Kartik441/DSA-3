package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// code is in progress

// find smallest range containing element from k lists. At least one element from each list
// must be present in this range.
// the lists can be of different size


public class SmallestRangeInKLists {
	// idea is to keep pointer at every list and than try to minimize the range
	// by incrementing pointer of min element 
	// here solving for all lists of same length but will work for different length as well
	
	static class Pair implements Comparable<Pair>
	{
		int val;
		int arNo;
		int index;
		
		public Pair(int val, int arNo,int index)
		{
			this.val = val;
			this.arNo = arNo;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
		
		public boolean equals(Pair o)
		{
			//return true;
			if(o == this)
				return true;
			if(o == null)
				return false;
			if(!(o instanceof Pair))
				return false;
			return (o.arNo == this.arNo && o.index == this.index);
//			
			
		}
		
		public int hashCode()
		{
			int hash =7;
			hash = 31*hash + val;
			return hash;
			
			
		}
		
		
	}
	static void solve(ArrayList<ArrayList<Integer>> list, int k)
	{
		int n = list.get(0).size();  // size of each list
		int range = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		PriorityQueue<Pair> minheap = new PriorityQueue<>();
		PriorityQueue<Pair> maxheap = new PriorityQueue<>(Collections.reverseOrder());

		// add first element of every array
		for(int i=0;i<k;i++)
		{
			minheap.add(new Pair(list.get(i).get(0), i, 0));
			maxheap.add(new Pair(list.get(i).get(0), i, 0));
		}
		
		//int minIndex = 0;   // this will point at the min
		
		while(true)
		{
			Pair currmin = minheap.peek();
			Pair currmax = maxheap.peek();
			
			int minval = currmin.val;
			int maxval = currmax.val;
			System.out.println(minval +" "+maxval);
			// update the result
			if(maxval - minval < range)
			{
				range = maxval - minval;
				max = maxval;
				min = minval;
			}

			
			int imin = currmin.arNo;  // i => Array Number
			int jmin = currmin.index;  // j => index in the array number
			System.out.println("index "+imin+" "+jmin);

			// increment the index and push the next element of the array of curr
			// because the array is sorted this will be the next bigger element after current element
			// from that array
			
			if(jmin+1 < list.get(imin).size())    // checking for index out of bound error
			{
				minheap.poll();
				System.out.println(maxheap.remove(currmin));
				//maxheap.re
				jmin+=1;
				minheap.add(new Pair(list.get(imin).get(jmin), imin, jmin));
				
			}
			else
				break;
		}
	System.out.println(range);
	System.out.println(min +" - "+max);
		
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		minheap.add(5);
		minheap.add(12);
		minheap.add(3);
		
		System.out.println(minheap.remove(12));
		
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<3;i++)
		{
			list.add(new ArrayList<Integer>());
		}
		
		list.get(0).add(4);
		list.get(0).add(7);
		list.get(0).add(9);
		list.get(0).add(12);
		list.get(0).add(15);
		
		list.get(1).add(0);
		list.get(1).add(8);
		list.get(1).add(10);
		list.get(1).add(14);
		list.get(1).add(20);
		
		list.get(2).add(6);
		list.get(2).add(12);
		list.get(2).add(16);
		list.get(2).add(30);
		list.get(2).add(50);
		
		
		solve(list, 3);

	}

}
