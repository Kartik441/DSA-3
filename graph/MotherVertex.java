package graph;

import java.util.Arrays;
import java.util.LinkedList;

// mother vertex in directed graph is the vertex from which all other nodes of graph are reachable
// a graph can have no mv or more than one mv as well
// given a graph return any one mother vertex if present
// mv is only present in connected graph
// in undirected graph all vertex are mv if it is connected graph
public class MotherVertex {
	
	// brutefore : can use dfs from every node and check if all nodes are covered or not for every node
	// optimized : if there exists mother vertices, then one of the mother vertex
	// is the last finished vertex in DFS
	// last finished DFS vertex is one whose recursive calls for its DFS is over
	
	static void solve(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean vis[] = new boolean[v];
		int mv = -1;
		for(int i=0;i<v;i++)
		{
			if(!vis[i])
			{
				dfs(i, adj, vis);
				mv = i;
			}
		}
		// doing dfs again from assumed mv to do final check
		Arrays.fill(vis, false);
		
		dfs(mv, adj, vis);
		for(boolean check:vis)
			if(check == false)
			{
				System.out.println("No mother vertex"); 
				return;
			}
				
		System.out.println(mv);
		
		
	}
	
	
	
	static void dfs(int v, LinkedList<Integer> adj[],boolean vis[])
	{
		vis[v] = true;
		
		for(int i=0;i<adj[v].size();i++)
		{
			if(vis[adj[v].get(i)] == false)
				dfs(adj[v].get(i),adj,vis);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(1, 4);
		g.addEdge(5, 0);
		g.addEdge(5, 3);
		solve(g);

	}

}
