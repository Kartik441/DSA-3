package graph;

import java.util.Iterator;
import java.util.LinkedList;
// Time Complexity: O(V+E)
// Space Complexity: O(V)

public class DFS {
	// This will not handle disconnected graph
	// This will traverse the graph
	static void dfs(Graph g, int s)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean visited[] = new boolean[v];
		dfsUtil(v, adj, s, visited );
		System.out.println();
	}
	
	static void dfsUtil(int v, LinkedList<Integer>[] adj, int s, boolean visited[])
	{
		visited[s] = true;
		System.out.print(s+" ");
		
		Iterator<Integer> i =adj[s].iterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				dfsUtil(v, adj, n, visited);
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	// if two points, source and destination are given, find whether a path exists from source to destination
	// using dfs
	static boolean hasPath(Graph g, int s, int d)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean visited[] = new boolean[v];
		return hasPath(v, adj, s, d, visited);
	}
	
	static boolean hasPath(int v, LinkedList<Integer>[] adj, int s,int d, boolean visited[])
	{
		if(visited[s])
			return false;
		
		visited[s] = true;
		if(s == d)
			return true;
		
		for(int i=0; i < adj[s].size();i++)
		{
			
			if(hasPath(v, adj, adj[s].get(i), d, visited))
				return true;
		}
		
		return false;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	// print all paths from source to destination
	// using dfs
	// here backtracking is important
	static void printPath(Graph g, int s, int d)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean visited[] = new boolean[v];
		printPath(v, adj, s, d, visited, ""+ s);
	}
	
	static void printPath(int v, LinkedList<Integer>[] adj, int s,int d, boolean visited[], String psf)
	{
		if(visited[s])
			return;
		
		visited[s] = true;  
		
		if(s == d)
		{
			System.out.println(psf);
			visited[s] = false;    //IMP if making visited true before this step, otherwise no need for it
			return;
		}
		//visited[s] = true;
		for(int i=0; i < adj[s].size();i++)
		{
			if(visited[adj[s].get(i)] == false)
				printPath(v, adj, adj[s].get(i), d, visited, psf + " "+ adj[s].get(i));
			
		}
		
		visited[s] = false;
		

	}
	

	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		dfs(g, 2);
		
		
       Graph g1 = new Graph(7);
		
		g1.addEdge(0, 1);
		g1.addEdge(1, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 0);
		g1.addEdge(1, 2);
		g1.addEdge(2, 1);
		g1.addEdge(2, 3);
		g1.addEdge(3, 2);
		g1.addEdge(3, 4);
		g1.addEdge(4, 3);
		g1.addEdge(4, 5);
		g1.addEdge(5, 4);
		g1.addEdge(4, 6);
		g1.addEdge(6, 4);
		g1.addEdge(5, 6);
		g1.addEdge(6, 5);
		
		dfs(g1, 0);
		
		System.out.println(hasPath(g1, 0, 6));
		
		printPath(g1, 0, 6);

	}

}
