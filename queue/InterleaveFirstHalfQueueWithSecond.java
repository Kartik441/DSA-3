package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// input: 11 12 13 14 15 16 17 18 19 20
//output: 11 16 12 17 13 18 14 19 15 20

// only stack is allowed to use 
public class InterleaveFirstHalfQueueWithSecond {
	// point is to reverse first half of the queue and than interleave
	static void solve(int a[])
	{
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<a.length;i++)
		{
			q.add(a[i]);
		}
		Stack<Integer> s = new Stack<>();
		int mid = q.size()/2;
		// remove first half of queue and put in stack
		for(int i=0;i<mid;i++)
		{
			s.add(q.poll());
		}
		// enqueue it back
		while(!s.isEmpty())
		{
			q.add(s.pop());
		}
		// dequeue first half and enqueue them back
		for(int i=0;i<mid;i++)
		{
			q.add(q.peek());
			q.poll();
		}
		// again push first half of the elements in stack
		for(int i=0;i<mid;i++)
		{
			s.add(q.poll());
		}
		
		// now add in queue in interleaving manner
		while(!s.isEmpty())
		{
			q.add(s.pop());
			q.add(q.peek());
			q.poll();
		}
		
		System.out.println(q);
		
		
	}

	public static void main(String[] args) {
		int a[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		solve(a);
		int a1[] = {1, 2, 3, 4};
		solve(a1);

	}

}
