package graph;

import java.util.ArrayList;
import java.util.LinkedList;

// get connected component of graph

// a variation could be to find if the graph is connected
// if only one component is present in the graph than graph is connected
public class ConnectedComponents {
	
	static void solve(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean vis[] = new boolean[v];
		// giving each vertex chance to cover as many vertex as possible by dfs
		ArrayList<ArrayList<Integer>> comps =new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			if(vis[i] == false)
			{
				ArrayList<Integer> comp = new ArrayList<>();
				dfs(v, adj, i, vis, comp);
				comps.add(comp);
			}
			
		}
		System.out.println(comps);
		
		if(comps.size() == 1 || comps.size() == 0)
			System.out.println("graph is connected");
		else
			System.out.println("graph is not connected");
	}
	
	static void dfs(int v, LinkedList<Integer> adj[], int s, boolean vis[], ArrayList<Integer> comp)
	{
		if(vis[s])
			return;
		
		vis[s] = true;
		comp.add(s);
		
		for(int i=0;i<adj[s].size();i++)
		{
			dfs(v, adj, adj[s].get(i), vis, comp);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(7);
		
		g.addEdge(0, 1);
		g.addEdge(1, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
		g.addEdge(4, 5);
		g.addEdge(5, 4);
		g.addEdge(4, 6);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(6, 5);
		
		solve(g);
		

	}

}
