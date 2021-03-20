package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BridgeInGraph {
	
	static int time = 0;
	static void ap(Graph g)
	{
		int v = g.v;
		LinkedList adj[] = g.adj;
		int disc[] = new int[v];
		int low[] = new int[v];
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		int parent[] = new int[v];
		//boolean ap[] = new boolean[v];    // to store ap
		
		Arrays.fill(parent, -1);
		
		for(int i=0;i<v;i++)
		{
			if(disc[i] == -1)
			{
				dfs(i, adj, disc, low, parent);
			}
		}
		
	}
	
	
	static void dfs(int v, LinkedList<Integer> adj[], int disc[], int low[], int parent[])
	{
	
		disc[v] = time;
		low[v] = time;
		
		time++;
		
		// Iterate all neighbors
		Iterator<Integer> i = adj[v].iterator();
		while(i.hasNext())
		{
			int n = i.next();
			// if not visited yet than make it child and recur for it
			if(disc[n] == -1)
			{
				parent[n] = v;
				dfs(n, adj, disc, low, parent);
				// on returning update the low value
				low[v] = Math.min(low[v], low[n]);
				
				// if the lowest vertex reachable from subtree under n is below v in DFS tree,
				// then u-v is a bridge
				if(low[n] > disc[v])
				{
					System.out.println( v+" "+n);
				}
			}
			// update low value of v for parent function calls
			// means it is a back edge
			else if(n != parent[v])  // if we are not returning to the adjacent prev node??????????
				low[v] = Math.min(low[v], disc[n]);     // IMPORTANT
		}
		
	}


	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 3);
		
		ap(g);

	}

}
