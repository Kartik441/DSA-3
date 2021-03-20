package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ArticulationPoint {  // or cut vertices
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
		boolean ap[] = new boolean[v];    // to store ap
		
		Arrays.fill(parent, -1);
		
		for(int i=0;i<v;i++)
		{
			if(disc[i] == -1)
			{
				dfs(i, adj, disc, low, parent, ap);
			}
		}
		// now print the aps
		for(int i=0;i<v;i++)
		{
			if(ap[i] == true)
				System.out.print(i+" ");
		}
	}
	
	
	static void dfs(int v, LinkedList<Integer> adj[], int disc[], int low[], int parent[], boolean ap[])
	{
		// count child in dfs tree
		int children = 0;
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
				children++;
				parent[n] = v;
				dfs(n, adj, disc, low, parent, ap);
				// on returning update the low value
				low[v] = Math.min(low[v], low[n]);
				
				// v is articulation point in following cases
				// if v is not root and low value of one of its child is more than discovery value of v
				
				if(parent[v] !=  -1 && low[n] >= disc[v])
				{
					ap[v] = true;
				}
				
				if(parent[v] == -1 && children > 1)
				{
					ap[v] = true;
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
