package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

// given n sorted arrays or lists of different size, merge them into single list
public class MergeKSortedArrays {
	
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
		
		
	}
	// TC : O(nlogk)
	static void solve(ArrayList<ArrayList<Integer>> list)
	{
		int n = list.size();
		PriorityQueue<Pair> heap = new PriorityQueue<>();
		ArrayList<Integer> ans = new ArrayList<>();
		// add first element of every array
		for(int i=0;i<n;i++)
		{
			heap.add(new Pair(list.get(i).get(0), i, 0));
		}
		
		while(!heap.isEmpty())
		{
			Pair curr = heap.poll();

			int i = curr.arNo;  // i => Array Number
			int j = curr.index;  // j => index in the array number
			
			ans.add(curr.val);
			
			// push the next element of the array of curr
			// because the array is sorted this will be the next bigger element after current element
			// from that array
			
			if(j+1 < list.get(i).size())    // checking for index out of bound error
			{
				j+=1;
				heap.add(new Pair(list.get(i).get(j), i, j));
			}
		}
		
		System.out.println(ans);
			
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<3;i++)
		{
			list.add(new ArrayList<Integer>());
		}
		
		list.get(0).add(2);
		list.get(0).add(6);
		list.get(0).add(12);
		
		list.get(1).add(1);
		list.get(1).add(9);
		
		list.get(2).add(23);
		list.get(2).add(34);
		list.get(2).add(90);
		list.get(2).add(2000);
		
		
		solve(list);

	}

}
