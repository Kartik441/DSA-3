package graph;

import java.util.LinkedList;
import java.util.Stack;

// find number of SCC(strongly connected component) in graph
// a directed graph is strongly connected if there is a path between all pairs of vertices
public class KosarajusAlgorithm {

	// TC : O(V+E)
	// dfs is done two times
	
	static void SCC(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		
		Stack<Integer> s = new Stack<>();
		boolean visited[] = new boolean[v];
		
		// first dfs to fill the stack
		for(int i=0;i<v;i++)
		{
			if(visited[i] == false)
				fillOrder(i, adj, visited, s);
		}
		
		// now reverse the edges of the graph
		Graph rg = reverse(g);
		int rv = rg.v;
		LinkedList<Integer> radj[] = rg.adj;
		
		// now we again do dfs
		// mark all vertex as unvisited again
		for(int i=0;i<rv;i++)
		{
			visited[i] = false;
		}
		// now processing vertices using stack
		while(!s.isEmpty())
		{
			int ver = s.pop();
			// print SCC of popped vertex doing dfs from this vertex
			if(visited[ver] == false)
			{
				dfs(ver, radj, visited);
				System.out.println();
			}
			
		}
		
		
	}
	// this dfs is same as the dfs of topological sort
	static void fillOrder(int v, LinkedList<Integer> adj[],boolean vis[], Stack<Integer> s)
	{
		vis[v] = true;
		
		for(int i=0;i<adj[v].size();i++)
		{
			if(vis[adj[v].get(i)] == false)
				fillOrder(adj[v].get(i),adj,vis,s);
		}
		// All vertices reachable from v are processed by now
		// push v to stack
		s.push(v);
		
	}
	
	static Graph reverse(Graph g1)
	{
		int v = g1.v;
		LinkedList<Integer> adj[] = g1.adj;
		// create new Graph
		Graph g = new Graph(v);
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<adj[i].size();j++)
			{
				g.addEdge(adj[i].get(j),i);
			}
		}
		return g;
	}
	
	static void dfs(int v, LinkedList<Integer> adj[],boolean vis[])
	{
		vis[v] = true;
		
		System.out.print(v+" ");
		
		for(int i=0;i<adj[v].size();i++)
		{
			if(vis[adj[v].get(i)] == false)
				dfs(adj[v].get(i),adj,vis);
		}
	}
	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		//g.addEdge(1, 0);
		SCC(g);
		
	}

}
