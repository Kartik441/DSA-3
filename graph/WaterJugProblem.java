package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class WaterJugProblem {
	
	static class Pair
	{
		int x;
		int y;
		public Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static int createKey(int x, int y)
	{
		int a = 53;
		int b = 79;
		return a*x + b*y;
	}
	
	static void solve(int jug1, int jug2, int target)
	{
		HashMap<Integer, Integer> hm = new HashMap<>();
		boolean isSolvable = false;
		ArrayList<Pair> path = new ArrayList<>();   
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		
		while(!q.isEmpty())
		{
			Pair u = q.poll();
	
			if(hm.containsKey(createKey(u.x, u.y)))
			{
				continue;
			}
			
			if(u.x > jug1 || u.y > jug2|| u.x <0 || u.y < 0)
				continue;
			
			path.add(u);
			
			hm.put(createKey(u.x, u.y),1);
			
			if(u.x == target || u.y == target)
			{
				isSolvable = true;
				if(u.x == target)
				{
					if(u.y != 0)
						path.add(new Pair(u.x, 0));
				}
				else
				{
					if(u.x != 0)
						path.add(new Pair(0, u.y));
				}
				
				for(int i=0;i<path.size();i++)
				{
					System.out.println("("+path.get(i).x+", "+path.get(i).y +")");
				}
				break;
			}
			// if we have not reached final state than start developing intermediate states
			// to reach solution
			q.add(new Pair(u.x, jug2));    // fill jug2
			q.add(new Pair(jug1, u.y));    // fill jug1
			
			for(int ap=0;ap<=Math.max(jug1, jug2); ap++) // ap -amount poured
			{
				// pour ap from jug2 to jug1
				int a = u.x + ap;
				int b = u.y - ap;
				
				// check if this state is possible or not
				if(a == jug1 || (b == 0 && b >= 0))
					q.add(new Pair(a, b));
				
				// pour ap from jug1 to jug2
				a = u.x - ap;
				b = u.y + ap;
				
				// check if this state is possible or not
				if((a == 0 && a >= 0) || b == jug2)
					q.add(new Pair(a, b));					
			}
			
			q.add(new Pair(jug1, 0));   // empty jug2
			q.add(new Pair(0, jug2));   // empty jug1
		}
		
		if(!isSolvable)
			System.out.println("No solution");
		
	}

	public static void main(String[] args) {
		solve(4, 3, 2);

	}

}
