package graph;
// you are given a number n representing the number of persons. Each person will have an id from 0 to n-1
// you are given a number k representing number of clubs or number of groups
// in the next k line you are given two numbers which belong to the same group
// in how many ways we can select pair of two friends such that they don't belong to the same club
import java.util.ArrayList;
import java.util.LinkedList;

// we can use disjoint set for this
// here we will create a graph where people belonging to the same group will be one component of the
// graph and so on
// directly using the graph for now
public class PerfectFriends {
	// using approach of component
	// the idea is to know how many ways can we select two different clubs and than multiply with
	// persons in each club
	static void solve(Graph g)
	{
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		boolean vis[] = new boolean[v];
		// giving each vertex chance to cover as many vertex as possible by dfs
		ArrayList<ArrayList<Integer>> comps =new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			if(vis[i] == false)
			{
				ArrayList<Integer> comp = new ArrayList<>();
				dfs(v, adj, i, vis, comp);
				comps.add(comp);
			}
			
		}
		// here making combinations using size of each component
		int pairs = 0;
		for(int i=0;i<comps.size();i++)
		{
			for(int j=i+1; j<comps.size();j++)
			{
				pairs += comps.get(i).size() * comps.get(j).size();
			}
		}
		System.out.println(pairs);
	}
	
	static void dfs(int v, LinkedList<Integer> adj[], int s, boolean vis[], ArrayList<Integer> comp)
	{
		if(vis[s])
			return;
		
		vis[s] = true;
		comp.add(s);
		
		for(int i=0;i<adj[s].size();i++)
		{
			dfs(v, adj, adj[s].get(i), vis, comp);
		}
	}


	public static void main(String[] args) {
		

	}

}
