package graph;

import java.util.LinkedList;
import java.util.Stack;

// TS is only possible for directed acyclic graph
// from 0 indegree to 0 outdegree
// Or u->v , than u should be printed first than v
// TC:O(V+E)
// SC: O(V)    for stack
// topological sorting is mainly used for scheduling jobs from the given dependencies among jobs (more on gfg) 
// Questions: COURSE SCHEDULE 2
// Given courses with their prerequisite courses find the order of taking the course to cover all courses
// topological sort can not be computed for graph containing cycle
// if we remove the vertex and its edges in the topological sort order than graph still remains intact
// Hence, ts can be used for dp in graph in competitive programming
public class TopologicalSort {

// IMP: Order of work is reverse of topological sort	
	static void sort(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean visited[] = new boolean[v];
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<v;i++)
		{
			dfs(v, adj, i, visited,st);
		}
		
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	
	static void dfs(int v, LinkedList<Integer>[] adj, int s, boolean []visited, Stack<Integer> st)
	{
		if(visited[s] == true)
			return;
		
		visited[s] = true;
		
		for(int i=0;i<adj[s].size();i++)
		{
			dfs(v, adj, adj[s].get(i), visited, st);
		}
		// for any vertex all the vertices that this vertex depends on is already present in the stack
		// so this vertex can now be added
		st.push(s);
	}
	
	// Why not directly printing postorder ? Post order will print order of work not TS
	// Preorder ? Bcoz two different components might have dependency associated which preorder can not cover 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Graph g = new Graph(6);
////		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(0, 3);
//		g.addEdge(3, 1);
//		g.addEdge(4, 1);
//		g.addEdge(4, 2);
//		g.addEdge(5, 0);
//		g.addEdge(5, 2);
		
//		Graph g = new Graph(6);
////		g.addEdge(0, 1);
//		g.addEdge(2, 3);
//		g.addEdge(3, 1);
//		g.addEdge(4, 0);
//		g.addEdge(4, 1);
////		g.addEdge(4, 2);
//		g.addEdge(5, 0);
//		g.addEdge(5, 2);
//		
		
		Graph g = new Graph(7);
	g.addEdge(0, 1);
	g.addEdge(0, 3);
	g.addEdge(1, 2);
	g.addEdge(2, 3);
	g.addEdge(4, 3);
	g.addEdge(4, 5);
	g.addEdge(4, 6);
//	g.addEdge(4, 2);
	g.addEdge(5, 6);
	
		sort(g);

	}

}
