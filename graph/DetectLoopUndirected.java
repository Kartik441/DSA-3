package graph;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class DetectLoopUndirected {
	
	static boolean cycle(Graph g)
	{
		int v = g.v;
		LinkedList<Integer>[] adj= g.adj; 
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(dfs(v, adj, i, visited, -1) == true)
				return true;
		}
		return false;
	}
	
//	static boolean dfs(int v, LinkedList<Integer> []adj, int s, boolean visited[])
//	{
//		for(int n:visited)
//		{
//			System.out.print(n+" ");
//		}
//		System.out.println("s "+s);
//		if(visited[s] == 2)
//		{
//			//System.out.println(s + "Dhar liyaa");
//			return true;
//		}
//		
//		visited[s]++;
//		
//		for(int i=0;i<adj[s].size(); i++)
//		{
//			int n = adj[s].get(i);
//			
//			if(dfs(v, adj, n, visited) == true)
//				return true;
//			
//		}
//		return false;
//		
//	}
//	
	
	static boolean dfs(int v, LinkedList<Integer> []adj, int s, boolean visited[], int parent)
	{
		visited[s] = true;
		
		for(int i=0;i<adj[s].size(); i++)
			{
				int n = adj[s].get(i);
				
				if(visited[n] == true)   // possibility of cycle
				{
					if(parent != v)
					{
						return true;
					}
				}
				
				else
				{
					if(dfs(v, adj, n, visited, s))
						return true;
				}
				
			}
		
		return false;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////
	// using bfs
	
	static boolean solve(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean visited[] = new boolean[v];
		// giving every vertex chance because graph might be have multiple components
		
		for(int i=0;i<v;i++)
		{
			if(visited[i] == false)    //IMP:
			{
				if(solveUtil(v, adj, i, visited) == true)
				return true;
			}
		}
		return false;
	}
	
	static boolean solveUtil(int v, LinkedList<Integer> adj[], int s, boolean visited[])
	{
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(s);
		
		while(q.size() > 0)
		{
			// r m* w a*
			int p = q.removeFirst();
			
			if(visited[p] == true)
			{
				return true;
			}
			
			visited[p] = true;
			
			for(int i=0;i < adj[p].size();i++)
			{
				if(visited[adj[p].get(i)] == false)      //IMP:
					q.add(adj[p].get(i));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Graph g = new Graph(5);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
////		g.addEdge(0, 3);
//		g.addEdge(1, 0);
//		g.addEdge(2, 0);
//		g.addEdge(2, 3);
////		g.addEdge(3, 0);
//		g.addEdge(3, 2);
//		
//		System.out.println(cycle(g));
		
		
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
		
		System.out.println(solve(g));
		System.out.println(cycle(g));
	}

}
