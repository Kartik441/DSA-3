package queue;

import java.util.LinkedList;
import java.util.Deque;

public class SlidingWindowMaximum {
// variation of this problem is "sum of minimum and maximum elements of all subarray of subsize k"
// total windows will be (n-k)+1 where is total no of element and k is the size of each window	
	static void max(int a[], int k)
	{
		// the deque will always store index of the elements in decreasing order(of the window)
		int n = a.length;
		Deque<Integer> dq = new LinkedList<>();
		
		// processing first window
		dq.add(0);
		for(int i = 1;i<k;i++)
		{
			while(!dq.isEmpty() && a[i] >= a[dq.peekLast()])  // removing all elements which are smaller than
				dq.removeLast();							  // current element
			dq.addLast(i);
		}
		for(int i = k;i<n;i++)     // i will point to the index that has to be inserted into new window
		{
			System.out.println(a[dq.peekFirst()]);

//			while(!dq.isEmpty() && dq.peekFirst() <= i-k)
//				dq.removeFirst();
			if(!dq.isEmpty() && dq.peekFirst() <= i-k)  // if this element has to be removed because window 
				dq.removeFirst();						// is going to shift							
			
			while(!dq.isEmpty() && a[i] >= a[dq.peekLast()]) // adding the new element
				dq.removeLast();
			
			dq.addLast(i);
		}
		System.out.println(a[dq.peekFirst()]);
	}
	

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int a1[] = {12, 1, 78, 90, 57, 89, 56};
		int k = 3;
		int a2[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		
		
		max(a, k);
		System.out.println();
		max(a1, k);
		System.out.println();
		max(a2, 4);
		System.out.println();



	}

}
