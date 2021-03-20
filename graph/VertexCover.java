package graph;

import java.util.LinkedList;

public class VertexCover {
	// using approximate algorithm
	// this algorithm will never find a vertex cover whose size is more than twice the
	// the size of minimum possible vertex cover
	
	// approximate algorithm
	
	static void solve(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean vis[] = new boolean[v];
		for(int u=0;u<v;u++)
		{
			if(vis[u] == false)
			{
				for(int i=0;i<adj[u].size();i++)
				{
					int n = adj[u].get(i);
					if(vis[n] == false)
					{
						vis[n] = true;
						vis[u] = true;
						System.out.println("choosing edge between "+u+" "+n);
						break;
						
					}
				}

			}
		}
		
		for(int i=0;i<v;i++)
		{
			if(vis[i])
				System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		Graph g = new Graph(7);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(1, 3);
//		g.addEdge(3, 4);
//		g.addEdge(4, 5);
//		g.addEdge(5, 6);
//		
//		solve(g);
//		
//		
//		Graph g1 = new Graph(3);
//		g1.addEdge(0, 1);
//		g1.addEdge(0, 2);
//		g1.addEdge(1, 0);
//		g1.addEdge(1, 2);
//		g1.addEdge(2, 0);
//		g1.addEdge(2, 0);
//		
//		solve(g1);
		
		// for this graph it gives wrong answer because of approximate solution
		Graph g2 = new Graph(6);
		g2.addEdge(0, 1);
		g2.addEdge(1, 0);
		g2.addEdge(1, 3);
		g2.addEdge(1, 2);
		g2.addEdge(2, 1);
		g2.addEdge(2, 4);
		g2.addEdge(3, 1);
		g2.addEdge(3, 4);
		g2.addEdge(3, 5);
		g2.addEdge(4, 2);
		g2.addEdge(4, 3);
		g2.addEdge(5, 3);
		
		solve(g2);
		

	}

}
