package graph;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition {
	
	// a bipartite graph is a graph whose vertices can be divided into 2 disjoint and independent sets U and V such that
	// every edge connects a vertex U to a vertex V
	
	// A bipartite graph can only have even edge length cycle
	
	// odd cycle will only be possible if there is an edge between 2 vertices in a SET but than the graph will no longer be 
	// bipartite
	
	// if there is no odd length ((cycle)) than graph is bipartite
	// every non cyclic graph is a bipartite
	// Conclusion: 1. Acyclic graph is bipartite
				// 2. Cyclic graph with even length is bipartite
				// 3. Cyclic graph with odd length is not bipartite
	// better way is to use graph coloring method by using only two colors to detect odd length cycle
	
	// we can use loop to check all components are colored in multi-component graph
	
	// TC : O(E + V)
	// E for making adjacency list and V for coloring
	
	
	static boolean possibleBipartite(int n, int [][] dislikes)
	{
		// creating undirected graph
		
		int v = n;
		LinkedList<Integer> adj[] = new LinkedList[n];
		
		for(int i=0; i<v;i++)
			adj[i] = new LinkedList();
		
		for(int i=0;i<dislikes.length;i++)
		{
			adj[dislikes[i][0]].add(dislikes[i][1]);
			adj[dislikes[i][1]].add(dislikes[i][0]);
		}
		
		// Using graph coloring
		// 0 for one color
		// 1 for second color
		
		int visited[] = new int[n]; 
		Arrays.fill(visited, -1);
		// after visiting(or putting the vertices in queue) color will be assigned and that color will
		// be stored in visited array
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		//int curr = 0;
		int color = 0;
		visited[0] = color;
		while(!q.isEmpty())
		{
			int curr = q.poll();
			// visit this node and assign color
			color = visited[curr];
			int assignColor = 1 - color;
			// this color has to be assigned to the adjacent nodes
			// push adjacent elements in queue
			for(int i=0;i<adj[curr].size(); i++)
			{
				// push into queue
				if(visited[adj[curr].get(i)] == -1)
				{
					q.offer(adj[curr].get(i));
					visited[adj[curr].get(i)] = assignColor;
				}
				
				// if it is already colored
				// than check if there is any ambiguity
				if(visited[adj[curr].get(i)] != assignColor)
					return false;											
			}
			
			
		}
		return true;
		
	}
	
//Another method could be to use bfs and for each odd level the elements belong to one set and 
	// for even to second set
	
	static class Pair
	{
		int v;
		int level;
		
		Pair(int v, int level)
		{
			this.level = level;
			this.v = v;
		}
	}
	
	static boolean solve(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		int visited[] = new int[v];
		
		Arrays.fill(visited, -1);
		// giving every vertex chance because graph might be having multiple components
		// and for given graph to be bipartite every component has to be bipartite
		
		for(int i=0;i<v;i++)
		{
			if(visited[i] == -1)
			{
				if(solveBFS(v, adj, i, visited) == false)
					return false;
			}
				
		}
		return true;
	}
	
	static boolean solveBFS(int v, LinkedList<Integer> adj[], int s, int visited[])
	{

		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(s, 0));
		
		while(q.size() > 0)
		{
			// r m* w a*
			Pair p = q.removeFirst();
			
			if(visited[p.v] == -1)        // visiting first time
			{
				visited[p.v] = p.level;    // adding the level in visited array to check after if needed    
			}
			else   // if visiting second time, means cycle is present
			{
				if(p.level != visited[p.v])        // if odd cycle than it will be +1, for even it will be equal
					return false;
			
			}
			
			for(int i=0;i < adj[p.v].size();i++)
			{
				if(visited[adj[p.v].get(i)] == -1)      //IMP:
					q.add(new Pair(adj[p.v].get(i), p.level+1));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
//		int a[] = {0, 1, 2, 1, 2, 3};
//		System.out.println(longestSubarray(a));
		
		int dislikes[][] = {
				{0, 1},
				{1, 2},
				{1, 3},
				{2, 4},
				{3, 4},
				
		};
		
		int di[][] = {
				{0, 1},
				{1, 3},
				{3, 4},
				{4, 2},
				{0, 2}
		};
		
		int dis[][] = {
				{0, 1},
				{1, 3},
				{3, 2},
				{0, 2},
		};
		
		System.out.println(possibleBipartite(5, dislikes));
		System.out.println(possibleBipartite(5, di));
		System.out.println(possibleBipartite(4, dis));

	}

}
