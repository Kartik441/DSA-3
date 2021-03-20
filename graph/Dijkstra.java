package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
// to find shortest path in terms of number of edges, bfs is the best option
// to find in terms of weights Dijkstra is used
// almost same as bfs, just use priority queue
// dijkstra will work same as bfs if weight of all edges is same
// it is a greedy approach
// dijkstra may or may not work for negative edges
// dijkstra will work for both directed and undirected graph
public class Dijkstra {

	static class Pair implements Comparable<Pair>
	{
		int v;
		String psf;
		int wsf;
		
		Pair(int v,String psf, int wsf)
		{
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(Pair o) {
			
			return this.wsf - o.wsf;
		}
	}
	
	static void solve(WGraph g,int s)
	{
		int v = g.v;
		LinkedList<Edge> adj[] = g.adj;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(s, s+"" , 0));
		boolean visited[] = new boolean[v];
		
		while(pq.size() > 0)
		{
			Pair p = pq.remove();
			if(visited[p.v] == true)
				continue;
			
			visited[p.v] = true;
			System.out.println(p.v + " via " + p.psf + " covering distance of " +  p.wsf);
			
			for(int i=0; i<adj[p.v].size();i++)
			{
				Edge nbr = adj[p.v].get(i);
				if(visited[nbr.e] == false)
					pq.add(new Pair(nbr.e, p.psf + nbr.e, p.wsf + nbr.w ));
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
