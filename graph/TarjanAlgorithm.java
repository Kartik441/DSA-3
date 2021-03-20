package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
// Tarjan Algoritm to find SCC 
// TC: O(V+E), does dfs only one time
// Efficient than kosaraju
public class TarjanAlgorithm {
	static int time = 0;
	static void SCC(Graph g)
	{
		int v = g.v;
		LinkedList adj[] = g.adj;
		int disc[] = new int[v];
		int low[] = new int[v];
		// low indicates what is the discovery time vertex which can be reached using this vertex
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		// we can use them as visited array also, so need to create separate visited array
		
		boolean stackMember[] = new boolean[v];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<v;i++)
		{
			if(disc[i] == -1)
			{
				dfs(i, adj, low, disc, stackMember, st);
			}
		}
			
	}
	
	static void dfs(int v,LinkedList<Integer> adj[], int low[], int disc[], boolean stMem[], Stack<Integer> st)
	{
		disc[v] = time;
		low[v] = time;
		time++;;
		stMem[v] = true;
		st.push(v);
		// traverse all vertices
		Iterator<Integer> i = adj[v].iterator();
		
		while(i.hasNext())
		{
			int n = i.next();
			if(disc[n] == -1)  // not visited yet
			{
				dfs(n, adj, low, disc, stMem, st);
				// on returning back update the low value
				low[v] = Math.min(low[v], low[n]);
			}
			else if(stMem[n] == true) // if back-edge
			{
				// update the value
				low[v] = Math.min(low[v], disc[n]);   // IMPORTANT
			}
		}
		// head node found, pop the stack and print SCC
		int w = -1;
		if(low[v] == disc[v])
		{
			while(w != v)
			{
				w = st.pop();
				System.out.print(w + " ");
				stMem[w] = false;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		SCC(g);


	}

}
