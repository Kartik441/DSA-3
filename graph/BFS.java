package graph;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	
	static void bfs(Graph g,int s)      // s indicates start point
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean visited[] = new boolean[v];
		
		//  create a queue
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		visited[s] = true;
		q.add(s);
		
		while(q.size()!=0)
		{
			s = q.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					q.add(n);
				}
			}
			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	// Another method
	static class Pair
	{
		int v;
		String psf;
		
		Pair(int v, String psf)
		{
			this.v = v;
			this.psf = psf;
		}
	}
	// here printing the path of each node from the source 
	static void solve(Graph g, int s)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		
		boolean visited[] = new boolean[v];
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(s, s + ""));
		
		while(q.size() > 0)
		{
			// r m* w a*
			Pair p = q.removeFirst();
			
			if(visited[p.v] == true)
				continue;
			
			visited[p.v] = true;
			
			System.out.println(p.v + "->" + p.psf);
			
			for(int i=0;i < adj[p.v].size();i++)
			{
				if(visited[adj[p.v].get(i)] == false)      //IMP:
					q.add(new Pair(adj[p.v].get(i), p.psf + adj[p.v].get(i)));
			}
		}
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		bfs(g, 2);
		
		solve(g, 2);

	}
}
