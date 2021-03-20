package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

// minimum edges to reverse  to make path from source to destination
// given a directed graph and a source node and a destination node, we need to find how many edges 
// to reverse in order to make at least one path from source node to destination node

public class MinEdgesToReverse {
	
	// idea is to change the graph by making a reverse edge with every given edge
	// which we can use to travel to destination.
	// than we can assign 1 weight to reversed edge and 0 weight to given edges
	// and than apply dijkstra. The dijkstra will try to take shortest path and will
	// only take reverse edge when no normal edges are present
	// dijkstra will give us min cost which is minimum edge reversal from source to
	// destination
	
	static void solve(Graph graph, int src, int dest)
	{
		// first convert the graph into weighted graph
		WGraph g  = convert(graph);
		// now apply dijkstra
	
		
		int ans = dijkstra(g, src, dest);
		
		if(ans!=-1)
			System.out.println(ans);
		else
			System.out.println("Not possible");
	}
	
	static WGraph convert(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		
		WGraph wg = new WGraph(v);
		for(int i=0;i<v;i++)
		{
			
			for(int j=0;j<adj[i].size();j++)
			{ 
				int n = adj[i].get(j);
		
				wg.addEdge(i, n, 0);        // same edge with weight 0
				wg.addEdge(n, i, 1);        // reverse edge with weight 1
			}
		}
		
		return wg;
		
	}
	
	static class Pair implements Comparable<Pair>
	{
		int s;
		int dist;
		
		Pair(int s, int dist)
		{
			this.s = s;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			
			return this.dist - o.dist;
		}
	}
	
	static int dijkstra(WGraph g, int src,int dest)
	{
		int v = g.v;
		LinkedList<Edge> adj[] = g.adj;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		pq.add(new Pair(src, 0));
		boolean vis[] = new boolean[v];
		while(!pq.isEmpty())
		{
			Pair curr= pq.poll();
			int s = curr.s;
			int dist = curr.dist;
			vis[s] = true;
			if(s == dest)
				return dist;
			
			for(int i=0;i<adj[s].size();i++)
			{
				int n = adj[s].get(i).e;
				int w = adj[s].get(i).w;
				
				if(!vis[n])
				{
					pq.add(new Pair(n, dist + w));
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(6, 3);
		g.addEdge(6, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 1);
		
		solve(g, 0, 6);
		

	}

}
