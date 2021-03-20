package graph;
// when all the vertex are visited only once in a path and edge is present between the last 
// vertex and the first vertex than that is called as hamiltonian cycle
// if that edge is not present than that path is called hamiltonian path

import java.util.HashSet;
import java.util.LinkedList;

// variation of print all paths
// the idea is find path using dfs and than finding if edge exists or not

public class HamiltonianCycle {
	// here os denotes original source which will help in finding the cycle
	static void solve(Graph g, int os)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		// using hashset instead of boolean array
		HashSet<Integer> visited = new HashSet<>();
		hamiltonian(v, adj, os, visited, ""+os, os);
	}
	
	static void hamiltonian(int v, LinkedList<Integer>[] adj, int s, HashSet<Integer> visited, String psf, int os)	
	{
		if(visited.contains(s))
			return;
		
		visited.add(s);  
		// IMP:making this base case after the adding this to visited array is important 
		if(visited.size() == v)
		{
			// finding if cycle is present
			for(int i=0; i < adj[s].size();i++)
			{
				if(adj[s].get(i) == os)          //if edge is present
				{
					System.out.println(psf);
				}
			}
			// backtrack
			visited.remove(s);    //IMP if making dest true before this step, otherwise no need for it
			return;
		}
		
		for(int i=0; i < adj[s].size();i++)
		{
			if(visited.contains(adj[s].get(i)) == false)
				hamiltonian(v, adj, adj[s].get(i), visited, psf + " "+ adj[s].get(i), os);
			
		}
		// backtrack
		visited.remove(s);
		

	}
	
	public static void main(String[] args) {
		
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
		g1.addEdge(2, 5);
		g1.addEdge(5, 2);
		
		solve(g1, 0);
		

	}

}
