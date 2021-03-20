package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
// subgraph - any graph which has subset of vertices and edges of parent graph
// tree - connected acyclic graph
// spanning - all vertices present
// MST - connected graph with all vertices and sum of edges connecting them should be minimum with no cycle
//    work in progress
public class Prims {
	
	static class Pair implements Comparable<Pair>
	{
		int v;
		int av; // acquiring vertex or the vertex from which this vertex is acquired
		int w;  // edge weight between this vertex and acquiring vertex
		
		Pair(int v,int av, int w)
		{
			this.v = v;
			this.av = av;
			this.w = w;  
		}

		@Override
		public int compareTo(Pair o) {
			
			return this.w - o.w;
		}
	}
	
	
	static void solve(WGraph g,int s)
	{
		int v = g.v;
		LinkedList<Edge> adj[] = g.adj;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, -1 , 0));
		boolean visited[] = new boolean[v];
		// in queue are the vertices which are available to be chosen to create a MSP
		// but we will choose the one with the minimum edge 
		while(pq.size() > 0)
		{
			Pair p = pq.remove();
			if(visited[p.v] == true)
				continue;
			
			visited[p.v] = true;
			if(p.v != -1)
				System.out.println(p.v + " - " + p.av + " @ " +  p.w);
			
			for(int i=0; i<adj[p.v].size();i++)
			{
				Edge nbr = adj[p.v].get(i);
				if(visited[nbr.e] == false)
					pq.add(new Pair(nbr.e, p.v, nbr.w ));
			}
		}
	}

	public static void main(String[] args) {
		WGraph g = new WGraph(7);
		
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 40);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 8);
		g.addEdge(5, 6, 3);
		
		solve(g, 0);

	}

}
