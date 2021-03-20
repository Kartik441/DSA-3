package graph;

import java.util.LinkedList;
// There is cycle in graph only if there is back edge present in the graph
// a back edge is an edge that is from a to itself(self-loop) or one of its ancestors in the tree produced
// by dfs

// Using dfs approach
// TC: O(V+E)
// SC: O(V)

public class DetectLoopDirected {
	
	static boolean cycle(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		
		for(int i=0;i<v;i++)
		{
			boolean visited[] = new boolean[v];
			if(dfs(v, adj, i, visited) == true)
				return true;
//			else
//				visited[i] = false;
		}
		return false;
	}
	
	static boolean dfs(int v, LinkedList<Integer>[] adj, int s, boolean visited[])
	{
		if(visited[s] == true)
			return true;
		
		visited[s] = true;
		for(int i=0; i<adj[s].size();i++)
		{
			int n = adj[s].get(i);
			
			if(visited[n] == true)     
				return true;
			else          // if not visited
				{
					if(dfs(v, adj, n, visited) == true)
						return true;
//					else
//						visited[n] = false;
				}
		}
		visited[s] = false;         // IMP: backtrack
		return false;
		
		
	}

	public static void main(String[] args) {
		

//		Graph g = new Graph(5);
//		g.addEdge(0, 1);
//		g.addEdge(2, 3);
//		g.addEdge(2, 1);
//		g.addEdge(3, 4);
//		g.addEdge(4, 0);
//		g.addEdge(4, 2);
		
//		Graph g = new Graph(4);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(1, 2);
//		g.addEdge(2, 0);
//		g.addEdge(2, 3);
//		g.addEdge(3, 3);
		
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
	
		
		System.out.println(cycle(g));
		
		Graph g1 = new Graph(6);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		g1.addEdge(5, 4);
		g1.addEdge(3, 5);
		g1.addEdge(4, 3);
		
		System.out.println(cycle(g1));

	}

}
