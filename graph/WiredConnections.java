package graph;

import java.util.LinkedList;

public class WiredConnections {
	// the idea is to find number of components, and than to connect these components we need one less
	// wire than total number of components
	static int solve(int n, int edges[][])
	{
		int m = edges.length;
		if(m < n-1)
		{
			System.out.println(-1);
			return -1;   // if not enough wires
		}
		// create undirected graph
		LinkedList<Integer> adj[] = new LinkedList[n];
		for(int i=0;i<n;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++)
		{
			int a = edges[i][0];
			int b = edges[i][1];
			
			adj[a].add(b);
			adj[b].add(a);
			
		}
		
		boolean visited[] = new boolean[n];
		int comp = 0;
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				dfs(i, adj, visited);
				comp++;
			}
		}
		System.out.println(comp-1);
		return comp-1;
		
	}
	
	static void dfs(int v, LinkedList<Integer>[] adj, boolean vis[])
	{
		vis[v] = true;
		for(int i=0;i<adj[v].size();i++)
		{
			if(!vis[adj[v].get(i)])
			{
				dfs(adj[v].get(i), adj, vis);
			}
		}
		
	}

	public static void main(String[] args) {
		int conn[][] = {
				{0, 1},
				{0, 2},
				{1, 2}
		};
		int n = 4;
		solve(n, conn);
		
		int conn1[][] = {
				{0, 1},
				{0, 2},
				{0, 3},
				{1, 2},
				{1, 3}
		};
		int n1 = 6;
		solve(n1, conn1);
			
		int conn2[][] = {
				{0, 1},
				{0, 2},
				{0, 3},
				{1, 2},
		};
		int n2 = 6;
		solve(n2, conn2);
	}

}
